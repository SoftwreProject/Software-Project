package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class HomePage {

    int managerid;

    @FXML
    private BorderPane HomePagePane;

    @FXML
    private Label ScientificStudentCount;
    @FXML
    private Label LiteraryStudentCount;
    @FXML
    private Label CommercialStudentCount;
    @FXML
    private Label IndustrialStudentCount;
    @FXML
    private Label ScientificStudentCount1;
    @FXML
    private Label LiteraryStudentCount1;
    @FXML
    private Label CommercialStudentCount1;
    @FXML
    private Label IndustrialStudentCount1;
    @FXML
    private Pane HomePane;

    @FXML
    private void backToLogin (ActionEvent event) throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout?");
        if(alert.showAndWait().get() == ButtonType.OK )
        {
            Stage stage = (Stage) HomePagePane.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
            stage.setTitle("Cleaning Services");
            stage.setScene(new Scene(root, 770, 561));
            stage.show();


        }
    }

    @FXML
    void centerHomePage(ActionEvent event) throws Exception {
        HomePagePane.setCenter(HomePane);

    }
    @FXML
    void Add(ActionEvent event) throws Exception {
        loadpage("/AddAll");
    }

    @FXML
    void ViewAll(ActionEvent event) throws Exception {
        loadpage("/ViewAll");
    }
    private void loadpage (String page) throws Exception
    {
        Parent root = null ;
        root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        HomePagePane.setCenter(root);
    }
}
