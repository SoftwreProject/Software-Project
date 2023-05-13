package StepDefinition;

import controller.ViewAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class ShowCustomerInformation {
    static String result;
    static ViewAll ref = new ViewAll();
    @Before
    public static void setUp() {
        ref = new ViewAll();
        result = "";
    }

    @When("you enter the {string}")
    public void youEnterThe(String arg0) throws SQLException {
        result  = ref.showCustomerInformation(arg0);
    }

    @Then("you must show Empty ID")
    public void youMustShowEmptyID() {
        assertEquals(result , "Empty ID");
    }

    @Then("you must show Wrong ID")
    public void youMustShowWrongID() {
        assertEquals(result, "Incorrect ID");
    }

    @Then("you must show the information of customer")
    public void youMustShowTheInformationOfCustomer() {
        String customer = "C111,Ayham Dw,898989,Buliding 12,Nablus,Sofen,ayham.1399@gmail.com,123456,50";
        assertEquals(result , customer);
    }
}
