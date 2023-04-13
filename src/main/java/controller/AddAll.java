package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddAll implements Initializable {


    @FXML
    private TextField WorkerID;
    @FXML
    private TextField WorkerName;
    @FXML
    private TextField WorkerPhone;
    @FXML
    private TextField WorkerAddress;
    @FXML
    private TextField WorkerSpecilization;
    @FXML
    private TextField CustomerID;
    @FXML
    private TextField CustomerName;
    @FXML
    private TextField CustoemrPhone;
    @FXML
    private TextField CustomerAddress;
    @FXML
    private TextField CustomerCity;
    @FXML
    private TextField CustomerStreet;
    @FXML
    private TextField EmailCustomer;
    @FXML
    private TextField CustomerPassword;
    @FXML
    private TextField ProductID;
    @FXML
    private TextField ProductHigh;
    @FXML
    private TextField ProductWidth;
    @FXML
    private TextField ProductOwner;
    @FXML
    private JFXRadioButton CoversRadiButton;
    @FXML
    private ToggleGroup toggle;
    @FXML
    private JFXRadioButton CarpetsRadioButton;
    @FXML
    private JFXRadioButton WorkerRadioButton;
    @FXML
    private ToggleGroup toggle1;
    @FXML
    private JFXRadioButton CustomerRadioButton;
    @FXML
    private JFXRadioButton ProductRadioButton;
    @FXML
    private JFXButton Add;
    @FXML
    private Label label;
    AddWorker worker = new AddWorker();
    AddCustomer customer = new AddCustomer();
    AddProduct product = new AddProduct();
    DeleteCustomer customer1 = new DeleteCustomer();
    @FXML
    private JFXButton Add1;
    @FXML
    private JFXButton Add2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CustomerEnable(true);
        WorkerEnable(true);
        ProductEnable(true);
        Add.setDisable(true);
    }


    @FXML
    public void AddWorker(ActionEvent actionEvent) {
        CustomerEnable(true);
        WorkerEnable(false);
        ProductEnable(true);
        Add.setDisable(false);
    }

    @FXML
    public void AddCustomer(ActionEvent actionEvent) {
        CustomerEnable(false);
        WorkerEnable(true);
        ProductEnable(true);
        Add.setDisable(false);
    }



    @FXML
    public void AddProduct(ActionEvent actionEvent) {
        CustomerEnable(true);
        WorkerEnable(true);
        ProductEnable(false);
        Add.setDisable(false);
    }

    public void WorkerEnable (boolean x ) {
        WorkerID.setDisable(x);
        WorkerName.setDisable(x);
        WorkerPhone.setDisable(x);
        WorkerAddress.setDisable(x);
        WorkerSpecilization.setDisable(x);
    }

    private void CustomerEnable(boolean x) {
        CustomerID.setDisable(x);
        CustomerName.setDisable(x);
        CustoemrPhone.setDisable(x);
        CustomerAddress.setDisable(x);
        CustomerCity.setDisable(x);
        CustomerStreet.setDisable(x);
        EmailCustomer.setDisable(x);
        CustomerPassword.setDisable(x);
    }

    private void ProductEnable (boolean x) {
        ProductID.setDisable(x);
        ProductHigh.setDisable(x);
        ProductWidth.setDisable(x);
        ProductOwner.setDisable(x);
        CoversRadiButton.setDisable(x);
        CarpetsRadioButton.setDisable(x);
    }


    @FXML
    public void Add(ActionEvent actionEvent) throws SQLException {
        if (WorkerRadioButton.isSelected()) {
            worker.AddWorkers(WorkerID , WorkerName , WorkerPhone , WorkerAddress ,WorkerSpecilization ,label );
        }
        else if (CustomerRadioButton.isSelected()) {
            customer.AddCustomerGUI(CustomerID , CustomerName , CustoemrPhone , CustomerAddress , CustomerCity , CustomerStreet  , EmailCustomer , CustomerPassword , label);
        }
        else{
            if (CoversRadiButton.isSelected()) {

                product.AddProductGUI(ProductID , ProductOwner ,"Cover"  , "0" , "0"  , label);
            }
            else if (CarpetsRadioButton.isSelected()){

                product.AddProductGUI(ProductID , ProductOwner , "Carpet" , ProductHigh.getText() , ProductWidth.getText() , label);
            }

        }
    }

    @FXML
    public void CoversFunc(ActionEvent actionEvent) {
        ProductHigh.setDisable(true);
        ProductWidth.setDisable(true);
    }

    @FXML
    public void CarpetFunc(ActionEvent actionEvent) {
        ProductHigh.setDisable(false);
        ProductWidth.setDisable(false);
    }

    public void SqlDelete (String x) {

    }
    @FXML
    public void Delete(ActionEvent actionEvent) throws SQLException {
        if (WorkerRadioButton.isSelected()) {
            try{
                String query = "Delete from WORKER where id = '" + WorkerID.getText()+ "'";
                customer.sql(query);
                label.setText("Worker Deleted Successfully");
            }catch (Exception ex){
                label.setText("Please Enter The ID");
            }
        } else if (CustomerRadioButton.isSelected()) {
            try{
                String query = "Delete from Customer where id = '" + CustomerID.getText() +"'";
                customer.sql(query);
                label.setText("Customer Deleted Successfully");
            }catch (Exception ex){
                label.setText("Please Enter The ID");
            }

        } else {
            try{
                String query = "Delete from PRODUCT where id = '" + ProductID.getText() +"'";
                customer.sql(query);
                label.setText("Product Deleted Successfully");
            }catch (Exception ex){
                label.setText("Please Enter The ID");
            }

        }
    }

    @FXML
    public void Update(ActionEvent actionEvent) {

    }
}
