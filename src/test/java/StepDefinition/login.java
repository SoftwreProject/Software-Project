package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Login;

import static org.testng.AssertJUnit.assertEquals;

public class login {
    String result;
    Login ref = new Login();
    @When("I type in email {string} And I type in password {string}")
    public void iTypeInEmailAndITypeInPassword(String arg0, String arg1) {
        result = ref.setresult(arg0 , arg1);
    }


    @Then("I should see E-mail or password is incorrect")
    public void iShouldSeeEMailOrPasswordIsIncorrect() {
        assertEquals("E-mail or password is incorrect" , result);
    }

    @Then("I should see Access your account")
    public void iShouldSeeAccessYourAccount() {
        assertEquals("Access your account successfully" , result);
    }



}
