package controller;

import javafx.beans.property.SimpleStringProperty;
import oracle.jdbc.datasource.impl.OracleDataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;

public class DeleteProduct {
    String result;
    int flag;
    public void deleteProduct(SimpleStringProperty id , SimpleStringProperty name){
        try{
            String query = "Delete from product where id = '" + id.get()+ "' or owner = '" + name.get() +"'";
            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();

            try (Statement stm = conn.createStatement()) {
                int x = stm.executeUpdate(query);
                if (x <= 0)
                    flag = 0;
                else
                    flag = 1;
            }
        }catch(Exception ex){
            Logger.getLogger("You are in delete product");
        }

    }
    public String getResult() {
        if (flag == 0)
            result = "please fill correct information";
        else
            result = "Product Deleted Successfully";
        return result;
    }

}
