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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;


public class AddWorker {
    AddCustomer ref = new AddCustomer();
    public void AddWorkers(TextField id, TextField name, TextField phone, TextField address, TextField specialization, Label label) throws SQLException {


        if (id.getText().equals("") || name.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || specialization.getText().equals("")) {
            label.setText("Please Fill All information About worker <3");
        } else {
            String s = "insert into WORKER values ('" + id.getText() + "'" + "," + "'" + name.getText() + "'" + "," + "'" + phone.getText() + "'" + "," + "'" + address.getText() + "'" + "," + "'" + specialization.getText() + "')";
            try {
                ref.sql(s);
                label.setText("Worker Added Successfully");
                id.setText("");
                name.setText("");
                phone.setText("");
                address.setText("");
                specialization.setText("");
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }

    }
}
