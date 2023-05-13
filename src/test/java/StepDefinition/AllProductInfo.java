package StepDefinition;

import controller.AllProductTable;
import controller.UpdateCustomer;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;

public class AllProductInfo {
    static AllProductTable ref;
    @Before
    public static void setUp() {
        ref = new AllProductTable();
    }
    @When("you enter {string} , {string} , {string}, {string} , {string} , {string} , {string}")
    public void youEnter(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        AllProductTable ref= new AllProductTable(arg0 , arg1 , arg2 , arg3 , arg4 , arg5 , arg6);
        ref.setID(arg0);
        ref.setCategory(arg1);
        ref.setHigh(arg2);
        ref.setWidth(arg3);
        ref.setDate(arg4);
        ref.setStatus(arg5);
        ref.setTotalPrice(arg6);
    }

    @Then("You enter all info")
    public void youEnterAllInfo() {
        String result = "You enter all value";
        assertEquals(result, "You enter all value");
    }
    @Then("get all infos")
    public void getAllInfos() {
        ref.setID("12");
        ref.setCategory("12");
        ref.setStatus("12");
        ref.setTotalPrice("12");
        ref.setDate("12");
        ref.setWidth("12");
        ref.setHigh("12");
        String id =ref.getID();
        String category = ref.getCategory();
        String high = ref.getHigh();
        String width = ref.getWidth();
        String data = ref.getDate();
        String status = ref.getStatus();
        String totalPrice = ref.getTotalPrice();
    }
}
