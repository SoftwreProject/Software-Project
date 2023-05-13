package controller;

import javafx.beans.property.SimpleStringProperty;
import oracle.jdbc.datasource.impl.OracleDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DeleteProduct {
    String result;
    int flag;
    public void deleteProduct(SimpleStringProperty id, SimpleStringProperty name) {
        try {
            String query = "DELETE FROM product WHERE id = '" + id.get() + "' OR owner = '" + name.get() + "'";
            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();
            deleteProductById(conn, id.get());
        } catch (Exception ex) {
            Logger.getLogger("You are in delete product");
        }
    }

    private void deleteProductById(Connection conn, String productId) {
        try (PreparedStatement stm = conn.prepareStatement("DELETE FROM product WHERE id = ?")) {
            stm.setString(1, productId);
            int x = stm.executeUpdate();
            if (x <= 0) {
                flag = 0;
            } else {
                flag = 1;
            }
        } catch (SQLException ex) {
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
