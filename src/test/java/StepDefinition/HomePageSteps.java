package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;
import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;

public class HomePageSteps {
    String result;
    @Given("You are in home page")
    public void youAreInHomePage() {
        Logger.getLogger("You are in home page");
    }

    @When("You enter the Query")
    public void youEnterTheQuery() throws SQLException {
        String query = "Select id form customer where id = 'C1'" ;
        controller.HomePage ref = new controller.HomePage();
        result =  ref.getFromDatabase(query);
    }

    @Then("you must show the Done")
    public void youMustShowTheDone() {
        assertEquals(result , "C1");
    }
}
