package controller;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;


public class UpdateCustomer {
    private String name;
    private String address;
    private String city;
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;
    int flag = 0;
    String result ;
    public void updateCustomers(String id) throws SQLException {
        OracleDataSource orc = new OracleDataSource();
        orc.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
        orc.setUser("software");
        orc.setPassword("123123");
        Connection conn = orc.getConnection();
        try(Statement stm = conn.createStatement()) {
            String query = "update customer set name = '" + getName() + "' , address = '" + getAddress() + "' ,phonenumber =  '" + getPhone() + "', " +
                    "city = '" + getCity() + "' , street = '" + getStreet() + "' " +
                    " where id ='" + id + "'";
            try {
                int t = stm.executeUpdate(query);
                if (t == 0) {
                    flag = 1;
                }
            } catch (Exception e) {
                Logger.getLogger("You are in update customer page");
            }
        }
    }
    public String getResult() {
        if (flag == 1)
            result = "Please check the ID you entered";
        else result = "Customer Information Updated Successfully";

        return result;

    }

}
