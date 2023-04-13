package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oracle.jdbc.datasource.impl.OracleDataSource;
import software.Customers;
import software.Product;
import software.Worker;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ViewAll implements Initializable {

    @FXML
    private TableView <Worker> workerTable;
    @FXML
    private TableColumn<Worker , String> IDWorker;
    @FXML
    private TableColumn<Worker , String> WorkerName;
    @FXML
    private TableColumn<Worker , String> WorkerPhoneNumber;
    @FXML
    private TableColumn<Worker , String> WorkerAddress;
    @FXML
    private TableColumn<Worker , String> WorkerSpecialization;
    @FXML
    private TableView <Customers> CustomerTable;
    @FXML
    private TableColumn<Customers , String> CustomerID;
    @FXML
    private TableColumn<Customers , String> CustomerName;
    @FXML
    private TableColumn<Customers , String> CustomerPhoneNumber;
    @FXML
    private TableColumn<Customers , String> CustomerCity;
    @FXML
    private TableColumn<Customers , String> CustomerStreet;
    @FXML
    private TableColumn<Customers , String> CustomerAddress;
    @FXML
    private TableColumn <Customers , String> CustomerEmail;
    @FXML
    private TableView<Product> ProductTable;
    @FXML
    private TableColumn<Product , String> ProductID;
    @FXML
    private TableColumn<Product , String> ProductName;
    @FXML
    private TableColumn<Product , String> ProductCategory;
    @FXML
    private TableColumn <Product , String>ProductHigh;
    @FXML
    private TableColumn<Product , String> ProductWidth;
    @FXML
    private TableColumn<Product , String> ProductOwner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // for Worker
        IDWorker.setCellValueFactory(new PropertyValueFactory<>("Id"));
        WorkerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        WorkerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        WorkerAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        WorkerSpecialization.setCellValueFactory(new PropertyValueFactory<>("Specialization"));

        // for Customer
        CustomerID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        CustomerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CustomerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        CustomerCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        CustomerStreet.setCellValueFactory(new PropertyValueFactory<>("Street"));
        CustomerAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        CustomerEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

        // for Product
        ProductID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ProductCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        ProductHigh.setCellValueFactory(new PropertyValueFactory<>("High"));
        ProductWidth.setCellValueFactory(new PropertyValueFactory<>("Width"));
        ProductOwner.setCellValueFactory(new PropertyValueFactory<>("Owner"));


        try {
            String query = "SELECT * FROM Worker";
            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            workerTable.getItems().clear();
            // Workers
            while(rs.next())
            {
                Worker s1 = new Worker(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5));
                workerTable.getItems().add(s1);
            }
            // Customers
            query = "SELECT * FROM CUSTOMER";
            rs = st.executeQuery(query);
            while(rs.next())
            {
                Customers s1 = new Customers(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5), rs.getString(6) , rs.getString(7));
                CustomerTable.getItems().add(s1);
            }

            query = "SELECT * FROM PRODUCT";
            rs = st.executeQuery(query);
            while(rs.next())
            {
                Product s1 = new Product(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5));
                ProductTable.getItems().add(s1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }


}
