package controller;

import javafx.beans.property.SimpleStringProperty;

public class AllProductTable {
    SimpleStringProperty ID;
    SimpleStringProperty Category;
    SimpleStringProperty High;
    SimpleStringProperty Width;
    SimpleStringProperty Date;
    SimpleStringProperty Status;
    SimpleStringProperty TotalPrice;

    public AllProductTable(String ID, String category, String high, String width, String date, String status, String totalPrice) {
        this.ID = new SimpleStringProperty(ID);
        Category = new SimpleStringProperty(category);
        High = new SimpleStringProperty(high);
        Width =new SimpleStringProperty(width);
        Date = new SimpleStringProperty(date);
        Status = new SimpleStringProperty(status);
        TotalPrice = new SimpleStringProperty(totalPrice);
    }

    public void setID(String ID) {
        this.ID = new SimpleStringProperty(ID);
    }

    public void setCategory(String category) {
        this.Category = new SimpleStringProperty(category);
    }

    public void setHigh(String high) {
        this.High = new SimpleStringProperty(high);
    }

    public void setWidth(String width) {
        this.Width = new SimpleStringProperty(width);
    }

    public void setDate(String date) {
        this.Date = new SimpleStringProperty(date);
    }

    public void setStatus(String status) {
        this.Status = new SimpleStringProperty(status);
    }

    public void setTotalPrice(String totalPrice) {
        this.TotalPrice = new SimpleStringProperty(totalPrice);
    }

    public String getID() {
        return ID.get();
    }
    public String getCategory() {
        return Category.get();
    }
    public String getHigh() {
        return High.get();
    }
    public String getWidth() {
        return Width.get();
    }
    public String getDate() {
        return Date.get();
    }
    public String getStatus() {
        return Status.get();
    }
    public String getTotalPrice() {
        return TotalPrice.get();
    }

}
