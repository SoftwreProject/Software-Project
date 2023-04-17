package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oracle.jdbc.datasource.impl.OracleDataSource;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {

    @FXML
    private Pane SignUpPane;
    @FXML
    private TextField SignUpID;
    @FXML
    private TextField SignUpName;
    @FXML
    private TextField SignUpPhoneNumber;
    @FXML
    private TextField SignUpAddress;
    @FXML
    private TextField SignUpCity;
    @FXML
    private TextField SignUpStreet;
    @FXML
    private TextField SignUpEmail;
    @FXML
    private PasswordField SignUpPassword;
    AddCustomer ref = new AddCustomer();
    @FXML
    void BackToSignIn(ActionEvent event) throws IOException {
        Stage stage = (Stage) SignUpPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
        Parent root = loader.load();
        new animatefx.animation.ZoomIn(root).play();
        SignUpPane.getChildren().setAll(root);
        stage.show();
    }
    @FXML
    void SignUpButton(ActionEvent event) throws SQLException {
        String Id = SignUpID.getText();
        if (ShowID(Id))
            JOptionPane.showMessageDialog(null,"Please Enter Another ID");
        else {
            if (SignUpPassword.getLength() <= 5)
                JOptionPane.showMessageDialog(null,"Please Enter more than 5 Characters or numbers");
            else {
                String s = "insert into CUSTOMER values ( '" + SignUpID.getText() + "','" + SignUpName.getText()
                        + "','" + SignUpPhoneNumber.getText() + "','" + SignUpAddress.getText() + "','" + SignUpCity.getText() +
                        "','" + SignUpStreet.getText() + "','" + SignUpEmail.getText() + "','" + SignUpPassword.getText() + "','" + "0" +"') ";
                ref.sql(s);
                JOptionPane.showMessageDialog(null,"Customer Added Successfully");
                ClearTextField();

            }
        }

    }
    public boolean ShowID(String id) throws SQLException {
        String query = "SELECT ID FROM Customer";
        ResultSet rs =  sql(query);
        while (rs.next()){
            if (id.equals(rs.getString(1)))
                return true;
        }
        return false;
    }
    public void ClearTextField() {
        SignUpID.setText("");
        SignUpName.setText("");
        SignUpPhoneNumber.setText("");
        SignUpAddress.setText("");
        SignUpCity.setText("");
        SignUpStreet.setText("");
        SignUpEmail.setText("");
        SignUpPassword.setText("");
    }
    public ResultSet sql(String x) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(x);
        return rs;
    }
}