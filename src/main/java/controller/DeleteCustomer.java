package controller;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomer {
    String result;
    int flag = 0;
    public void DeleteCustomer(String id , String name) throws SQLException {
        String query = "Delete from Customer where id = '" + id+ "' or name = '" + name +"'";
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();

       int x = stm.executeUpdate(query);
       if (x > 0)
        flag = 1;
       else
           flag = 0;


    }
    public String getResult() {
        if (flag == 1)
            result = "Customer Deleted Successfully";
        else
            result = "please fill correct information";
        return result;
    }
}
