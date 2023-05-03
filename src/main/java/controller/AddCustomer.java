package controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.datasource.impl.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCustomer {
    String result;
    int flag = 0;

    public void sql(String s) throws SQLException {

            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();
            try ( Statement stm = conn.createStatement()) {
                stm.executeUpdate(s);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }


    }

    @FXML
    public void addCustomerTest(SimpleStringProperty id, SimpleStringProperty name, SimpleStringProperty phone, SimpleStringProperty address, SimpleStringProperty city, SimpleStringProperty street, SimpleStringProperty email, SimpleStringProperty password)  {

        if (id.get().equals("") || name.get().equals("") || phone.get().equals("") || address.get().equals("") || city.get().equals("") || street.get().equals("") || email.get().equals("") || password.get().equals("")) {
            flag = 1;
        } else {
            String s = "insert into CUSTOMER values ( '" + id.get() + "','" + name.get() + "','" + phone.get() + "','" + address.get() + "','" + city.get() + "','" + street.get() + "','" + email.get() + "','" + password.get() + "','" + "0" + "') ";
            try {
                sql(s);
                flag = 0;
            } catch (Exception ex) {
                flag = 2;
            }


        }
    }

    @FXML
    public String getResult() {
        if (flag == 1)
            result = "Please fill in all information about yourself";
        else if (flag == 2)
            result = "Please Enter a new ID";
        else result = "the customer added successfully";
        return result;

    }

    public void addCustomerGUI(TextField id, TextField name, TextField phone, TextField address, TextField city, TextField street, TextField email, TextField password, Label label) {
        if (id.getText().equals("") || name.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || city.getText().equals("") || street.getText().equals("") || email.getText().equals("") || password.getText().equals("")) {
            label.setText("Please Enter All information");
        } else {
            String s = "insert into CUSTOMER values ( '" + id.getText() + "','" + name.getText() + "','" + phone.getText() + "','" + address.getText() + "','" + city.getText() + "','" + street.getText() + "','" + email.getText() + "','" + password.getText() + "')";
            label.setText("Customer Added Successfully");
            try {
                sql(s);
            } catch (Exception ex) {
                label.setText("Use Another ID");
                new animatefx.animation.Shake(label).play();
            }
        }

    }
}
