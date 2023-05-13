package StepDefinition;

import controller.AddCustomer;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import software.Customers;

import static org.testng.AssertJUnit.assertEquals;

public class addCustomer {
    static String  result;
    static AddCustomer ref ;

    @Before
    public static void setUp() {
        ref = new AddCustomer();
        result = "";
    }
    @Given("you are in login page")
    public void youAreInLoginPage() {
        System.out.println("*-----------------------------------*");
        System.out.println("Welcome To Cleaning Service Company");
        System.out.println("*-----------------------------------*");
    }
    @Then("I should see Enter new id")
    public void iShouldSeeEnterNewId() {
        assertEquals(result ,  "Please Enter a new ID" );
    }
    @Then("I should see Please fill in all information about yourself")
    public void iShouldSeePleaseFillInAllInformationAboutYourself() {
        assertEquals("Please fill in all information about yourself" , result);

    }

    @Then("I should see the customer added successfully")
    public void iShouldSeeTheCustomerAddedSuccessfully() {
        assertEquals("the customer added successfully" , result);
    }

    @When("you type in {string} ,{string}, {string}, {string}, {string}, {string} and  {string} , {string}")
    public void youTypeInAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
        Customers customers = new Customers(arg0 , arg1 , arg2 , arg3 , arg4 , arg5 , arg6 , arg7);
        ref.addCustomerTest(customers);
        result = ref.addCustomerGUI(customers);
        result = ref.getResult();
    }

    @Then("I should see the customers added successfully")
    public void iShouldSeeTheCustomersAddedSuccessfully() {
        assertEquals("the customer added successfully" , result);
    }
}
