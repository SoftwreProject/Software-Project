package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;


public class SendEmail {
    Session newSession;
    MimeMessage mimeMessage;

    @FXML
    private TextField CustomerID;
    @FXML
    private Label errorMessageLabel;
    String customerName="";

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
                customerName=rs.getString(2);
                flag=1;
            }
            else {
                flag =0;
            }
        }


        if(flag==1){
            SendEmail s =new SendEmail();
            s.setup();
            s.draft(customerEmail,customerName);
            s.sendemail();
            errorMessageLabel.setText("The email has been sent successfully");

        }
        else{
            errorMessageLabel.setText("Customer Not Found");
        }



    }
    private void setup() {

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);

    }
    private void sendemail() throws NoSuchProviderException, MessagingException {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String fromUser = "cleaning.services7890@gmail.com";  //Enter sender email id
        String fromUserPassword = "flhnsjbxlxddizsj";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }
    private MimeMessage draft( String email ,String customerName) throws AddressException, MessagingException {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String[] emailReceipients = {email};  //Enter list of email recepients
        String emailSubject = "Your Order has been completed";
        String emailBody = "Hi "+customerName+" Your Order has been completed <3";
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
