package StepDefinition;

import controller.AddAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class ShowStatus {
    static String result;
    static AddAll addAll = new AddAll();
    @Before
    public static void setUp() {
        addAll = new AddAll();
        result = "";
    }
    @Given("You are in Product page")
    public void youAreInProductPage() {
        System.out.println("You Are in Status Page");
    }

    @When("you enter an {string}")
    public void youEnterAn(String arg0) throws SQLException {
        int flag = addAll.showStatus(arg0);
        result = addAll.getStatus(flag);
    }

    @Then("you must show EmptyID")
    public void youMustShowEmptyID() {
        assertEquals("Empty ID" , result);
    }

    @Then("wrong ID")
    public void wrongID() {
        assertEquals("Wrong ID" , result);
    }

    @Then("Get correctly")
    public void getCorrectly() {
        assertEquals("Waiting" , result);
    }
}
