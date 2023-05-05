package StepDefinition;

import controller.UpdateCustomer;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class UpdateCustomerStep {
    static UpdateCustomer ref = new UpdateCustomer();
    static String result ;
    @Before
    public static void setUp() {
        ref = new UpdateCustomer();
        result = "";
    }
    @When("you type in field {string} ,{string}, {string}, {string}, {string} And {string}")
    public void youTypeInFieldAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
        ref.setName(arg1);
        ref.setPhone(arg2);
        ref.setAddress(arg3);
        ref.setCity(arg4);
        ref.setStreet(arg5);
        ref.updateCustomers(arg0);
        result = ref.getResult();
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
