package StepDefinition;

import controller.DeleteProduct;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class DeleteProductSteps {
    String result ;
    DeleteProduct ref = new DeleteProduct();
    @When("you type in  {string} or {string}")
    public void youTypeInOr(String arg0, String arg1) throws SQLException {
        ref.deleteProduct(new SimpleStringProperty(arg0) , new SimpleStringProperty(arg1));
        result = ref.getResult();
    }

    @Then("please fill valid information")
    public void pleaseFillValidInformation() {
        assertEquals(result , "please fill correct information");
    }

    @Then("i should show product Deleted Successfully")
    public void iShouldShowProductDeletedSuccessfully() {
        assertEquals(result , "Product Deleted Successfully");
    }
}
