package software;
import javafx.beans.property.SimpleStringProperty;
public class Customers {
    SimpleStringProperty id;
    SimpleStringProperty name ;
    SimpleStringProperty phone;
    SimpleStringProperty address;
    SimpleStringProperty city;
    SimpleStringProperty street;
    SimpleStringProperty email;


    public Customers () {}

    public Customers(String id, String name, String phone, String address, String city, String street , String email) {
        this.id = new SimpleStringProperty(id);
        this.name =new SimpleStringProperty(name);
        this.phone =new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.city =new SimpleStringProperty(city);
        this.street =new SimpleStringProperty(street);
        this.email = new SimpleStringProperty(email);
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public void setEmail(String email) {this.email = new SimpleStringProperty(email);}
    public String getId() {
        return id.get();
    }
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }
    public void setPhone(String phone) {
        this.phone = new SimpleStringProperty(phone);
    }
    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }
    public void setCity(String city) {
        this.city = new SimpleStringProperty(city);
    }
    public void setStreet(String street) {
        this.street = new SimpleStringProperty(street);
    }
    public String getName() {
        return name.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getStreet() {
        return street.get();
    }
    public String getEmail () {return email.get();}

}
