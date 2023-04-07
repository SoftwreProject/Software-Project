package controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import oracle.jdbc.datasource.impl.OracleDataSource;
import software.Customers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddCustomer {
    String result;
    int flag = 0;

//    @FXML
//    private TextField nameTextField;
//    @FXML
//    private TextField phoneTextField;
//    @FXML
//    private TextField addressTextField;
//    @FXML
//    private TextField cityTextField;
//    @FXML
//    private TextField streetTextField;
//    @FXML
//    private Button addbutton;
//    @FXML

//    @FXML
//    private AnchorPane anchor;

    public void sql (String s){

    }
    @FXML
    public void addcustomer(SimpleStringProperty id, SimpleStringProperty name, SimpleStringProperty phone, SimpleStringProperty address, SimpleStringProperty city, SimpleStringProperty street , SimpleStringProperty email) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();
        if (id.get().equals("") || name.get().equals("") || phone.get().equals("") || address.get().equals("") || city.get().equals("") || street.get().equals("") || email.get().equals("")) {
               flag = 1;

        } else {
            String s = "insert into CUSTOMER values ( '" + id.get() +"','" + name.get() +"','" + phone.get() +"','" + address.get() +"','" +city.get() +"','" + street.get() +"','" + email.get() + "')";
            try {
                stm.executeUpdate(s);
                flag = 0;
            }catch (Exception ex){
                flag = 2;
            }


        }
    }
    @FXML

    public String GetResult() {
        if (flag == 1)
            result = "Please fill in all information about yourself";
        else if (flag == 2)
            result = "Please Enter a new ID";
        else result = "the customer added successfully";
        return result;

    }
    @FXML
    void addcustomer(ActionEvent event) {

    }

}
