package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

public class LoginController{
    private Pane loginPane;
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label wrongMessage;

    @FXML
    Pane signingPane;
    public void loginFunction(ActionEvent event){
        try {
            int flag = 0;
            int managerUserName = 0;
            String username;
            String password;
            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();
            try (Statement stm = conn.createStatement()) {
                 username = usernameTextField.getText();
                 password = passwordTextField.getText();
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

                } else if (username.equals("")) {
                    usernameTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : red ; -fx-text-inner-color: white");
                    passwordTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color :  #fac355 ; -fx-text-inner-color: white");
                    new animatefx.animation.Shake(usernameTextField).play();
                    wrongMessage.setText("Empty UserName!!");

                } else {

                    wrongMessage.setText("");
                    usernameTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : #fac355 ;-fx-text-inner-color: white ");
                    passwordTextField.setStyle("-fx-background-color: #000000 ; -fx-border-width:0 0 2 0 ; -fx-border-color : #fac355; -fx-text-inner-color: white");

                    String query1 = "SELECT ID , PASSWORD FROM MANAGER WHERE ID = '" + usernameTextField.getText() + "'";
                    String query2 = "SELECT ID , PASSWORD FROM CUSTOMER WHERE ID = '" + usernameTextField.getText() + "'";

                    ResultSet rs = stm.executeQuery(query1);

                    while (rs.next()) {
                        if (usernameTextField.getText().equals(rs.getString(1)) && passwordTextField.getText().equals(rs.getString(2))) {
                            flag = 1; // for manager
                            username = rs.getString(1);
                        }
                    }

                    rs = stm.executeQuery(query2);
                    while (rs.next()) {
                        if (usernameTextField.getText().equals(rs.getString(1)) && passwordTextField.getText().equals(rs.getString(2))) {
                            flag = 2; // for Customer
                            username = rs.getString(1);
                        }
                    }

                    if (flag == 1) {
                        Stage stage = (Stage) signingPane.getScene().getWindow();
                        stage.close();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomePage.fxml"));
                        Parent root = loader.load();
                        HomePage ref = loader.getController();
                        ref.managerid = managerUserName;
                        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene1 = new Scene(root);
                        stage1.setScene(scene1);
                        stage1.setResizable(false);
                        stage1.show();

                    } else if (flag == 2) {
                        Stage stage = (Stage) signingPane.getScene().getWindow();
                        stage.close();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CustomerHomePage.fxml"));
                        Parent root = loader.load();
                        CustomerHomePage ref = loader.getController();
                        ref.idSinging = username;
                        ref.setName();
//                    ref.setDate();
                        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene1 = new Scene(root);
                        stage1.setScene(scene1);
                        stage1.setResizable(false);
                        stage1.show();
                    } else {
                        new animatefx.animation.Flash(usernameTextField).play();
                        new animatefx.animation.Flash(passwordTextField).play();
                        wrongMessage.setText("Wrong password or username");

                    }

                }
            }catch (Exception ex) {
                Logger.getLogger("You are in Signing page");
            }
            } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }


    }

    public void signUP() throws IOException {
        Stage stage = (Stage) signingPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
        Parent root = loader.load();
        new animatefx.animation.ZoomIn(root).play();
        signingPane.getChildren().setAll(root);
        stage.setTitle("SignUp");
        stage.show();
    }

    public int signInTest(String username, String password) throws SQLException {

        int flag = 0;
        if (username.isEmpty() || password.isEmpty()) {
            flag = 1;
        } else {
            SignUp ref = new SignUp();
            String query1 = "SELECT ID , PASSWORD FROM MANAGER WHERE ID = '" + username + "'";
            String query2 = "SELECT ID , PASSWORD FROM CUSTOMER WHERE ID = '" + username + "'";

            ResultSet rs = ref.sql(query1);

            while (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    flag = 2; // for manager
                }
            }

            rs = ref.sql(query2);
            while (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    flag = 2; // for Customer

                }
            }
        }
        return flag;
    }

    public String getResult(int flag) {
        String result = "";
        if (flag == 1)
            result = "Empty Password or username";
        else if (flag == 2) {
            result = "Access your account successfully";
        } else if (flag == 0)
            result = "wrong password or username";

        return result;
    }
}








