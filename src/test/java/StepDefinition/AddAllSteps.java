package StepDefinition;

import controller.AddAll;
import controller.AddCustomer;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;

public class AddAllSteps {
   static AddAll ref ;
   static String result;
    @Before
    public static void setUp() {
        ref = new AddAll();
        result = "";
    }
    @Given("you are in add all page")
    public void youAreInAddAllPage() {
        Logger.getLogger("You are in add all page");
    }

    @When("you write the {string}")
    public void youWriteThe(String arg0) {
        int x = ref.showStatus(arg0);
        result = ref.getStatus(x);
    }

    @Then("You will get Empty id")
    public void youWillGetEmptyId() {
        assertEquals(result, "Empty ID");
    }

    @Then("You will get Wrong ID")
    public void youWillGetWrongID() {
        assertEquals(result, "Wrong ID");
    }

    @Then("You will get the result")
    public void youWillGetTheResult() {
        assertEquals(result, "Get the status");
    }
}
