package software;

import javafx.beans.property.SimpleStringProperty;

public class Worker {
    SimpleStringProperty id;



    SimpleStringProperty name ;
    SimpleStringProperty phone;
    SimpleStringProperty address;
    SimpleStringProperty city;
    SimpleStringProperty street;



    SimpleStringProperty specialization;



    public Worker () {}
    public Worker(SimpleStringProperty id, SimpleStringProperty name, SimpleStringProperty phone, SimpleStringProperty address, SimpleStringProperty city, SimpleStringProperty street, SimpleStringProperty specialization) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.street = street;
        this.specialization = specialization;
    }
    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public void setPhone(SimpleStringProperty phone) {
        this.phone = phone;
    }

    public void setAddress(SimpleStringProperty address) {
        this.address = address;
    }

    public void setCity(SimpleStringProperty city) {
        this.city = city;
    }

    public void setStreet(SimpleStringProperty street) {
        this.street = street;
    }
    public void setSpecialization(SimpleStringProperty specialization) {
        this.specialization = specialization;
    }


    public SimpleStringProperty getId() {
        return id;
    }
    public SimpleStringProperty getName() {
        return name;
    }

    public SimpleStringProperty getPhone() {
        return phone;
    }

    public SimpleStringProperty getAddress() {
        return address;
    }

    public SimpleStringProperty getCity() {
        return city;
    }

    public SimpleStringProperty getStreet() {
        return street;
    }
    public SimpleStringProperty getSpecialization() {
        return specialization;
    }
}
