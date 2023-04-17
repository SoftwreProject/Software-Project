package StepDefinition;

import controller.LoginController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class login {
    String result;

    @BeforeClass
    public void BeforeAll() {
    }

    @Test
    @When("I type in email {string} And I type in password {string}")
    public void iTypeInEmailAndITypeInPassword(String arg0, String arg1) throws SQLException {
        LoginController ref  = new LoginController();
        int flag = ref.SignInTest(arg0 ,  arg1);
        result = ref.getResult(flag);
    }

    @Test
    @Then("I should see E-mail or password is incorrect")
    public void iShouldSeeEMailOrPasswordIsIncorrect() {
        assertEquals("wrong password or username" , result);
    }
    @Test
    @Then("I should see Access your account")
    public void iShouldSeeAccessYourAccount() {
        assertEquals("Access your account successfully" , result);
    }

    @Test
    @Then("Empty password or username")
    public void emptyPasswordOrUsername() {
        assertEquals("Empty Password or username" , result);
    }
}
