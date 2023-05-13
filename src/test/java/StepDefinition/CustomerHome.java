package StepDefinition;

import controller.CustomerHomePage;
import controller.UpdateProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.testng.AssertJUnit.assertEquals;

public class CustomerHome {
    static CustomerHomePage ref;
    static String result;
    static String result1;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date dateOfToday = new Date();
    @Before
    public static void setUp() {
        ref = new CustomerHomePage();
    }
    @When("you enter the customer {string}")
    public void youEnterTheCustomer(String arg0) {
        result = ref.setName(arg0);
        result1 = ref.setDate();
    }

    @Then("you should show Empty ID")
    public void youShouldShowEmptyID() {
        assertEquals(result , "Empty ID");
    }

    @Then("you will have the Date of Today")
    public void youWillHaveTheDateOfToday() {
        assertEquals(result1 , "14/05/2023");
    }

    @Then("you should show the name")
    public void youShouldShowTheName() {
        assertEquals(result , "Yaser");
    }

    @When("You enter the {string}")
    public void youEnterThe(String arg0) throws SQLException {
        result = ref.showAll();
        result = ref.showAllInformation();
        result = ref.refreshStat(arg0);
        ref.paidFunction();
    }

    @Then("You will show Done Word")
    public void youWillShowDoneWord() {
        assertEquals(result, "Done");
    }

    @Then("You will show Done")
    public void youWillShowDone() {
        assertEquals(result, "Done");
    }

    @Then("You will Show refresh state")
    public void youWillShowRefreshState() {
        assertEquals(result, "Done");
    }
}
