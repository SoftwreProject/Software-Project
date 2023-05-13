package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import io.cucumber.java.sl.In;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import software.Customers;
import software.Product;
import software.Worker;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class AddAll implements Initializable {


    @FXML
    private TextField workerID;
    @FXML
    private TextField workerName;
    @FXML
    private TextField workerPhone;
    @FXML
    private TextField workerAddress;
    @FXML
    private TextField customerID;
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerPhone;
    @FXML
    private TextField customerAddress;
    @FXML
    private TextField customerCity;
    @FXML
    private TextField customerStreet;
    @FXML
    private TextField customerEmail;
    @FXML
    private TextField customerPassword;
    @FXML
    private TextField productID;
    @FXML
    private TextField productHigh;
    @FXML
    private TextField productWidth;
    @FXML
    private TextField productOwner;
    @FXML
    private JFXRadioButton coversRadioButton;
    @FXML
    private JFXRadioButton carpetsRadioButton;
    @FXML
    private JFXRadioButton workerRadioButton;
    @FXML
    private JFXRadioButton customerRadioButton;
    @FXML
    private JFXButton add;
    @FXML
    private Label label;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXRadioButton workerSpecCovers;
    @FXML
    private JFXRadioButton workerSpecCarpets;
    @FXML
    private JFXComboBox <String> workerCombobox;
    AddWorker worker = new AddWorker();
    AddCustomer customer = new AddCustomer();
    AddProduct product = new AddProduct();
    AddCustomer addCustomer = new AddCustomer();
    SignUp ref = new SignUp();
    String result;
    String newID = "Please Enter The ID";
    SimpleDateFormat formatter;
    SimpleDateFormat formatter1;
    Date date;
    int x;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerEnable(true);
        workerEnable(true);
        productEnable(true);
        add.setDisable(true);
        delete.setDisable(true);
        workerCombobox.setItems(FXCollections.observableArrayList("None"));
    }


    @FXML
    public void addWorker() {
        customerEnable(true);
        workerEnable(false);
        productEnable(true);
        add.setDisable(false);
        delete.setDisable(false);
    }

    @FXML
    public void addCustomer() {
        customerEnable(false);
        workerEnable(true);
        productEnable(true);
        add.setDisable(false);
        delete.setDisable(false);
    }



    @FXML
    public void addProduct() {
        customerEnable(true);
        workerEnable(true);
        productEnable(false);
        add.setDisable(false);
        delete.setDisable(false);
    }

    public void workerEnable (boolean x ) {
        workerID.setDisable(x);
        workerName.setDisable(x);
        workerPhone.setDisable(x);
        workerAddress.setDisable(x);
        workerSpecCovers.setDisable(x);
        workerSpecCarpets.setDisable(x);

    }

    private void customerEnable(boolean x) {
        customerID.setDisable(x);
        customerName.setDisable(x);
        customerPhone.setDisable(x);
        customerAddress.setDisable(x);
        customerCity.setDisable(x);
        customerStreet.setDisable(x);
        customerEmail.setDisable(x);
        customerPassword.setDisable(x);
    }

    private void productEnable (boolean x) {
        productID.setDisable(x);
        productHigh.setDisable(x);
        productWidth.setDisable(x);
        productOwner.setDisable(x);
        coversRadioButton.setDisable(x);
        carpetsRadioButton.setDisable(x);
        workerCombobox.setDisable(x);
    }


    @FXML
    public void addFunction() throws SQLException {
        formatter = new SimpleDateFormat("dd");
        date = new Date();
        x = Integer.parseInt(formatter.format(date));
        x = x+4;
        formatter1 = new SimpleDateFormat(x +"/MM/yyyy");
        JOptionPane.showMessageDialog(null , formatter1.format(date));
        if (workerRadioButton.isSelected()) {
            addWorkerFunc();
        }
        else if (customerRadioButton.isSelected()) {
            addCustomerFunc();
        }
        else{
            addProductFunc();
        }
    }

    public void addWorkerFunc(){
        if (workerSpecCovers.isSelected()) {
            Worker worker1 = new Worker(workerID.getText(), workerName.getText(), workerPhone.getText(), workerAddress.getText(), workerSpecCovers.getText());
            worker.addWorkers(worker1);
        }
        else {
            Worker worker1 = new Worker(workerID.getText(), workerName.getText(), workerPhone.getText(), workerAddress.getText(), workerSpecCarpets.getText());
            worker.addWorkers(worker1);
        }

    }
    public void addCustomerFunc() {
        Customers customers = new Customers(customerID.getText() , customerName.getText(),customerPhone.getText(),
                customerAddress.getText(),customerCity.getText(), customerStreet.getText() , customerEmail.getText() ,  customerPassword.getText());
        customer.addCustomerGUI(customers);
    }
    public void addProductFunc() throws SQLException {
        Product product1 ;
        if (coversRadioButton.isSelected()) {
            if (!workerCombobox.getValue().equals("None")) {
                product1 = new Product(productID.getText() , productOwner.getText() ,"Cover" , "0", "0",workerCombobox.getValue() ,"Treatment" , formatter1.format(date)  );
                product.addProductGUI(product1);
                String query = "update Worker " +
                        "set status = ' Busy' " +
                        "where ID = '" + workerCombobox.getValue() +"'";
                addCustomer.sql(query);
            }
            else {
                product1 = new Product(productID.getText() , productOwner.getText() ,"Cover" , "0", "0",workerCombobox.getValue() ,"Waiting" , "Unknown" );
                product.addProductGUI(product1);
            }
        }
        else if (carpetsRadioButton.isSelected()) {
            if (!workerCombobox.getValue().equals("None")) {
                product1 = new Product(productID.getText() , productOwner.getText() ,"Carpet" , productHigh.getText(), productWidth.getText(),workerCombobox.getValue() ,"Treatment" , formatter1.format(date));
                product.addProductGUI(product1);
                String query = "update Worker " +
                        "set status = ' Busy' " +
                        "where ID = '" + workerCombobox.getValue()+ "'";
                addCustomer.sql(query);
            } else {
                product1 = new Product(productID.getText() , productOwner.getText() ,"Carpet" , productHigh.getText(), productWidth.getText(),workerCombobox.getValue() ,"Waiting" , "Unknown");
                product.addProductGUI(product1);
            }
        }
    }

    @FXML
    public void coversFunc() throws SQLException {
        productHigh.setDisable(true);
        productWidth.setDisable(true);
        String query = "Select ID From Worker Where SPECIALIZATION = 'Cover' and status = 'available'";
        refactor(query);
    }

    @FXML
    public void carpetFunc() throws SQLException {
        productHigh.setDisable(false);
        productWidth.setDisable(false);
        String query = "Select ID From Worker Where SPECIALIZATION = 'Carpet' and status = 'available'";
        refactor(query);
    }

    private void refactor(String query) throws SQLException {
        ResultSet resultSet = ref.sql(query);
        workerCombobox.getSelectionModel().clearSelection();
        workerCombobox.getItems().clear();
        workerCombobox.getItems().add("None");
        while(resultSet.next()){
            workerCombobox.getItems().add(resultSet.getString(1));
        }
    }


    @FXML
    public void delete() {
        if (workerRadioButton.isSelected()) {
            try{
                String query = "delete from WORKER where id = '" + workerID.getText()+ "'";
                customer.sql(query);
                label.setText("Worker Deleted Successfully");
            }catch (Exception ex){
                label.setText(newID);
            }
        } else if (customerRadioButton.isSelected()) {
            try{
                String query = "delete from Customer where id = '" + customerID.getText() +"'";
                customer.sql(query);
                label.setText("Customer Deleted Successfully");
            }catch (Exception ex){
                label.setText(newID);
            }

        } else {
            try{
                String query = "delete from PRODUCT where id = '" + productID.getText() +"'";
                customer.sql(query);
                label.setText("Product Deleted Successfully");
            }catch (Exception ex){
                label.setText(newID);
            }

        }
    }


    public int showStatus(String id){
        String query = "Select Status from product where id = '" + id +"'";
        int flag =17;
        if (id.isEmpty()){
            flag = 0;
        }
        else {
            try {
                ResultSet resultSet = ref.sql(query);
                while (resultSet.next()){
                    result = resultSet.getString(1);
                    flag = 1;
                }
            }catch(Exception ex){
                flag = 2;
                Logger.getLogger("You are in show product status");
            }
        }
        return flag;
    }
    public String getStatus(int flag) {
        if (flag == 0)
            result = "Empty ID";
        else if (flag == 1)
            result = "Get the status";
        else
            result = "Wrong ID";
        return result;

    }

}
