package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class HomePage {

    int managerId;

    @FXML
    public BorderPane HomePagePane;


    @FXML
    public Pane HomePane;
    @FXML
    public Label WorkerCountLabel ;

    @FXML
    public Label carpetsWorkerCountLabel;

    @FXML
    public Label coverWorkerContLabel;

    @FXML
    public Label customerCountLabel;

    @FXML
    public PieChart personChart;

    @FXML
    public PieChart productChart;

    @FXML
    public Label carpetProductCountLabel;

    @FXML
    public Label coverProductCountLabel;

    @FXML
    public Label moneyForCarpetLabel;

    @FXML
    public Label moneyForCoverLabels;



    @FXML
    private void backToLogin () throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            Stage stage = (Stage) HomePagePane.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login.fxml")));
            stage.setTitle("Cleaning Services");
            stage.setScene(new Scene(root, 770, 561));
            stage.show();
        }
    }
    public  String getFromDatabase(String s) throws SQLException {
        SignUp signUp = new SignUp();
        ResultSet rs = signUp.sql(s);
        String m ="";
        while(rs.next()){
            m = (String.valueOf(rs.getInt(1)));
        }

        return m;
    }




    @FXML
    public void centerHomePage() throws Exception {

        HomePagePane.setCenter(HomePane);
        String numOfWorker = "select count(ID) from worker";
        String numOfCustomer = "select count(ID) from customer";
        String numOfCarpetsWorker = "select count(ID) from worker where SPECIALIZATION='carpet'";
        String numOfCoverWorker = "select count(ID) from worker where SPECIALIZATION='cover'";

        String numOfCarpetProduct = "select count(ID) from product where CATEGORY = 'carpet'";
        String numOfCoverProduct = "select count(ID) from product where CATEGORY = 'cover'";
        String allMoneyForCarpet = "select sum(totalPrice) from Product where CATEGORY = 'carpet'";
        String allMoneyForCover = "select sum(totalPrice) from Product where CATEGORY = 'cover'";

        WorkerCountLabel.setText(getFromDatabase(numOfWorker));
        customerCountLabel.setText(getFromDatabase(numOfCustomer));
        carpetsWorkerCountLabel.setText(getFromDatabase(numOfCarpetsWorker));
        coverWorkerContLabel.setText(getFromDatabase(numOfCoverWorker));

        carpetProductCountLabel.setText(getFromDatabase(numOfCarpetProduct));
        coverProductCountLabel.setText(getFromDatabase(numOfCoverProduct));
        moneyForCarpetLabel.setText(getFromDatabase(allMoneyForCarpet));
        moneyForCoverLabels.setText(getFromDatabase(allMoneyForCover));


        ObservableList<PieChart.Data> personChartData = FXCollections.observableArrayList(
                new PieChart.Data("All Worker", Double.parseDouble(getFromDatabase(numOfWorker))),
                new PieChart.Data("All Customer",Double.parseDouble(getFromDatabase(numOfCustomer))),
                new PieChart.Data("Carpet Worker", Double.parseDouble(getFromDatabase(numOfCarpetsWorker))),
                new PieChart.Data("Cover Worker", Double.parseDouble(getFromDatabase(numOfCoverWorker))));

        personChart.setData(personChartData);
        personChart.setTitle("Persone Chart");
        personChart.setVisible(true);


        ObservableList<PieChart.Data> productChartData = FXCollections.observableArrayList(
                new PieChart.Data("Carpet Product", Double.parseDouble(getFromDatabase(numOfCarpetProduct))),
                new PieChart.Data("Cover Product",Double.parseDouble(getFromDatabase(numOfCoverProduct))),
                new PieChart.Data("Carpet Money", Double.parseDouble(getFromDatabase(allMoneyForCarpet))),
                new PieChart.Data("Cover Money", Double.parseDouble(getFromDatabase(allMoneyForCover))));

        productChart.setData(productChartData);
        productChart.setTitle("Product Chart");
        productChart.setVisible(true);


    }
    @FXML
    void Add() throws IOException {
        loadpage("/AddAll");
    }

    @FXML
    void ViewAll() throws IOException {
        loadpage("/ViewAll");
    }
    @FXML
    void openSendEmailPane() throws IOException {
        loadpage("/SendEmail");
    }


    private void loadpage (String page) throws IOException {
        Parent root = null ;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        HomePagePane.setCenter(root);
    }





}

