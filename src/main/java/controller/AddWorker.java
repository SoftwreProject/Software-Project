package controller;

import com.jfoenix.controls.JFXRadioButton;
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
    public void AddWorkers(TextField id, TextField name, TextField phone, TextField address, JFXRadioButton button, Label label) throws SQLException {


        if (id.getText().equals("") || name.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || !button.isSelected()) {
            label.setText("Please Fill All information About worker <3");
        } else {
            String s = "insert into WORKER values ('" + id.getText() + "'" + "," + "'" + name.getText() + "'" + "," + "'" + phone.getText() + "'" + "," + "'" + address.getText() + "'" + "," + "'" + button.getText() + "','" +  "available" + "')";
            try {
                ref.sql(s);
                label.setText("Worker Added Successfully");
                id.setText("");
                name.setText("");
                phone.setText("");
                address.setText("");
                button.setSelected(false);
            } catch (Exception ex) {
                label.setText("Use Another ID");
                new animatefx.animation.Shake(label).play();
            }
        }

    }
}
