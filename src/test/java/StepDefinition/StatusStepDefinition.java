package StepDefinition;

import controller.CustomerHomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.AssertJUnit.assertEquals;

public class StatusStepDefinition {
    static CustomerHomePage ref = new CustomerHomePage();
    static String status;
    @Before
    public static void setUp() {
        ref = new CustomerHomePage();
        status = "";
    }
    @Given("you are in customer page")
    public void youAreInCustomerPage() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Customer Page");
        System.out.println("- - - - - - - - - - - - - - - - -");
    }

    @When("you want to show the status of product with your {string}")
    public void youWantToShowTheStatusOfProductWithYour(String arg0) {
        ref.refreshStat(arg0);
        status = ref.test();
    }

    @Then("you should show the message no product")
    public void youShouldShowTheMessageNoProduct() {
        assertEquals( "There is no product",status);
    }
}
