package controller;

import oracle.jdbc.datasource.impl.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomer {

    AddCustomer ref = new AddCustomer();
    String result;
    int flag = 0;

    public void DeleteGUI(String x) throws SQLException {
        ref.sql(x);
    }
    public int SqlValue( String query){
        int x = 0;
        try{
            OracleDataSource orc = new OracleDataSource();
            orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            orc.setUser("software");
            orc.setPassword("123123");
            Connection conn = orc.getConnection();
            Statement stm = conn.createStatement();
            x = stm.executeUpdate(query);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return x;

    }
    public void DeleteCustomerFunc(String id , String name){
        try{
            String query = "Delete from Customer where id = '" + id+ "' or name = '" + name +"'";
            int x = SqlValue(query);
            if (x > 0)
                flag = 1;
            else
                flag = 0;

        }catch (Exception ex){
            System.out.println(ex);
        }


    }
    public String getResult() {
        if (flag == 1)
            result = "Customer Deleted Successfully";
        else
            result = "please fill correct information";
        return result;
    }
}
