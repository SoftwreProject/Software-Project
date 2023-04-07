package software;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    SimpleStringProperty id;
    SimpleStringProperty name ;
    SimpleStringProperty category;
    SimpleStringProperty high;
    SimpleStringProperty width;
    public Product() {}
    public Product(SimpleStringProperty id, SimpleStringProperty name, SimpleStringProperty category, SimpleStringProperty high, SimpleStringProperty width) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.high = high;
        this.width = width;
    }
    public void setId(SimpleStringProperty id) {this.id = id;}
    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public void setCategory(SimpleStringProperty category) {
        this.category = category;
    }

    public void setHigh(SimpleStringProperty high) {
        this.high = high;
    }

    public void setWidth(SimpleStringProperty width) {
        this.width = width;
    }
    public SimpleStringProperty getId() {return id;}
    public SimpleStringProperty getName() {
        return name;
    }

    public SimpleStringProperty getCategory() {
        return category;
    }

    public SimpleStringProperty getHigh() {
        return high;
    }

    public SimpleStringProperty getWidth() {
        return width;
    }
}
