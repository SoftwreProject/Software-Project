package StepDefinition;

import controller.UpdateCustomer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class UpdateCustomerStep {
    UpdateCustomer ref = new UpdateCustomer();
    String result ;
    @When("you type in field {string} ,{string}, {string}, {string}, {string} And {string}")
    public void youTypeInFieldAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
        ref.name = arg1;
        ref.phone = arg2;
        ref.address = arg3;
        ref.city = arg4;
        ref.street = arg5;
        ref.UpdateCustomers(arg0);
        result = ref.GetResult();
    }

    @Then("i should show the id is empty or in correct")
    public void iShouldShowTheIdIsEmptyOrInCorrect() {
        assertEquals("Please check the ID you entered" , result);
    }

    @Then("i should show the user updated successfully")
    public void iShouldShowTheUserUpdatedSuccessfully() {
        assertEquals("Customer Information Updated Successfully" , result);
    }
}
