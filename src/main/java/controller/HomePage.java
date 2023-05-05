package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class HomePage {

    int managerId;
    @FXML
    private BorderPane homePagePane;

    @FXML
    private Pane homePane ;
    @FXML
    private void backToLogin () throws IOException {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            closePage();
        }
    }
    private void closePage() throws IOException {
        Stage stage = (Stage) homePagePane.getScene().getWindow();
        close(stage);

    }
    public void close ( Stage stage ) throws IOException {
        stage.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login.fxml")));
        stage.setTitle("Cleaning Services");
        stage.setScene(new Scene(root, 770, 561));
        stage.show();
    }

    @FXML
    void centerHomePage(){
        homePagePane.setCenter(homePane);

    }
    @FXML
    void add() throws IOException {
        loadPage("/AddAll");
    }

    @FXML
    void viewAll() throws IOException {
        loadPage("/ViewAll");
    }
    private void loadPage (String page) throws IOException {
        Parent root ;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        homePagePane.setCenter(root);
    }
}
