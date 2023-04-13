package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProduct {
    String result;
    int flag;

    AddCustomer ref = new AddCustomer();

    public void AddProduct(SimpleStringProperty id, SimpleStringProperty owner, SimpleStringProperty category, SimpleStringProperty high, SimpleStringProperty width) throws SQLException {

        if (id.get().equals("") || owner.get().equals("") || category.get().equals("") ||
                high.get().equals("") || width.get().equals("")) {
            flag = 1;

        } else {
            String s = "insert into product values ( '" + id.get() + "','" + owner.get() + "','" + category.get()
                    + "','" + high.get() + "','" + width.get() + "')";
            try {
                ref.sql(s);
                flag = 0;
            } catch (Exception ex) {
                flag = 2;
            }


        }
    }

    public String GetResult() {
        if (flag == 1)
            result = "Please fill in all information";
        else if (flag == 2)
            result = "Please Enter a new ID";

        else result = "the product added successfully";
        return result;

    }

    public void AddProductGUI(TextField id, TextField owner, String category, String high, String width, Label label) {
        if (id.getText().equals("") || owner.getText().equals("") || category.isEmpty() ||
                high.equals("") || width.equals("")) {
            label.setText("Please Fill All Informations");

        } else {
            String s = "insert into product values ( '" + id.getText() + "','" + owner.getText() + "','" + category
                    + "','" + high+ "','" + width+ "')";
            label.setText("Product Added Successfully");
            try {
                ref.sql(s);
            } catch (Exception ex) {
//                label.setText("Check The Owner ID");
                System.out.println(ex);
            }
        }
    }
}
