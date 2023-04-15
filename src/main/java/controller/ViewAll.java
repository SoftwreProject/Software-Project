package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
    AddCustomer ref = new AddCustomer();

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
    private TableColumn<Product , String> ProductCategory;
    @FXML
    private TableColumn <Product , String>ProductHigh;
    @FXML
    private TableColumn<Product , String> ProductWidth;
    @FXML
    private TableColumn<Product , String> ProductOwner;
    SignUp ref1 = new SignUp();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // for Worker
        IDWorker.setCellValueFactory(new PropertyValueFactory<>("Id"));
        WorkerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        WorkerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        WorkerAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        WorkerSpecialization.setCellValueFactory(new PropertyValueFactory<>("Specialization"));

        // for Customer
        CustomerID.setCellValueFactory(new PropertyValueFactory<>("ID"));
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

        // for update Worker
        WorkerName.setCellFactory(TextFieldTableCell.forTableColumn());
        WorkerPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        WorkerAddress.setCellFactory(TextFieldTableCell.forTableColumn());

        //for update customer
        CustomerName.setCellFactory(TextFieldTableCell.forTableColumn());
        CustomerPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        CustomerCity.setCellFactory(TextFieldTableCell.forTableColumn());
        CustomerStreet.setCellFactory(TextFieldTableCell.forTableColumn());
        CustomerAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        CustomerEmail.setCellFactory(TextFieldTableCell.forTableColumn());

        //for update Product
        ProductHigh.setCellFactory(TextFieldTableCell.forTableColumn());
        ProductWidth.setCellFactory(TextFieldTableCell.forTableColumn());
        ProductCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        CustomerName.setCellFactory(TextFieldTableCell.forTableColumn());


        try {
            String query = "SELECT * FROM Worker";
            ResultSet rs = ref1.sql(query);
            workerTable.getItems().clear();
            // Workers
            while(rs.next())
            {
                Worker s1 = new Worker(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5));
                workerTable.getItems().add(s1);
            }
            // Customers
            query = "SELECT * FROM CUSTOMER";
            rs = ref1.sql(query);
            while(rs.next())
            {
                Customers s1 = new Customers(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5), rs.getString(6) , rs.getString(7));
                CustomerTable.getItems().add(s1);
            }

            query = "SELECT * FROM PRODUCT";
            rs = ref1.sql(query);
            while(rs.next())
            {
                Product s1 = new Product(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5));
                ProductTable.getItems().add(s1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }


    @FXML
    public void UpdateWorkerName(TableColumn.CellEditEvent<Worker, String> event) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        worker.setName(event.getNewValue());
        String x = worker.getName();
        ObservableList<Worker> obs;
        obs = workerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Worker set name = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }
    @FXML
    public void UpdateWorkerPhone(TableColumn.CellEditEvent<Worker, String> event) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        worker.setPhone(event.getNewValue());
        String x = worker.getPhone();
        ObservableList<Worker> obs;
        obs = workerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Worker set phone = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateWorkerAddress(TableColumn.CellEditEvent<Worker, String> event) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        worker.setAddress(event.getNewValue());
        String x = worker.getAddress();
        ObservableList<Worker> obs;
        obs = workerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Worker set address = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateCustomerName(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = CustomerTable.getSelectionModel().getSelectedItem();
        customers.setName(event.getNewValue());
        String x = customers.getName();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set name = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateCustomerPhone(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = CustomerTable.getSelectionModel().getSelectedItem();
        customers.setPhone(event.getNewValue());
        String x = customers.getPhone();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set phonenumber = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateCustomerCity(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = CustomerTable.getSelectionModel().getSelectedItem();
        customers.setCity(event.getNewValue());
        String x = customers.getCity();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set city = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateCustomerStreet(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = CustomerTable.getSelectionModel().getSelectedItem();
        customers.setStreet(event.getNewValue());
        String x = customers.getStreet();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set street = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateCustomerAddress(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = CustomerTable.getSelectionModel().getSelectedItem();
        customers.setAddress(event.getNewValue());
        String x = customers.getAddress();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set address = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }

    }

    private void refactor(Customers customers) {
        String x = customers.getAddress();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set address = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateCustomerEmail(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = CustomerTable.getSelectionModel().getSelectedItem();
        customers.setEmail(event.getNewValue());
        String x = customers.getEmail();
        ObservableList<Customers> obs;
        obs = CustomerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set email = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateProductCategory(TableColumn.CellEditEvent<Product, String> event) {
        Product product = ProductTable.getSelectionModel().getSelectedItem();
        product.setCategory(event.getNewValue());
        String x = product.getCategory();
        ObservableList<Product> obs;
        obs = ProductTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Product set category = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateProductWidth(TableColumn.CellEditEvent<Product, String> event) {
        Product product = ProductTable.getSelectionModel().getSelectedItem();
        product.setWidth(event.getNewValue());
        String x = product.getWidth();
        ObservableList<Product> obs;
        obs = ProductTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Product set width = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    public void UpdateProductHigh(TableColumn.CellEditEvent<Product, String> event) {
        Product product = ProductTable.getSelectionModel().getSelectedItem();
        product.setHigh(event.getNewValue());
        String x = product.getHigh();
        ObservableList<Product> obs;
        obs = ProductTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Product set high = '" + x + "' "
                    + "where id = '" + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            System.out.println(exception);
        }

    }
}
