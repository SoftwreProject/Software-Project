package software;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

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

    public String setresult(String username, String password) {
        String s = "";
        if (username.equals("abcd@gmail.com") || password.equals("1234"))
            s = "E-mail or password is incorrect";
        else if (username.equals("ayham.1222@gmail.com") && password.equals("012345"))
            s = "Access your account successfully";
        return s;

    }

}

