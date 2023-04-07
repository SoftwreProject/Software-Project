package controller;

import javafx.beans.property.SimpleStringProperty;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProduct {
    String result;
    int flag ;

    public void AddProduct(SimpleStringProperty id, SimpleStringProperty name, SimpleStringProperty category, SimpleStringProperty high, SimpleStringProperty width) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();
        if (id.get().equals("") || name.get().equals("") || category.get().equals("") ||
                high.get().equals("") || width.get().equals("")) {
            flag = 1;

        } else {

            String s = "insert into product values ( '" + id.get() +"','" + name.get() +"','" + category.get()
                    +"','" + high.get() +"','" +width.get()+"')";
            try {
                stm.executeUpdate(s);
                flag = 0;
            }catch (Exception ex) {
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
}
