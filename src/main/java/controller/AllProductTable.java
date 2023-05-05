package controller;

import javafx.beans.property.SimpleStringProperty;

public class AllProductTable {
    SimpleStringProperty id;
    SimpleStringProperty category;
    SimpleStringProperty high;
    SimpleStringProperty width;
    SimpleStringProperty date;
    SimpleStringProperty status;
    SimpleStringProperty totalPrice;

    public AllProductTable(String id, String category, String high, String width, String date, String status, String totalPrice) {
        this.id = new SimpleStringProperty(id);
        this.category = new SimpleStringProperty(category);
        this.high = new SimpleStringProperty(high);
        this.width =new SimpleStringProperty(width);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
        this.totalPrice = new SimpleStringProperty(totalPrice);
    }

    public void setID(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public void setCategory(String category) {
        this.category = new SimpleStringProperty(category);
    }

    public void setHigh(String high) {
        this.high = new SimpleStringProperty(high);
    }

    public void setWidth(String width) {
        this.width = new SimpleStringProperty(width);
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
    }

    public void setStatus(String status) {
        this.status = new SimpleStringProperty(status);
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = new SimpleStringProperty(totalPrice);
    }

    public String getID() {
        return id.get();
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
    public String getDate() {
        return date.get();
    }
    public String getStatus() {
        return status.get();
    }
    public String getTotalPrice() {
        return totalPrice.get();
    }

}
