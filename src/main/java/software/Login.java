package software;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Login extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        stage.setTitle("Cleaning Services ");
        stage.setScene(new Scene(root, 770, 561));
        stage.setResizable(false);
        stage.show();

    }
    public static void main (String [] args) {
        launch(args);
    }



}

