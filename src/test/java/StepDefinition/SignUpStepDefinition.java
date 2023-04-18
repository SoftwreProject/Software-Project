package StepDefinition;

import controller.SignUp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class SignUpStepDefinition {
    static SignUp signUp;
    static String result;

    @Before
    public static void setUp() {
        signUp = new SignUp();
        result = "";
        result = "";
    }

    @Given("you are in signup page")
    public void youAreInSignupPage() {
        System.out.println("You are in SignUp page");
    }



    @Then("you should show please fill all informations")
    public void youShouldShowPleaseFillAllInformations() {
        assertEquals(result, "Empty one or more term");
    }

    @Then("You should Show please enter another id")
    public void youShouldShowPleaseEnterAnotherId() {
        assertEquals(result, "Use another id");
    }

    @When("you write the {string}, {string}, {string}, {string}, {string}, {string}, {string} and \"{}")
    public void youWriteTheAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Exception {
        result = signUp.SignUpTest(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Then("You should Show please enter more than five character")
    public void youShouldShowPleaseEnterMoreThanFiveCharacter() {
        assertEquals(result, "Enter a password more than 5 character");
    }

    @Then("The Customer Added Successfully")
    public void theCustomerAddedSuccessfully() {
        assertEquals(result, "The Customer Added Successfully");
    }
}
