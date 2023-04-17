package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.datasource.impl.OracleDataSource;
import software.Customers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProduct {
    String result;
    int flag;

    AddCustomer ref = new AddCustomer();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    public void AddProduct(SimpleStringProperty id, SimpleStringProperty owner, SimpleStringProperty category, SimpleStringProperty high, SimpleStringProperty width) throws SQLException {
    Date date = new Date();
    SimpleDateFormat formatter1 = new SimpleDateFormat( "dd/MM/yyyy");
    String s = "";
        if (id.get().equals("") || owner.get().equals("") || category.get().equals("") ||
                high.get().equals("") || width.get().equals("")) {
            flag = 1;

        } else {
            if (category.get().equals("Carpet")){
                 s = "insert into product values ( '" + id.get() + "','" + owner.get() + "','" + category.get()
                        + "','" + high.get() + "','" + width.get() + "','" + formatter1.format(date) + "','" + "Waiting" + "','" + (Integer.parseInt(high.get())*Integer.parseInt(high.get()) *4)
                        + "','" +"Unknown" + "','" + "None" + "')";
            }
            else {
                s = "insert into product values ( '" + id.get() + "','" + owner.get() + "','" + category.get()
                        + "','" + high.get() + "','" + width.get() + "','" + formatter1.format(date) + "','" + "Waiting" + "','" + 25
                        + "','" +"Unknown" + "','" + "None" + "')";
            }

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

    public void AddProductGUI(TextField id, TextField owner, String category, String high, String width , String worker, String status,String EndDate ,  Label label) {
        String s = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        if (id.getText().equals("") || owner.getText().equals("") || category.isEmpty() ||
                high.equals("") || width.equals("")) {
            label.setText("Please Fill All Informations");

        } else {
            if (category.equals("Cover")) {
                 s = "insert into product values ( '" + id.getText() + "','" + owner.getText() + "','" + category
                        + "','" + high + "','" + width + "','" + formatter.format(date) + "','" + status + "','" + "25" + "','" + EndDate + "','" + worker +"')";
                label.setText("Product Added Successfully");

            }
            else if (category.equals("Carpet")){
                int price = Integer.parseInt(high) * Integer.parseInt(width) * 4;
                 s = "insert into product values ( '" + id.getText() + "','" + owner.getText() + "','" + category
                        + "','" + high + "','" + width + "','" + formatter.format(date) + "','" + status + "','" + price +"','" + EndDate+"','" + worker + "')";
                label.setText("Product Added Successfully");

            }
            try {
                ref.sql(s);
                s = "Select Sum(TotalPrice) from Product where owner = '" + owner.getText() +"'";
               int x = customerHomePage.getCount(s);
               s = "Update Customer " +
                       "Set TotalPrice = '" + x +"' " +
                       "Where id = '" +owner.getText()+"'";
               ref.sql(s);


            } catch (Exception ex) {
                label.setText("Check The Owner ID or Enter new ID ofr product");
                new animatefx.animation.Shake(label).play();
                System.out.println(ex);
            }
        }
    }
    public void ClearTextField() {

    }
}
