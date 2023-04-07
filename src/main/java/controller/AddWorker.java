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
    @FXML
    private ResourceBundle resources;
//
    @FXML
    private URL location;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField specializationTextField;

    @FXML
    private Button addWorkerButton;

    @FXML
    private Label confirmOperationLabel;


    public void addWorker(ActionEvent event) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();

        if(idTextField.getText().equals("") || nameTextField.getText().equals("") || phoneTextField.getText().equals("") || addressTextField.getText().equals("")|| specializationTextField.getText().equals("")){
            confirmOperationLabel.setText("Please Fill All information About worker <3");
        }
        else{

            String s = "insert into WORKER values ('"+idTextField.getText()+"'"+","+"'"+nameTextField.getText()+"'"+","+"'"+phoneTextField.getText()+"'"+","+"'"+addressTextField.getText()+"'"+","+"'"+specializationTextField.getText()+"')";
            try {
                stm.executeUpdate(s);
                confirmOperationLabel.setText("The Worker has been added successfully");
                idTextField.setText("");
                nameTextField.setText("");
                phoneTextField.setText("");
                addressTextField.setText("");
                specializationTextField.setText("");
            }
            catch (Exception ex){
                System.out.println(ex.toString());
            }
        }
    }



}
