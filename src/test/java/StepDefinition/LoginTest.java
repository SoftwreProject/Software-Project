package StepDefinition;


import controller.LoginController;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {
    static String result;
    static LoginController ref ;
    @Before
    public static void setUp() {
        ref  = new LoginController();
        result = "";
    }
    @When("I type in email {string} And I type in password {string}")
    public void iTypeInEmailAndITypeInPassword(String arg0, String arg1) throws SQLException {
        int flag = ref.signInTest(arg0 ,  arg1);
        result = ref.getResult(flag);
    }


    @Then("I should see E-mail or password is incorrect")
    public void iShouldSeeEMailOrPasswordIsIncorrect() {
        assertEquals("wrong password or username" , result);
    }

    @Then("I should see Access your account")
    public void iShouldSeeAccessYourAccount() {
        assertEquals("Access your account successfully" , result);
    }


    @Then("Empty password or username")
    public void emptyPasswordOrUsername() {
        assertEquals("Empty Password or username" , result);
    }
}
