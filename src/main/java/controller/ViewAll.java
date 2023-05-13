package controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import software.Customers;
import software.Product;
import software.Worker;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ViewAll implements Initializable {
    AddCustomer ref = new AddCustomer();

    @FXML
    private TableView <Worker> workerTable;
    @FXML
    private TableColumn<Worker , String> idWorker;
    @FXML
    private TableColumn<Worker , String> workerName;
    @FXML
    private TableColumn<Worker , String> workerPhoneNumber;
    @FXML
    private TableColumn<Worker , String> workerAddress;
    @FXML
    private TableColumn<Worker , String> workerSpecialization;
    @FXML
    private TableView <Customers> customerTable;
    @FXML
    private TableColumn<Customers , String> customerID;
    @FXML
    private TableColumn<Customers , String> customerName;
    @FXML
    private TableColumn<Customers , String> customerPhoneNumber;
    @FXML
    private TableColumn<Customers , String> customerCity;
    @FXML
    private TableColumn<Customers , String> customerStreet;
    @FXML
    private TableColumn<Customers , String> customerAddress;
    @FXML
    private TableColumn <Customers , String> customerEmail;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product , String> productID;
    @FXML
    private TableColumn<Product , String> productCategory;
    @FXML
    private TableColumn <Product , String> productHigh;
    @FXML
    private TableColumn<Product , String> productWidth;
    @FXML
    private TableColumn<Product , String> productOwner;
    SignUp ref1 = new SignUp();
    String where = "where id = '";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // for Worker
        idWorker.setCellValueFactory(new PropertyValueFactory<>("Id"));
        workerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        workerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        workerAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        workerSpecialization.setCellValueFactory(new PropertyValueFactory<>("Specialization"));

        // for Customer
        customerID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        customerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        customerCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        customerStreet.setCellValueFactory(new PropertyValueFactory<>("Street"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

        // for Product
        productID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        productCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        productHigh.setCellValueFactory(new PropertyValueFactory<>("High"));
        productWidth.setCellValueFactory(new PropertyValueFactory<>("Width"));
        productOwner.setCellValueFactory(new PropertyValueFactory<>("Owner"));

        // for update Worker
        workerName.setCellFactory(TextFieldTableCell.forTableColumn());
        workerPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        workerAddress.setCellFactory(TextFieldTableCell.forTableColumn());

        //for update customer
        customerName.setCellFactory(TextFieldTableCell.forTableColumn());
        customerPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        customerCity.setCellFactory(TextFieldTableCell.forTableColumn());
        customerStreet.setCellFactory(TextFieldTableCell.forTableColumn());
        customerAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        customerEmail.setCellFactory(TextFieldTableCell.forTableColumn());

        //for update Product
        productHigh.setCellFactory(TextFieldTableCell.forTableColumn());
        productWidth.setCellFactory(TextFieldTableCell.forTableColumn());
        productCategory.setCellFactory(TextFieldTableCell.forTableColumn());
        customerName.setCellFactory(TextFieldTableCell.forTableColumn());


        try {
            String query = "SELECT * FROM Worker";
            showWorkerResultSet(query);
            // Customers
            query = "SELECT * FROM CUSTOMER";
            ResultSet rs = ref1.sql(query);
            while(rs.next())
            {
                Customers s1 = new Customers(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5), rs.getString(6) , rs.getString(7) , rs.getString(8));
                customerTable.getItems().add(s1);
            }

            query = "SELECT * FROM PRODUCT";
            rs = ref1.sql(query);
            while(rs.next())
            {
                Product s1 = new Product(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) ,rs.getString(7), rs.getString(8));
                productTable.getItems().add(s1);
            }
        }catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }




    }


    @FXML
    public void updateWorkerName(TableColumn.CellEditEvent<Worker, String> event) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        worker.setName(event.getNewValue());
        String x = worker.getName();
        ObservableList<Worker> obs;
        obs = workerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Worker set name = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }
    @FXML
    public void updateWorkerPhone(TableColumn.CellEditEvent<Worker, String> event) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        worker.setPhone(event.getNewValue());
        String x = worker.getPhone();
        ObservableList<Worker> obs;
        obs = workerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Worker set phone = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateWorkerAddress(TableColumn.CellEditEvent<Worker, String> event) {
        Worker worker = workerTable.getSelectionModel().getSelectedItem();
        worker.setAddress(event.getNewValue());
        String x = worker.getAddress();
        ObservableList<Worker> obs;
        obs = workerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Worker set address = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateCustomerName(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = customerTable.getSelectionModel().getSelectedItem();
        customers.setName(event.getNewValue());
        String x = customers.getName();
        ObservableList<Customers> obs;
        obs = customerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set name = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateCustomerPhone(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = customerTable.getSelectionModel().getSelectedItem();
        customers.setPhone(event.getNewValue());
        String x = customers.getPhone();
        ObservableList<Customers> obs;
        obs = customerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set phonenumber = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateCustomerCity(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = customerTable.getSelectionModel().getSelectedItem();
        customers.setCity(event.getNewValue());
        String x = customers.getCity();
        ObservableList<Customers> obs;
        obs = customerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set city = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateCustomerStreet(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = customerTable.getSelectionModel().getSelectedItem();
        customers.setStreet(event.getNewValue());
        String x = customers.getStreet();
        ObservableList<Customers> obs;
        obs = customerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set street = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateCustomerAddress(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = customerTable.getSelectionModel().getSelectedItem();
        customers.setAddress(event.getNewValue());
        String x = customers.getAddress();
        ObservableList<Customers> obs;
        obs = customerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set address = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }

    }


    @FXML
    public void updateCustomerEmail(TableColumn.CellEditEvent<Customers, String> event) {
        Customers customers = customerTable.getSelectionModel().getSelectedItem();
        customers.setEmail(event.getNewValue());
        String x = customers.getEmail();
        ObservableList<Customers> obs;
        obs = customerTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Customer set email = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateProductCategory(TableColumn.CellEditEvent<Product, String> event) {
        Product product = productTable.getSelectionModel().getSelectedItem();
        product.setCategory(event.getNewValue());
        String x = product.getCategory();
        ObservableList<Product> obs;
        obs = productTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Product set category = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateProductWidth(TableColumn.CellEditEvent<Product, String> event) {
        Product product = productTable.getSelectionModel().getSelectedItem();
        product.setWidth(event.getNewValue());
        String x = product.getWidth();
        ObservableList<Product> obs;
        obs = productTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Product set width = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }
    }

    @FXML
    public void updateProductHigh(TableColumn.CellEditEvent<Product, String> event) {
        Product product = productTable.getSelectionModel().getSelectedItem();
        product.setHigh(event.getNewValue());
        String x = product.getHigh();
        ObservableList<Product> obs;
        obs = productTable.getSelectionModel().getSelectedItems();
        String id = obs.get(0).getId();
        try {
            String query = "update Product set high = '" + x + "' "
                    + where + id + "'";
            ref.sql(query);
        }catch (Exception exception){
            Logger.getLogger(exception.toString());
        }

    }
    @FXML
    void availableWorker() throws SQLException {
        String query = "SELECT * FROM Worker where status = 'available'";
        showWorkerResultSet(query);
    }
    public void showWorkerResultSet(String query) throws SQLException {
        ResultSet rs = ref1.sql(query);
        workerTable.getItems().clear();
        // Workers
        workerTable.getItems().clear();
        while(rs.next())
        {
            Worker s1 = new Worker(rs.getString(1) ,rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5));
            workerTable.getItems().add(s1);
        }
    }
    public String showCustomerInformation(String id) throws SQLException {
        int flag =  0 ;
        String result ;
        StringBuilder stringBuilder = new StringBuilder();
        String query = "Select * from customer where id = '" + id + "'";

        if (id.isEmpty()) {
            flag = 1;
        }
        else {
            ResultSet rs = ref1.sql(query);
            while (rs.next()) {
                stringBuilder.append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append(",").append(rs.getString(6)).append(",").append(rs.getString(7)).append(",").append(rs.getString(8)).append(",").append(rs.getString(9));
                flag = 2;
            }
            rs.close();
        }
        if (flag == 1)
            result = "Empty ID";
        else if (flag == 2)
            result = stringBuilder.toString();
        else
            result = "Incorrect ID";
        return result;

    }
    public String showProductInformation(String id){
        int flag = 0;
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String query = "Select * from product where id = '" + id + "'";
            if (id.isEmpty()) {
                flag = 1;
            } else {
                ResultSet rs = ref1.sql(query);
                while (rs.next()) {
                    stringBuilder.append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append(",").append(rs.getString(6)).append(",").append(rs.getString(7)).append(",").append(rs.getString(8)).append(",").append(rs.getString(9)).append(",").append(rs.getString(10));
                    flag = 2;
                }
                rs.close();
            }
        }
        catch (Exception ex) {
            Logger.getLogger("You are in show product information");
        }
        if (flag == 1)
            result = "Empty ID";
        else if (flag == 2)
            result = stringBuilder.toString();
        else
            result = "Incorrect ID";
        return result;

    }
}
