package StepDefinition;

import controller.UpdateProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    public void youTypeIn(String id, String owner, String category, String high, String width) throws SQLException {
        ref.setId(id);
        ref.getId();
        ref.setOwner(owner);
        ref.setCategory(category);
        ref.setHigh(high);
        ref.setWidth(width);
        ref.updateProduct(id);
        result = ref.getResult();
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
