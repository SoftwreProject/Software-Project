package controller;
import com.jfoenix.controls.JFXRadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import software.Product;
import software.Worker;


public class AddWorker {
    AddCustomer ref = new AddCustomer();
    public String addWorkers(Worker worker) {
        String x;
        int flag ;
        if (worker.getId().equals("") || worker.getName().equals("") || worker.getPhone().equals("") || worker.getAddress().equals("") || worker.getSpecialization().equals("")) {
            flag = 1;
            //label.setText("Please Fill All information About worker");
        } else {
            String s = "insert into WORKER values ('" + worker.getId() + "'" + "," + "'" + worker.getName() + "'" + "," + "'" + worker.getPhone() + "'" + "," + "'" + worker.getAddress() + "'" + "," + "'" + worker.getSpecialization() + "','" +  "available" + "')";
            try {
                ref.sql(s);
                flag = 2;
            } catch (Exception ex) {
                flag = 3;
            }
        }
        if (flag == 1)
            x = "Please Fill All information About worker";
        else if (flag == 2)
            x = "worker added successfully";
        else
            x = "Use another id";
        return x;
    }
}
