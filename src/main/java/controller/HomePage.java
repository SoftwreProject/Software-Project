package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class HomePage {

    int managerid;

    @FXML
    private BorderPane HomePagePane;


    @FXML
    private Pane HomePane;

    @FXML
    private void backToLogin (ActionEvent event) throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout? ");
        if (alert.showAndWait().isEmpty())
            JOptionPane.showMessageDialog(null , "Please Enter a value");
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
