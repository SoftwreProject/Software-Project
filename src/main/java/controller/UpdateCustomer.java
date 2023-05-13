package controller;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        try (PreparedStatement stm = conn.prepareStatement("UPDATE customer SET name = ?, address = ?, phonenumber = ?, city = ?, street = ? WHERE id = ?")) {
            stm.setString(1, getName());
            stm.setString(2, getAddress());
            stm.setString(3, getPhone());
            stm.setString(4, getCity());
            stm.setString(5, getStreet());
            stm.setString(6, id);

            int t = stm.executeUpdate();
            if (t == 0) {
                flag = 1;
            }
        } catch (SQLException e) {
            Logger.getLogger("You are in update customer page");
        }
    }
    public String getResult() {
        if (flag == 1)
            result = "Please check the ID you entered";
        else result = "Customer Information Updated Successfully";

        return result;

    }

}
