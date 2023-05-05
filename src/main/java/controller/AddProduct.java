package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import software.Product;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class AddProduct {
    String result;
    String insert = "insert into product values ( '";
    int flag;

    AddCustomer ref = new AddCustomer();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    public void addProduct(SimpleStringProperty id, SimpleStringProperty owner, SimpleStringProperty category, SimpleStringProperty high, SimpleStringProperty width) {
    Date date = new Date();
    SimpleDateFormat formatter1 = new SimpleDateFormat( "dd/MM/yyyy");
    String s;
        if (id.get().equals("") || owner.get().equals("") || category.get().equals("") ||
                high.get().equals("") || width.get().equals("")) {
            flag = 1;

        } else {
            if (category.get().equals("Carpet")){
                 s = insert + id.get() + "','" + owner.get() + "','" + category.get()
                        + "','" + high.get() + "','" + width.get() + "','" + formatter1.format(date) + "','" + "Waiting" + "','" + (Integer.parseInt(high.get())*Integer.parseInt(high.get()) *4)
                        + "','" +"Unknown" + "','" + "None" + "')";
            }
            else {
                s = insert + id.get() + "','" + owner.get() + "','" + category.get()
                        + "','" + high.get() + "','" + width.get() + "','" + formatter1.format(date) + "','" + "Waiting" + "','" + 25
                        + "','" +"Unknown" + "','" + "None" + "')";
            }

            try {
                ref.sql(s);
                flag = 0;
            } catch (Exception ex) {
                Logger.getLogger("You are in add product");
                flag = 2;
            }


        }
    }

    public String getResult() {
        if (flag == 1)
            result = "Please fill in all information";
        else if (flag == 2)
            result = "Please Enter a new ID";

        else result = "the product added successfully";
        return result;

    }

    public void addProductGUI(Product product,  Label label) {
        String s = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        if (product.getId().equals("") || product.getOwner().equals("") || product.getCategory().isEmpty() ||
                product.getHigh().equals("") || product.getWidth().equals("")) {
            label.setText("Please Fill All Informations");

        } else {
            if (product.getCategory().equals("Cover")) {
                 s = insert + product.getId() + "','" + product.getOwner() + "','" + product.getCategory()
                        + "','" + product.getHigh() + "','" + product.getWidth()
                         + "','" + formatter.format(date) + "','" + product.getStatus() + "','" + "25" + "','" + product.getEndDate() + "','" + product.getWorker() +"')";
                label.setText("Product Added Successfully");

            }
            else if (product.getCategory().equals("Carpet")){
                int price = Integer.parseInt(product.getHigh()) * Integer.parseInt(product.getWidth()) * 4;
                 s = insert + product.getId() + "','" + product.getOwner() + "','" + product.getCategory()
                        + "','" + product.getHigh() + "','" + product.getWidth() + "','" + formatter.format(date) + "','" + product.getStatus() + "','" + price +"','" + product.getEndDate()+"','" + product.getWorker()+ "')";
                label.setText("Product Added Successfully");

            }
            try {
                ref.sql(s);
                s = "Select Sum(TotalPrice) from Product where owner = '" + product.getOwner() +"'";
               int x = customerHomePage.getCount(s);
               s = "Update Customer " +
                       "Set TotalPrice = '" + x +"' " +
                       "Where id = '" + product.getOwner()+"'";
               ref.sql(s);


            } catch (Exception ex) {
                label.setText("Check The Owner ID or Enter new ID ofr product");
                new animatefx.animation.Shake(label).play();
                Logger.getLogger(ex.toString());
            }
        }
    }
}
