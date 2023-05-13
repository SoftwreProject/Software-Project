package controller;

import java.io.IOException;
import java.sql.*;
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

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label wrongMessage;

    @FXML
    Pane signingPane;
    String style = "-fx-background-color: #000000; -fx-border-width: 0 0 2 0; -fx-border-color: red; -fx-text-inner-color: white";

    public void loginFunction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if (username.isEmpty() && password.isEmpty()) {
            handleEmptyCredentials();
        } else if (!username.isEmpty() && password.isEmpty()) {
            handleEmptyPassword();
        } else if (username.isEmpty()) {
            handleEmptyUsername();
        } else {
            authenticateUser(username, password, event);
        }
    }
    public void authenticateUser(String username, String password, ActionEvent event) {
        try {
            int flag ;
            int managerUserName = 0;

            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();

            flag = authenticateManager(conn, username, password);
            if (flag == 0) {
                flag = authenticateCustomer(conn, username, password);
            }

            if (flag == 1) {
                openHomePage(managerUserName, "/HomePage.fxml", event);
            } else if (flag == 2) {
                openCustomerHomePage(username, "/CustomerHomePage.fxml", event);
            } else {
                handleInvalidCredentials();
            }
        } catch (SQLException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private int authenticateManager(Connection conn, String username, String password) throws SQLException {
        try (PreparedStatement stm = conn.prepareStatement("SELECT ID, PASSWORD FROM MANAGER WHERE ID = ?")) {
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    return 1; // for manager
                }
            }
        }
        return 0;
    }

    private int authenticateCustomer(Connection conn, String username, String password) throws SQLException {
        try (PreparedStatement stm = conn.prepareStatement("SELECT ID, PASSWORD FROM CUSTOMER WHERE ID = ?")) {
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    return 2; // for customer
                }
            }
        }
        return 0;
    }
    private void handleEmptyCredentials() {
        usernameTextField.setStyle(style);
        passwordTextField.setStyle(style);
        new animatefx.animation.Shake(usernameTextField).play();
        new animatefx.animation.Shake(passwordTextField).play();
        wrongMessage.setText("Empty UserName and Password!!");
    }
    private void handleEmptyPassword() {
        usernameTextField.setStyle("-fx-background-color: #000000; -fx-border-width: 0 0 2 0; -fx-border-color: #fac355; -fx-text-inner-color: white");
        passwordTextField.setStyle(style);
        new animatefx.animation.Shake(passwordTextField).play();
        wrongMessage.setText("Empty Password!!");
    }

    private void handleEmptyUsername() {
        usernameTextField.setStyle(style);
        passwordTextField.setStyle("-fx-background-color: #000000; -fx-border-width: 0 0 2 0; -fx-border-color: #fac355; -fx-text-inner-color: white");
        new animatefx.animation.Shake(usernameTextField).play();
        wrongMessage.setText("Empty UserName!!");
    }
    private void handleInvalidCredentials() {
        new animatefx.animation.Flash(usernameTextField).play();
        new animatefx.animation.Flash(passwordTextField).play();
        wrongMessage.setText("Wrong password or username");
    }
    private void openHomePage(int managerUserName, String resourcePath, ActionEvent event) throws IOException {
        Stage stage = (Stage) signingPane.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
        Parent root = loader.load();
        HomePage ref = loader.getController();
        ref.managerId = managerUserName;
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        stage1.show();
    }

    private void openCustomerHomePage(String username, String resourcePath, ActionEvent event) throws IOException {
        Stage stage = (Stage) signingPane.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
        Parent root = loader.load();
        CustomerHomePage ref = loader.getController();
        ref.idSinging = username;
        ref.setName(username);
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        stage1.show();
    }

    public void signUP() throws IOException {
        Stage stage = (Stage) signingPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
        Parent root = loader.load();
        new animatefx.animation.ZoomIn(root).play();
        signingPane.getChildren().setAll(root);
        stage.setTitle("SignUp :)");
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








