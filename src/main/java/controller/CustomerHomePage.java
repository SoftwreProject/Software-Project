package controller;

import com.jfoenix.controls.JFXButton;
import io.cucumber.java.bs.A;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        High.setCellValueFactory(new PropertyValueFactory<>("High"));
        Width.setCellValueFactory(new PropertyValueFactory<>("Width"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
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
    }
    @FXML
    void Refresh(ActionEvent event) throws SQLException {
//        String Query = "Select ID, Date " + "FROM Product " + "WHERE owner = '"+ id + "'";
        String Query = "SELECT ID, \"DATE\" " + "FROM Product " + "WHERE owner = '"+ id + "'";
        ResultSet resultSet = ref.sql(Query);
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date();
        while (resultSet.next()) {

            String[] DayOfDate = resultSet.getString(2).split("/");
            int start = Integer.parseInt(DayOfDate[0]);
            int ready = Integer.parseInt(DayOfDate[0]) + 4; // the product deadline
            int daydate = Integer.parseInt(formatter.format(date)); // date of today
            if (ready <= daydate)
            {
                String query = "UPDATE PRODUCT " +
                        "SET STATUS = 'Complete' " +
                        "WHERE ID = '"+ resultSet.getString(1) +"'";
                ref1.sql(query);
            }
            else if (daydate - start == 1) {
                String query = "UPDATE PRODUCT " +
                        "SET STATUS = 'Waiting' " +
                        "WHERE ID = '"+ resultSet.getString(1) +"'";
                ref1.sql(query);
            }
            else if (daydate > start && daydate < ready) {
                String query = "UPDATE PRODUCT " +
                        "SET STATUS = 'In Treatment' " +
                        "WHERE ID = '"+ resultSet.getString(1) +"'";
                ref1.sql(query);
            }
        }
        ShowAll();
    }
    @FXML
    void Paid(ActionEvent event) {

    }
}
