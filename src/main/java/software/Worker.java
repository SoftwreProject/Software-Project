package software;

import javafx.beans.property.SimpleStringProperty;

public class Worker {
    SimpleStringProperty id;
    SimpleStringProperty name ;
    SimpleStringProperty phone;
    SimpleStringProperty address;
    SimpleStringProperty specialization;



    public Worker () {}
    public Worker(String id, String name, String phone, String address,  String specialization) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty (name);
        this.phone =  new SimpleStringProperty (phone);
        this.address =  new SimpleStringProperty(address);
        this.specialization = new SimpleStringProperty (specialization);
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setPhone(String phone) {
        this.phone =new SimpleStringProperty(phone);
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }
    public void setSpecialization(String specialization) {
        this.specialization = new SimpleStringProperty( specialization);
    }



    public String getId() {
        return id.get();
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

    public String getSpecialization() {
        return specialization.get();
    }
}
