package controller;

import javafx.beans.property.SimpleStringProperty;
import oracle.jdbc.datasource.impl.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProduct {
    String result;
     int flag = 0;

    private SimpleStringProperty id;
    private SimpleStringProperty owner;
    private SimpleStringProperty category;
    private SimpleStringProperty high;
    private SimpleStringProperty width;

    public UpdateProduct() {
    }

    public void updateProduct(String id) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
       try (Statement stm = conn.createStatement()) {
           String query = "update product set name = '" + owner.get() +"' , category = '" + category.get() +"' ,high =  '" + high.get() +"', " +
                   "width = '" + width.get() +"' where id = '" +getId()+"'";

           int t = stm.executeUpdate(query);
           if (t == 0)
               flag =1;
       }
    }
    public String getResult() {
        if (flag == 1)
            result = "Please check the ID you entered";
        else result = "Product Information Updated Successfully";

        return result;

    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getOwner() {
        return owner.get();
    }
    public void setOwner(String owner) {
        this.owner.set(owner);
    }

    public String getCategory() {
        return category.get();
    }
    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getHigh() {
        return high.get();
    }
    public void setHigh(String high) {
        this.high.set(high);
    }

    public String getWidth() {
        return width.get();
    }
    public void setWidth(String width) {
        this.width.set(width);
    }
}
