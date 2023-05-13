package StepDefinition;

import controller.AddProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Product;

import static org.testng.AssertJUnit.assertEquals;

public class AddProductGUI {
    static AddProduct ref ;
    static String result;
    @Before
    public static void setUp() {
        ref = new AddProduct();
        result = "";
    }
    @When("When you type {string} ,{string}, {string}, {string}, {string}")
    public void whenYouType(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Product product = new Product(arg0, arg1 , arg2 , arg3 , arg4  ,"Unknown", "Waiting" , "Unknown");
        result = ref.addProductGUI(product);
    }

    @Then("I should see Cover Product added Successfully")
    public void iShouldSeeCoverProductAddedSuccessfully() {
        assertEquals(result , "Cover Product added");
    }

    @Then("I should see Carpet Product added Successfully")
    public void iShouldSeeCarpetProductAddedSuccessfully() {
        assertEquals(result, "Carpet Product added");
    }

    @Then("i should show please fill all information about the product")
    public void iShouldShowPleaseFillAllInformationAboutTheProduct() {
        assertEquals(result, "Please fill in all information");
    }
}
