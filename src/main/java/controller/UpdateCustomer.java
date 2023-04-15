package controller;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateCustomer {
    public String name;
    public String address;
    public String city;
    public String street;
    public String phone;
    int flag = 0;
    String result ;
    public void UpdateCustomers(String id) throws SQLException {

        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        Statement stm = conn.createStatement();
        String query = "update customer set name = '" + name +"' , address = '" + address +"' ,phonenumber =  '" + phone +"', " +
                "city = '" + city +"' , street = '" + street +"' " +
                " where id ='" +id+"'" ;
        try {
            int t = stm.executeUpdate(query);
            if (t == 0) {
                 flag =1;
                 throw new SQLException();
            }
        }catch (Exception e) {
            System.out.println(e);
        }



    }
    public String GetResult() {
        if (flag == 1)
            result = "Please check the ID you entered";
        else result = "Customer Information Updated Successfully";

        return result;

    }

}
