package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private JFXRadioButton WorkerSpecCovers;

    @FXML
    private JFXRadioButton WorkerSpecCarpets;
    @FXML
    private JFXComboBox workerCombobox;
    @FXML
    private ToggleGroup Specilization;
    SignUp ref = new SignUp();
    AddCustomer addCustomer = new AddCustomer();
    String result;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CustomerEnable(true);
        WorkerEnable(true);
        ProductEnable(true);
        Add.setDisable(true);
        Add1.setDisable(true);
        workerCombobox.setItems(FXCollections.observableArrayList("None"));
    }


    @FXML
    public void AddWorker(ActionEvent actionEvent) {
        CustomerEnable(true);
        WorkerEnable(false);
        ProductEnable(true);
        Add.setDisable(false);
        Add1.setDisable(false);
    }

    @FXML
    public void AddCustomer(ActionEvent actionEvent) {
        CustomerEnable(false);
        WorkerEnable(true);
        ProductEnable(true);
        Add.setDisable(false);
        Add1.setDisable(false);
    }



    @FXML
    public void AddProduct(ActionEvent actionEvent) {
        CustomerEnable(true);
        WorkerEnable(true);
        ProductEnable(false);
        Add.setDisable(false);
        Add1.setDisable(false);
    }

    public void WorkerEnable (boolean x ) {
        WorkerID.setDisable(x);
        WorkerName.setDisable(x);
        WorkerPhone.setDisable(x);
        WorkerAddress.setDisable(x);
        WorkerSpecCovers.setDisable(x);
        WorkerSpecCarpets.setDisable(x);

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
        workerCombobox.setDisable(x);
    }


    @FXML
    public void Add(ActionEvent actionEvent) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date();
        int x = Integer.parseInt(formatter.format(date));
        x = x+4;
        SimpleDateFormat formatter1 = new SimpleDateFormat(x +"/MM/yyyy");
        JOptionPane.showMessageDialog(null , formatter1.format(date));
        if (WorkerRadioButton.isSelected()) {
            if (WorkerSpecCovers.isSelected())
            worker.AddWorkers(WorkerID , WorkerName , WorkerPhone , WorkerAddress , WorkerSpecCovers,label );
            else
                worker.AddWorkers(WorkerID , WorkerName , WorkerPhone , WorkerAddress , WorkerSpecCarpets,label );
        }
        else if (CustomerRadioButton.isSelected()) {
            customer.addCustomerGUI(CustomerID , CustomerName , CustoemrPhone , CustomerAddress , CustomerCity , CustomerStreet  , EmailCustomer , CustomerPassword , label);
        }
        else{
            if (CoversRadiButton.isSelected()) {
                if (!workerCombobox.getValue().toString().equals("None")) {
                    product.AddProductGUI(ProductID, ProductOwner, "Cover", "0", "0", workerCombobox.getValue().toString(), "Treatment", formatter1.format(date), label);
                    String Query = "update Worker " +
                            "set status = ' Busy' " +
                            "where ID = '" + workerCombobox.getValue().toString() +"'";
                    addCustomer.sql(Query);
                }
                else {
                    product.AddProductGUI(ProductID, ProductOwner, "Cover", "0", "0", workerCombobox.getValue().toString(), "Waiting", "Unknown", label);
                }
            }
            else if (CarpetsRadioButton.isSelected()) {
                if (!workerCombobox.getValue().toString().equals("None")) {
                    product.AddProductGUI(ProductID, ProductOwner, "Carpet", ProductHigh.getText(), ProductWidth.getText(), workerCombobox.getValue().toString(), "Treatment", formatter1.format(date), label);
                    String Query = "update Worker " +
                            "set status = ' Busy' " +
                            "where ID = '" + workerCombobox.getValue().toString() + "'";
                    addCustomer.sql(Query);
                } else {
                    product.AddProductGUI(ProductID, ProductOwner, "Carpet", ProductHigh.getText(), ProductWidth.getText(), workerCombobox.getValue().toString(), "Waiting", "Unknown", label);
                }
            }

        }
    }

    @FXML
    public void CoversFunc(ActionEvent actionEvent) throws SQLException {
        ProductHigh.setDisable(true);
        ProductWidth.setDisable(true);
        String Query = "Select ID From Worker Where SPECIALIZATION = 'Cover' and status = 'available'";
        Refactor(Query);
    }

    @FXML
    public void CarpetFunc(ActionEvent actionEvent) throws SQLException {
        ProductHigh.setDisable(false);
        ProductWidth.setDisable(false);
        String Query = "Select ID From Worker Where SPECIALIZATION = 'Carpet' and status = 'available'";
        Refactor(Query);
    }

    private void Refactor(String query) throws SQLException {
        ResultSet resultSet = ref.sql(query);
        workerCombobox.getSelectionModel().clearSelection();
        workerCombobox.getItems().clear();
        workerCombobox.getItems().add("None");
        while(resultSet.next()){
            workerCombobox.getItems().add(resultSet.getString(1));
        }
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
    public void SelectWorker(ActionEvent actionEvent) {
    }
    public int ShowStatus(String id) throws SQLException {
        String Query = "Select Status from product where id = '" + id +"'";
        int flag = 0;
        if (id.isEmpty()){
            flag = 0;
        }
        else {
            try {
                ResultSet resultSet = ref.sql(Query);
                while (resultSet.next()){
                    result = resultSet.getString(1);
                    flag = 1;
                }
            }catch(Exception ex){
                flag = 2;
            }
        }
        return flag;
    }
    public String getStatus(int flag) {
        if (flag == 0)
            result = "Empty ID";
        else if (flag == 2)
            result = "Wrong ID";

        return result;

    }

}
