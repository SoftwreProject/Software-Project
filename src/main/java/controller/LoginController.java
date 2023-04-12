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

    public LoginController() {
    }


    public void Login(ActionEvent event) throws Exception {
        int flag = 0;
        int Managerusername = 0;
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if ((username.equals("") && password.equals(""))) {
            usernameTextField.setStyle("-fx-background-color:  #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red ; -fx-text-inner-color: white");
            passwordTextField.setStyle("-fx-background-color:  #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red ;-fx-text-inner-color: white");
            new animatefx.animation.Shake(usernameTextField).play();
            new animatefx.animation.Shake(passwordTextField).play();
            wrongMessage.setText("Empty UserName and Password!!");
        } else if (!username.equals("") && password.equals("")) {
            usernameTextField.setStyle("-fx-background-color:  #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color :#fac355 ; -fx-text-inner-color: white ");
            passwordTextField.setStyle("-fx-background-color:  #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red ; -fx-text-inner-color: white");
            new animatefx.animation.Shake(passwordTextField).play();
            wrongMessage.setText("Empty Password!!");
        } else if (username.equals("") && !password.equals("")) {
            usernameTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red ; -fx-text-inner-color: white");
            passwordTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color :  #fac355 ; -fx-text-inner-color: white");
            new animatefx.animation.Shake(usernameTextField).play();
            wrongMessage.setText("Empty UserName!!");
        } else {
            wrongMessage.setText("");
            usernameTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : #fac355");
            passwordTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : #fac355");
            try {
                Managerusername = Integer.parseInt(usernameTextField.getText());
            } catch (Exception ex) {
            }
            String Query1 = "SELECT ID , PASSWORD FROM MANAGER WHERE ID = " + Managerusername + "";
            String Query2 = "SELECT ID , PASSWORD FROM CUSTOMER WHERE ID = '" + usernameTextField.getText() + "'";

            ResultSet rs = stm.executeQuery(Query1);

            while (rs.next()) {
                if (usernameTextField.getText().equals(rs.getString(1)) && passwordTextField.getText().equals(rs.getString(2))) {
                    flag = 1; // for manager
                    Managerusername = rs.getInt(1);
                    password = rs.getString(2);
                    //JOptionPane.showMessageDialog(null, "Truee");
                }
            }

            rs = stm.executeQuery(Query2);
            while (rs.next()) {
                if (usernameTextField.getText().equals(rs.getString(1)) && passwordTextField.getText().equals(rs.getString(2))) {
                    flag = 2; // for Customer
                    username = rs.getString(1);
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
                ref.managerid = Managerusername;
//                ref.Date();
                Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene1 = new Scene(root);
                stage1.setScene(scene1);
                stage1.setResizable(false);
                stage1.show();

            } else if (flag == 2) {
                Stage stage = (Stage) LoginPane.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomePage.fxml"));
                Parent root = loader.load();
//                T_TeacherPageController ref = loader.getController();
//                ref.username = username;
//                ref.welcome();
//                ref.initi();
                Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene1 = new Scene(root);
                stage1.setScene(scene1);
                stage1.setResizable(false);
                stage1.show();
            }

        }
    }
}








