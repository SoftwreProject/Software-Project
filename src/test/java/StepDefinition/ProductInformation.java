package StepDefinition;

import controller.ViewAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class ProductInformation {
    static ViewAll viewAll;
    static String result;
    @Before
    public static void setUp() {
        viewAll = new ViewAll();
        result = "";
    }
    @Given("you are in Product page")
    public void youAreInProductPage() {
        System.out.println("You Are In Product Page");
    }

    @When("you enter the product {string}")
    public void youEnterTheProduct(String arg0) throws SQLException {
        result = viewAll.showProductInformation(arg0);
    }

    @Then("you must show Empty Product ID")
    public void youMustShowEmptyProductID() {
        assertEquals(result ,"Empty ID");
    }

    @Then("you must show Wrong Product ID")
    public void youMustShowWrongProductID() {
        assertEquals(result , "Incorrect ID");
    }

    @Then("you must show the information of product")
    public void youMustShowTheInformationOfProduct() {
        String product = "P111,C111,Cover,0,0,18/04/2023,Waiting,25,Unknown,None";
        assertEquals(result , product);
    }
}
