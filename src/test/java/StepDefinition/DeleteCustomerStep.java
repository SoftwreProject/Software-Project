package StepDefinition;

import controller.DeleteCustomer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class DeleteCustomerStep {
    DeleteCustomer ref = new DeleteCustomer();
    String result;

    @When("you type in {string} or {string}")
    public void youTypeInOr(String arg0, String arg1) throws SQLException {
    ref.DeleteCustomer(arg0, arg1);
    result = ref.getResult();
    }
    @Then("please fill correct information")
    public void pleaseFillCorrectInformation() {
        assertEquals(result, "please fill correct information");
    }
    @Then("i should show Customer Deleted Successfully")
    public void iShouldShowCustomerDeletedSuccessfully() {
        assertEquals(result, "Customer Deleted Successfully");
    }



}
