package controller;
import com.jfoenix.controls.JFXRadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class AddWorker {
    AddCustomer ref = new AddCustomer();
    public void addWorkers(TextField id, TextField name, TextField phone, TextField address, JFXRadioButton button, Label label) {


        if (id.getText().equals("") || name.getText().equals("") || phone.getText().equals("") || address.getText().equals("") || !button.isSelected()) {
            label.setText("Please Fill All information About worker <3");
        } else {
            String s = "insert into WORKER values ('" + id.getText() + "'" + "," + "'" + name.getText() + "'" + "," + "'" + phone.getText() + "'" + "," + "'" + address.getText() + "'" + "," + "'" + button.getText() + "','" +  "available" + "')";
            try {
                ref.sql(s);
                label.setText("Worker Added Successfully");
                id.setText("");
                name.setText("");
                phone.setText("");
                address.setText("");
                button.setSelected(false);
            } catch (Exception ex) {
                label.setText("Use Another ID");
                new animatefx.animation.Shake(label).play();
            }
        }

    }
}
