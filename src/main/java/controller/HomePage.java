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
//        loadpage("/HomePage");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomePage.fxml"));
//        Parent root = loader.load();
//        AddWorker ref = loader.getController();
//        ref.username1 = managerid;
//        ref.Fill(managerid);
//        Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene1 = new Scene(root);
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
//    public void Date () {
//        String name ="";
//        try {
//            String Query = "Select Name From Manager where Managerid = " + managerid ;
//            OracleDataSource orc = new OracleDataSource();
//            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
//            orc.setUser("testuser");
//            orc.setPassword("123456");
//            Connection conn = orc.getConnection();
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(Query);
//            while (rs.next()) {
//                name = rs.getString(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("HH");
//        int x = Integer.parseInt(formatter.format(date));
//        if (x >=0 && x<= 12)
//            WelcomLabel.setText("Good Morning, " + name);
//        else if (x >=13 && x<= 17)
//            WelcomLabel.setText("Good Afternoon, " + name);
//        else
//            WelcomLabel.setText("Good Evening, " + name);
//
//    }


}
