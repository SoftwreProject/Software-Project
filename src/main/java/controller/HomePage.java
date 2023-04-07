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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage {



    @FXML
    private BorderPane HomePagePane;

    @FXML
    private Button backButton;

    @FXML
    private Pane centerHomePage;

    @FXML
    private JFXButton customerPageButton;

    @FXML
    private JFXButton homePageButton;

    @FXML
    private JFXButton productPageButton;

    @FXML
    private JFXButton workerPageButton;

    public void HomePage() throws Exception {


    }




    @FXML
    private void backToLogin(ActionEvent event) throws IOException {
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
        loadpage("/HomePageCenter");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomePageCenter.fxml"));
        Parent root = loader.load();
        AddWorker ref = loader.getController();
//        ref.username1 = managerid;
//        ref.Fill(managerid);
//        Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene1 = new Scene(root);
        HomePagePane.setCenter(root);

    }

    @FXML
    void customerPage(ActionEvent event) {

    }

    @FXML
    void productHomePage(ActionEvent event) {

    }

    @FXML
    void workerHomePage(ActionEvent event) throws Exception {
        loadpage("/Worker");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Worker.fxml"));
        Parent root = loader.load();
        AddWorker ref = loader.getController();
//        ref.username1 = managerid;
//        ref.Fill(managerid);
//        Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene1 = new Scene(root);
        HomePagePane.setCenter(root);
    }



    private void loadpage (String page) throws Exception
    {
        Parent root = null ;

        root = FXMLLoader.load(getClass().getResource(page+".fxml"));

        HomePagePane.setCenter(root);
    }



}
