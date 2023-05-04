package software;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    SimpleStringProperty id;
    SimpleStringProperty category;
    SimpleStringProperty high;
    SimpleStringProperty width;
    SimpleStringProperty owner;
    SimpleStringProperty worker;
    SimpleStringProperty status;
    SimpleStringProperty endDate;
    public Product() {}
    public Product(String id, String owner,String category, String high, String width , String worker, String status, String endDate) {
        this.id = new SimpleStringProperty(id);
        this.category = new SimpleStringProperty(category);
        this.high = new SimpleStringProperty(high);
        this.width = new SimpleStringProperty(width);
        this.owner = new SimpleStringProperty(owner);
        this.worker = new SimpleStringProperty(worker);
        this.status = new SimpleStringProperty(status);
        this.endDate = new SimpleStringProperty(endDate);
    }
    public void setId(String id) {this.id = new SimpleStringProperty(id);}

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

    public String getWorker() {
        return worker.get();
    }



    public void setWorker(String worker) {
        this.worker= new SimpleStringProperty(worker);
    }

    public String getStatus() {
        return status.get();
    }
    public void setStatus(String status) {
        this.status = new SimpleStringProperty(status);
    }

    public String getEndDate() {
        return endDate.get();
    }
    public void setEndDate(String endDate) {
        this.endDate = new SimpleStringProperty(endDate);
    }
}
