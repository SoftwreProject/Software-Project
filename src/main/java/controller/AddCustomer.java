package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import oracle.jdbc.datasource.impl.OracleDataSource;
import software.Customers;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class AddCustomer {
    String result;
    int flag = 0;

    public void sql(String s) throws SQLException {

        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        try ( Statement stm = conn.createStatement()) {
            stm.executeUpdate(s);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @FXML
    public void addCustomerTest(Customers customers)  {

        if (customers.getId().equals("") || customers.getName().equals("") || customers.getPhone().equals("") || customers.getAddress().equals("") || customers.getCity().equals("") || customers.getStreet().equals("") || customers.getEmail().equals("") || customers.getPassword().equals("")) {
            flag = 1;
        } else {
            String s = "insert into CUSTOMER values ( '" + customers.getId() + "','" +  customers.getName()
                    + "','" + customers.getPhone() + "','" + customers.getAddress()
                    + "','" + customers.getCity() + "','" + customers.getStreet() + "','" + customers.getEmail()
                    + "','" + customers.getPassword() + "','" + "0" + "') ";
            try {
                sql(s);
                flag = 0;
            } catch (Exception ex) {
                flag = 2;
                Logger.getLogger("You are in add customer");
            }


        }
    }


    @FXML
    public String getResult() {
        if (flag == 1)
            result = "Please fill in all information about yourself";
        else if (flag == 2)
            result = "Please Enter a new ID";
        else result = "the customer added successfully";
        return result;

    }

    public String addCustomerGUI(Customers customers) {
        int flag = 0;
        String x = "";
//        Label label = new Label();
        if (customers.getId().equals("") || customers.getName().equals("")
                || customers.getPhone().equals("") || customers.getAddress().equals("")
                || customers.getCity().equals("") || customers.getStreet().equals("") ||
                customers.getEmail().equals("") || customers.getPassword().equals("")) {
//            label.setText("Please Enter All information");
            flag = 1;
        } else {
            String s = "insert into CUSTOMER values ( '" + customers.getId() + "','" + customers.getName()
                    + "','" + customers.getPhone() + "','" + customers.getAddress()
                    + "','" + customers.getCity() + "','" + customers.getStreet()
                    + "','" + customers.getEmail() + "','" + customers.getPassword() + "')";
//            label.setText("Customer Added Successfully");
            try {
                sql(s);
            } catch (Exception ex) {
//                label.setText("Use Another ID");
                flag = 3;
//                new animatefx.animation.Shake(label).play();
            }
        }
        if (flag == 1)
            x = "Please fill in all information about yourself";
        else if (flag == 0)
            x = "the customer added successfully";
        else x = "Please Enter a new ID";

        return x;
    }
}
