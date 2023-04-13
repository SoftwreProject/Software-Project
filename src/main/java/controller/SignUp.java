package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {

    @FXML
    void BackToSignIn(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
//        Parent root = loader.load();
//        LoginController ref = loader.getController();
//
//        if (ref.SigninPane.getScene() == null) {
//            Scene scene = new Scene(ref.SigninPane);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
//        } else {
//            Scene scene = ref.SigninPane.getScene();
//            scene.setRoot(root);
//        }
//
//        Stage stage = (Stage) ref.SigninPane.getScene().getWindow();
//        new animatefx.animation.ZoomOut(root).play();
//        stage.setTitle("Login");
//        stage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent root = loader.load();
        LoginController ref = loader.getController();

        Scene scene = ref.SigninPane.getScene();
        if (scene == null) {
            scene = new Scene(ref.SigninPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            if (ref.SigninPane == scene.getRoot()) {
                ref.SigninPane.getChildren().setAll(root);
            } else {
                scene.setRoot(root);
            }
        }

        Stage stage = (Stage) scene.getWindow();
        new animatefx.animation.ZoomOut(root).play();
        stage.setTitle("Login");
        stage.show();
    }
}