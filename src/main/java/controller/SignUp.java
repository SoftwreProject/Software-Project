package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oracle.jdbc.datasource.impl.OracleDataSource;
import software.Customers;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class SignUp {

    @FXML
    private Pane signUpPane;
    @FXML
    private TextField signUpID;
    @FXML
    private TextField signUpName;
    @FXML
    private TextField signUpPhoneNumber;
    @FXML
    private TextField signUpAddress;
    @FXML
    private TextField signUpCity;
    @FXML
    private TextField signUpStreet;
    @FXML
    private TextField signUpEmail;
    @FXML
    private PasswordField signUpPassword;
    AddCustomer ref = new AddCustomer();
    @FXML
    void backToSignIn() throws IOException {
        Stage stage = (Stage) signUpPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
        Parent root = loader.load();
        new animatefx.animation.ZoomIn(root).play();
        signUpPane.getChildren().setAll(root);
        stage.show();
    }
    @FXML
    void signUpButton() throws SQLException {
        String id = signUpID.getText();
        if (showID(id))
            JOptionPane.showMessageDialog(null, "Please Enter Another ID");
        else {
            if (emptyTextField()) {
                JOptionPane.showMessageDialog(null, "Please Fill All Information");
            } else {

                if (signUpPassword.getLength() <= 5)
                    JOptionPane.showMessageDialog(null, "Please Enter more than 5 Characters or numbers");
                else {
                    String s = "insert into CUSTOMER values ( '" + signUpID.getText() + "','" + signUpName.getText()
                            + "','" + signUpPhoneNumber.getText() + "','" + signUpAddress.getText() + "','" + signUpCity.getText() +
                            "','" + signUpStreet.getText() + "','" + signUpEmail.getText() + "','" + signUpPassword.getText() + "','" + "0" + "') ";
                    ref.sql(s);
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                    clearTextField();

                }
            }
        }
    }

    public boolean showID(String id) throws SQLException {
        String query = "SELECT ID FROM Customer";
        ResultSet rs =  sql(query);
        while (rs.next()){
            if (id.equals(rs.getString(1)))
                return true;
        }
        return false;
    }
    public void clearTextField() {
        signUpID.setText("");
        signUpName.setText("");
        signUpPhoneNumber.setText("");
        signUpAddress.setText("");
        signUpCity.setText("");
        signUpStreet.setText("");
        signUpEmail.setText("");
        signUpPassword.setText("");
    }
    public ResultSet sql(String x) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        try (Statement st = conn.createStatement()) {
            return st.executeQuery(x);
        }
    }
    public boolean emptyTextField() {
         return signUpID.getText().isEmpty() ||
                signUpName.getText().isEmpty() ||
                signUpPhoneNumber.getText().isEmpty() ||
                signUpAddress.getText().isEmpty() ||
                signUpEmail.getText().isEmpty() ||
                signUpPassword.getText().isEmpty() ||
                signUpStreet.getText().isEmpty() ||
                signUpCity.getText().isEmpty();
    }
    public boolean booleanTest (String id, String name, String phoneNumber , String address ) {
         return id.isEmpty() ||
                name.isEmpty() ||
                phoneNumber.isEmpty() ||
                address .isEmpty();

    }
    public boolean booleanTest2 (String city , String street, String email , String password) {
        return city.isEmpty() ||
                street.isEmpty()||
                email.isEmpty()||
                password.isEmpty();
    }
    public String signUpTest (Customers customers) {
        int flag = 0;
        String result;
        try {
            if (booleanTest(customers.getId() ,customers.getName() , customers.getPhone(), customers.getAddress() ) && booleanTest2(customers.getCity(), customers.getStreet() , customers.getEmail(), customers.getPassword()))
                flag = 1;
            else {
                if (showID(customers.getId()))
                    flag = 2;
                else {
                    if (customers.getPassword().length() <= 5)
                        flag =3;
                    else {
                        String s = "insert into CUSTOMER values ( '" + customers.getId() + "','" + customers.getName()
                                + "','" + customers.getPhone() + "','" + customers.getAddress() + "','" + customers.getCity() +
                                "','" + customers.getStreet() + "','" + customers.getEmail() + "','" + customers.getPassword() + "','" + "0" + "') ";
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