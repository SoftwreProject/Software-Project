package software;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    SimpleStringProperty id;
    SimpleStringProperty name ;
    SimpleStringProperty category;
    SimpleStringProperty high;
    SimpleStringProperty width;
    SimpleStringProperty owner;
    public Product() {}
    public Product(String id, String name, String category, String high, String width , String owner) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.high = new SimpleStringProperty(high);
        this.width = new SimpleStringProperty(width);
        this.owner = new SimpleStringProperty(owner);
    }
    public void setId(String id) {this.id = new SimpleStringProperty(id);}
    public void setName(String name) {
        this.name =new SimpleStringProperty(name);
    }

    public void setCategory(String category) {
        this.category = new SimpleStringProperty(category);
    }

    public void setHigh(String high) {
        this.high =new SimpleStringProperty(high);
    }
    public void setOwner(String owner) {this.owner = new SimpleStringProperty(owner);}

    public void setWidth(String width) {
        this.width = new SimpleStringProperty(width);
    }
    public String getId() {return id.get();}
    public String getName() {
        return name.get();
    }

    public String getCategory() {
        return category.get();
    }

    public String getHigh() {
        return high.get();
    }

    public String getWidth() {
        return width.get();
    }
    public String getOwner() {return owner.get();}
}
