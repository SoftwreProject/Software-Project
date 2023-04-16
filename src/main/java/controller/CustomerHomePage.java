package controller;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.jar.JarOutputStream;

public class CustomerHomePage implements Initializable {
    SignUp ref = new SignUp();
    String id ; // the id from sign in page;
    String name;
    @FXML
    private Label welcome;
    @FXML
    private Label TodyDate;
    @FXML
    private Label EnterTime;
    @FXML
    private TableColumn ID;
    @FXML
    private TableColumn Category;
    @FXML
    private TableColumn High;
    @FXML
    private TableColumn Width;
    @FXML
    private TableColumn Date;
    @FXML
    private TableColumn Status;
    @FXML
    private TableColumn TotalPrice;
    @FXML
    private TableView AllInformation;
    @FXML
    private JFXButton ShowAll;
    @FXML
    private TextField NumberOfProduct;
    @FXML
    private TextField YouPaid;
    @FXML
    private TextField TheRest;
    @FXML
    private TextField TotalPriceTextField;
    AddCustomer ref1 = new AddCustomer();
    int flag = 0;
    String status;
    float count;
    @FXML
    private Label label;
    @FXML
    private Label rest;
    @FXML
    private JFXButton paidbutton;
    @FXML
    private Pane customerpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        High.setCellValueFactory(new PropertyValueFactory<>("High"));
        Width.setCellValueFactory(new PropertyValueFactory<>("Width"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
        NumberOfProduct.setEditable(false);
        TheRest.setEditable(false);
        TotalPriceTextField.setEditable(false);
        paidbutton.setDisable(true);

    }


    private void ShowAll() throws SQLException {

        String Query = "Select * From Product where owner = '"+ id + "'";
        ResultSet resultSet = ref.sql(Query);
        AllInformation.getItems().clear();
        while (resultSet.next()) {
            AllProductTable ref = new AllProductTable(resultSet.getString(1) , resultSet.getString(3) , resultSet.getString(4) ,resultSet.getString(5),
                    resultSet.getString(6) , resultSet.getString(7), resultSet.getString(8));
            AllInformation.getItems().add(ref);
        }
        Query = "Select count(*) from Product where owner = '" + id +"'";
        count = getCount(Query);
        NumberOfProduct.setText(String.valueOf((int)count));
        Query = "Select Sum(TotalPrice) from Customer where id = '" + id +"'";
        count = getCount(Query);
        if (count > 500) {
            label.setText("Before = " + count + ", Discount By 5% for sales grater than 500");
            count = count - count * ((float) 15 / 100);
            TotalPriceTextField.setText(String.valueOf(count));

        }
        else {
            label.setText("");
            TotalPriceTextField.setText(String.valueOf(count));
        }
    }

    public void SetName(){
        String query = "Select name from customer where id = '" + id +"'";
        try {
            ResultSet rs = ref.sql(query);
            while (rs.next()){
                name = rs.getString(1);
            }
            welcome.setText("Welcome, " + name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void SetDate() {
        LocalDate day = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        TodyDate.setText(day.format(format) +", " + formatter.format(date));
        formatter = new SimpleDateFormat("HH:mm:ss");
        EnterTime.setText("Entry time at: " + formatter.format(date));

    }
    @FXML
    public void ShowAllInformation(ActionEvent actionEvent) throws SQLException {
        ShowAll();
        paidbutton.setDisable(false);

    }
    @FXML
    void Refresh(ActionEvent event) throws SQLException {
        RefreshStat(id);
    }

    public String test () {
        if (flag == 0)
            status = "There is no product";
        else if (flag == 1)
            status = "the product change to complete";
        else if (flag == 2)
            status = "the product change to waiting";
        else if (flag == 3)
            status = "the product change to in In Treatment";
        return status;
    }



    public void RefreshStat(String id) {
        String Query = "SELECT ID , EndDate , Status + FROM Product " + "WHERE owner = '"+ id + "'";
        try {
            ResultSet resultSet = ref.sql(Query);
            SimpleDateFormat formatter = new SimpleDateFormat("dd");
            Date date = new Date();
            while (resultSet.next()) {
                String[] DayOfDate = resultSet.getString(2).split("/");
                int end = Integer.parseInt(DayOfDate[0]); // deadline
                int today = Integer.parseInt(formatter.format(date)); // date of today
                if (today >= end)
                {
                    String query = "UPDATE PRODUCT " +
                            "SET STATUS = 'Complete' " +
                            "WHERE ID = '"+ resultSet.getString(1) +"'";
                    ref1.sql(query);
                    query = "update Worker " +
                            "set status = ' Busy' " +
                            "where ID = '" + resultSet.getString(1) + "'";
                    ref1.sql(query);
                    flag = 1;
                }


            }
            ShowAll();



        }
        catch (Exception ex) {
            flag = 0;
            System.out.println("There is no Product for you");
        }
    }

    @FXML
    void Paid(ActionEvent event) {

        float paid;
        int sum;
    try{
        paid = Float.parseFloat(YouPaid.getText());
        paid = paid - count;
        TheRest.setText("" + paid);
        paid*= -1;
        String s = "Update Customer " +
                "Set TotalPrice = '" + paid +"' " +
                "Where id = '" +id+"'";
        rest.setText("You have money left");
        ref1.sql(s);


    }catch(Exception ex) {
        JOptionPane.showMessageDialog(null , "Please Enter a Number");
    }

    }
    public int getCount(String Query) throws SQLException {
        int x = 0;
        ResultSet resultSet = ref.sql(Query);
        while (resultSet.next())
           x = resultSet.getInt(1);
        return x;
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout?");
        if(alert.showAndWait().get() == ButtonType.OK )
        {
            Stage stage = (Stage) customerpane.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
            stage.setTitle("Cleaning Services");
            stage.setScene(new Scene(root, 770, 561));
            stage.show();


        }
    }


}
