package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import java.util.logging.Logger;

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
            JOptionPane.showMessageDialog(null, "Please Enter Another ID");
        else {
            if (EmptyTextField()) {
                JOptionPane.showMessageDialog(null, "Please Fill All Information");
            } else {

                if (SignUpPassword.getLength() <= 5)
                    JOptionPane.showMessageDialog(null, "Please Enter more than 5 Characters or numbers");
                else {
                    String s = "insert into CUSTOMER values ( '" + SignUpID.getText() + "','" + SignUpName.getText()
                            + "','" + SignUpPhoneNumber.getText() + "','" + SignUpAddress.getText() + "','" + SignUpCity.getText() +
                            "','" + SignUpStreet.getText() + "','" + SignUpEmail.getText() + "','" + SignUpPassword.getText() + "','" + "0" + "') ";
                    ref.sql(s);
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                    ClearTextField();

                }
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
    public boolean EmptyTextField() {
         return SignUpID.getText().isEmpty() ||
                SignUpName.getText().isEmpty() ||
                SignUpPhoneNumber.getText().isEmpty() ||
                SignUpAddress.getText().isEmpty() ||
                SignUpEmail.getText().isEmpty() ||
                SignUpPassword.getText().isEmpty() ||
                SignUpStreet.getText().isEmpty() ||
                SignUpCity.getText().isEmpty();
    }
    public boolean booleanTest (String id, String name, String PhoneNumber , String address , String City , String Street,String email , String password) {
         return id.isEmpty() ||
                name.isEmpty() ||
                PhoneNumber.isEmpty() ||
                address .isEmpty() ||
                City.isEmpty() ||
                Street.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty();
    }
    public String SignUpTest (String id, String name, String PhoneNumber , String address , String City , String Street,String email , String password) {
        int flag = 0;
        String result;
        try {
            if (booleanTest(id ,name , PhoneNumber, address , City , Street , email , password))
                flag = 1;
            else {
                if (ShowID(id))
                    flag = 2;
                else {
                    if (password.length() <= 5)
                        flag =3;
                    else {
                        String s = "insert into CUSTOMER values ( '" + id + "','" + name
                                + "','" + PhoneNumber + "','" + address + "','" + City +
                                "','" + Street + "','" + email + "','" + password + "','" + "0" + "') ";
                        ref.sql(s);
                    }
                }
            }
        }catch (Exception ex) {
            Logger.getLogger("You are in signup page");
        }

        if (flag == 1)
            result = "Empty one or more term";
        else if (flag == 2)
            result = "Use another id";
        else if (flag == 3)
            result = "Enter a password more than 5 character";
        else
            result = "The Customer Added Successfully";
        return result;
    }
 }