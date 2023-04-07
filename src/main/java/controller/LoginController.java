package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.jdbc.pool.OracleDataSource;

public class LoginController {
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label wrongMessage;

    @FXML
    private Pane LoginPane;
    public LoginController(){}


    public void Login(ActionEvent event) throws Exception {
        int Managerusername = 0;
        int flag = -1;
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if ((username.equals("") && password.equals("")) ) {
            usernameTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red");
            passwordTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red");
//            new animatefx.animation.Shake(usernameTextField).play();
//            new animatefx.animation.Shake(passwordTextField).play();
            wrongMessage.setText("Empty UserName and Password!!");
        }
        else if (!username.equals("") && password.equals("")){
//          passwordTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red");
//            new animatefx.animation.Shake(passwordTextField).play();
            wrongMessage.setText("Empty Password!!");
        }
        else if (username.equals("") && !password.equals("")){
            usernameTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red");
            passwordTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color : #0D0332");
//            new animatefx.animation.Shake(usernameTextField).play();
            wrongMessage.setText("Empty UserName!!");
        }
        else {
            wrongMessage.setText("");
            usernameTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color :  #0D0332");
            passwordTextField.setStyle("-fx-background-color: #D1E0E4 ; -fx-border-width:0 0 2 0 ; -fx-border-color :  #0D0332");
            try {
                Managerusername = Integer.parseInt(usernameTextField.getText());
            } catch (Exception ex) { }

            String Query1 = "SELECT MNAGERID , PASSWORD FROM MANAGER WHERE MNAGERID" +
                    " = " + Managerusername + "";
            ResultSet rs = stm.executeQuery(Query1);
            while (rs.next()) {
                if (usernameTextField.getText().equals(rs.getString(1)) &&  passwordTextField.getText().equals(rs.getString(2))) {
                     flag = 1; // for manager
                    Managerusername = rs.getInt(1);
                    password = rs.getString(2);
                }
            }
            if (flag == 1) {
                //JOptionPane.showMessageDialog(null, "Truee1");
                Stage stage = (Stage) LoginPane.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomePage.fxml"));
                Parent root = loader.load();
                HomePage ref = loader.getController();
//                ref.managerid = Managerusername;
                Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene1 = new Scene(root);
                stage1.setScene(scene1);
                stage1.setResizable(false);
                stage1.show();




            }
            else{

                wrongMessage.setText("Username or Password is Incorrect");
            }


        }


    }







}
