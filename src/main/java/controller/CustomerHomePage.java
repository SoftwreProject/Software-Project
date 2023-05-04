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
import java.util.logging.Logger;

public class CustomerHomePage implements Initializable {
    SignUp ref = new SignUp();
    String idSinging ; // the idSinging from sign in page;
    String name;
    @FXML
    private Label welcome;
    @FXML
    private Label todayDate;
    @FXML
    private Label enterTime;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn category;
    @FXML
    private TableColumn high;
    @FXML
    private TableColumn width;
    @FXML
    private TableColumn date;
    @FXML
    private TableColumn status;
    @FXML
    private TableColumn totalPrice;
    @FXML
    private TableView allInformation;
    @FXML
    private TextField numberOfProduct;
    @FXML
    private TextField youPaid;
    @FXML
    private TextField theRest;
    @FXML
    private TextField totalPriceTextField;
    AddCustomer ref1 = new AddCustomer();
    int flag = 0;
    String getStatus;
    float count;
    @FXML
    private Label label;
    @FXML
    private Label rest;
    @FXML
    private JFXButton paidButton;
    @FXML
    private Pane customerpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("idSinging"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        high.setCellValueFactory(new PropertyValueFactory<>("high"));
        width.setCellValueFactory(new PropertyValueFactory<>("width"));
        date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        numberOfProduct.setEditable(false);
        theRest.setEditable(false);
        totalPriceTextField.setEditable(false);
        paidButton.setDisable(true);

    }


    private void showAll() throws SQLException {

        String Query = "Select * From Product where owner = '"+ idSinging + "'";
        ResultSet resultSet = ref.sql(Query);
        allInformation.getItems().clear();
        while (resultSet.next()) {
            AllProductTable reference = new AllProductTable(resultSet.getString(1) , resultSet.getString(3) , resultSet.getString(4) ,resultSet.getString(5),
                    resultSet.getString(6) , resultSet.getString(7), resultSet.getString(8));
            allInformation.getItems().add(reference);
        }
        Query = "Select count(*) from Product where owner = '" + idSinging +"'";
        count = getCount(Query);
        numberOfProduct.setText(String.valueOf((int)count));
        Query = "Select Sum(totalPrice) from Customer where idSinging = '" + idSinging +"'";
        count = getCount(Query);
        if (count > 500) {
            label.setText("Before = " + count + ", Discount By 5% for sales grater than 500");
            count = count - count * ((float) 15 / 100);
            totalPriceTextField.setText(String.valueOf(count));

        }
        else {
            label.setText("");
            totalPriceTextField.setText(String.valueOf(count));
        }
    }

    public void setName(){
        String query = "Select name from customer where idSinging = '" + idSinging +"'";
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
    public void setDate() {
        LocalDate day = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfToday = new Date();
        todayDate.setText(day.format(format) +", " + formatter.format(dateOfToday));
        formatter = new SimpleDateFormat("HH:mm:ss");
        enterTime.setText("Entry time at: " + formatter.format(dateOfToday));

    }
    @FXML
    public void showAllInformation(ActionEvent actionEvent) throws SQLException {
        showAll();
        paidButton.setDisable(false);

    }
    @FXML
    void refreshFunction(ActionEvent event) throws SQLException {
        refreshStat(idSinging);
    }

    public String test () {
        if (flag == 0)
            getStatus = "There is no product";
        else if (flag == 1)
            getStatus = "the product change to complete";
        else if (flag == 2)
            getStatus = "the product change to waiting";
        else if (flag == 3)
            getStatus = "the product change to in In Treatment";
        return getStatus;
    }



    public void refreshStat(String idSinging) {
        String query = "SELECT idSinging , EndDate , Status + FROM Product " + "WHERE owner = '"+ idSinging + "'";
        try {
            ResultSet resultSet = ref.sql(query);
            SimpleDateFormat formatter = new SimpleDateFormat("dd");
            Date dateOfToday = new Date();
            while (resultSet.next()) {
                String[] dayOfDate = resultSet.getString(2).split("/");
                int end = Integer.parseInt(dayOfDate[0]); // deadline
                int today = Integer.parseInt(formatter.format(dateOfToday)); // dateOfToday of today
                if (today >= end)
                {
                    String query1 = "UPDATE PRODUCT " +
                            "SET STATUS = 'Complete' " +
                            "WHERE idSinging = '"+ resultSet.getString(1) +"'";
                    ref1.sql(query1);
                    query = "update Worker " +
                            "set getStatus = ' Busy' " +
                            "where idSinging = '" + resultSet.getString(1) + "'";
                    ref1.sql(query1);
                    flag = 1;
                }


            }
            showAll();
        }
        catch (Exception ex) {
            flag = 0;
            Logger.getLogger("You are in get status of customer");
        }
    }

    @FXML
    void paidFunction(ActionEvent event) {

        float paid;
        int sum;
    try{
        paid = Float.parseFloat(youPaid.getText());
        paid = paid - count;
        theRest.setText("" + paid);
        paid*= -1;
        String s = "Update Customer " +
                "Set totalPrice = '" + paid +"' " +
                "Where idSinging = '" +idSinging+"'";
        rest.setText("You have money left");
        ref1.sql(s);
    }catch(Exception ex) {
        JOptionPane.showMessageDialog(null , "Please Enter a Number");
    }

    }
    public int getCount(String query) throws SQLException {
        int x = 0;
        ResultSet resultSet = ref.sql(query);
        while (resultSet.next())
           x = resultSet.getInt(1);
        return x;
    }

    @FXML
    void logoutFunction(ActionEvent event) throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout?");
        if (alert.showAndWait().isEmpty())
            JOptionPane.showMessageDialog(null, "Please Enter Value");
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
