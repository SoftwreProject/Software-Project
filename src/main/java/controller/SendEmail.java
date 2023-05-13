package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.pool.OracleDataSource;

import javax.mail.*;
import javax.mail.internet.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class SendEmail {
    Session newSession;
    MimeMessage mimeMessage;

    @FXML
    private TextField customerId;
    @FXML
    public Label errorMessageLabel;
    public void setup() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }

    @FXML
    void sendEmailToTheCustomer() throws SQLException, MessagingException {
        int flag=-1;
        String customerEmail="";
        String query = "SELECT * FROM Customer WHERE ID = '" + customerId.getText() + "'" ;


        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        try (Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                if (rs.getString(1).equals(customerId.getText() + "")) {
                    customerEmail = rs.getString(7);
                    flag = 1;
                } else
                    flag = 0;
            }
        }
        if (flag == 1) {
            setup();
            draft(customerEmail);
            sendemail();
            errorMessageLabel.setText("The email has been sent successfully");
        } else {
            errorMessageLabel.setText("Customer Not Found");
        }
    }
    public void sendemail() throws MessagingException {
        String fromUser = "cleaning.services7890@gmail.com";
        String fromUserPassword = "z";
        String emailHost = "smtp.gmail.com";
        if (newSession != null) {
            Transport transport = newSession.getTransport("smtp");
            transport.connect(emailHost, fromUser, fromUserPassword);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } else {
            throw new IllegalStateException("Session is not set up. Call the setup method before sending the email.");
        }
    }
    public MimeMessage draft(String email) throws MessagingException {
        String[] emailReceipients = {email};
        String emailSubject = "Your Order has been completed";
        String emailBody = "Your order has been completed successfully. You can collect your product from the showroom";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
        mimeMessage.setSubject(emailSubject);
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody,"text/html;charset=utf-8");
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;

    }

}
