package controller;

import javafx.event.ActionEvent;
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
    private TextField CustomerID;
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
    void sendEmailToTheCustomer(ActionEvent event) throws SQLException, MessagingException {
        int flag=-1;
        String customerEmail="";
        String Query = "SELECT * FROM Customer WHERE ID = '" + CustomerID.getText() + "'" ;


        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(Query);
//        JOptionPane.showMessageDialog(null,rs.getString(1)+"");
        while (rs.next()){
            if(rs.getString(1).equals(CustomerID.getText()+"")){
                customerEmail=rs.getString(7);
                flag=1;
            }
            else {
                flag =0;
            }
        }


        if (flag == 1) {
            setup(); // Call the setup method before sending the email
            draft(customerEmail);
            sendemail();
            errorMessageLabel.setText("The email has been sent successfully");
        } else {
            errorMessageLabel.setText("Customer Not Found");
        }
    }
    public void sendemail() throws NoSuchProviderException, MessagingException {
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
    public MimeMessage draft(String email) throws AddressException, MessagingException {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String[] emailReceipients = {email};  //Enter list of email recepients
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
