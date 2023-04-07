package StepDefinition;

import controller.AddProduct;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class AddProductSteps {
    AddProduct ref = new AddProduct();
    String result;
    @When("When you type in {string} ,{string}, {string}, {string}, {string}")
    public void whenYouTypeIn(String arg0, String arg1, String arg2, String arg3, String arg4) throws SQLException {
    ref.AddProduct( new SimpleStringProperty(arg0),
            new SimpleStringProperty(arg1),
            new SimpleStringProperty(arg2),
            new SimpleStringProperty(arg3),
            new SimpleStringProperty(arg4));
    result = ref.GetResult();
    }

    @Then("i should show please fill all information")
    public void iShouldShowPleaseFillAllInformation() {
        assertEquals("Please fill in all information" , result);
    }

    @Then("I should see the product added successfully")
    public void iShouldSeeTheProductAddedSuccessfully() {
        assertEquals("the product added successfully" , result);
    }

    @Then("I should see please enter new id")
    public void iShouldSeePleaseEnterNewId() {
        assertEquals(result ,  "Please Enter a new ID" );
    }
}
