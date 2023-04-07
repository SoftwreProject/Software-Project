package controller;

import javafx.beans.property.SimpleStringProperty;
import oracle.jdbc.datasource.impl.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProduct {
    String result;
    int flag = 0;
    public SimpleStringProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty category;
    public SimpleStringProperty high;
    public SimpleStringProperty width;

    public void updateproduct(SimpleStringProperty id) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();
        String query = "update product set name = '" + name.get() +"' , category = '" + category.get() +"' ,high =  '" + high.get() +"', " +
                "width = '" + width.get() +"' where id = '" +id.get()+"'";

        int t = stm.executeUpdate(query);
        if (t == 0)
            flag =1;
    }
    public String GetResult() {
        if (flag == 1)
            result = "Please check the ID you entered";
        else result = "Product Information Updated Successfully";

        return result;

    }
}
