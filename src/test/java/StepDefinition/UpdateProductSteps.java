package StepDefinition;

import controller.UpdateProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class UpdateProductSteps {
    static UpdateProduct ref = new UpdateProduct ();
    static String result;
    @Before
    public static void setUp() {
        ref = new UpdateProduct ();
        result = "";
    }
    @When("you type in {string} ,{string}, {string}, {string}, {string}")
    public void youTypeIn(String arg0, String arg1, String arg2, String arg3, String arg4) throws SQLException {
    ref.owner = new SimpleStringProperty(arg1);
    ref.category = new SimpleStringProperty(arg2);
    ref.high = new SimpleStringProperty(arg3);
    ref.width = new SimpleStringProperty(arg4);
    ref.updateproduct( new SimpleStringProperty(arg0));
    result = ref.GetResult();
    }
    @Then("i should show the id is empty or incorrect")
    public void iShouldShowTheIdIsEmptyOrIncorrect() {
        assertEquals(result , "Please check the ID you entered");
    }

    @Then("i should show the product updated successfully")
    public void iShouldShowTheProductUpdatedSuccessfully() {
        assertEquals(result , "Product Information Updated Successfully");
    }



}
