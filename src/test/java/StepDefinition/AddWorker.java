package StepDefinition;

import controller.AddProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.Worker;

import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;

public class AddWorker {
    static controller.AddWorker ref ;
    static String result;
    @Before
    public static void setUp() {
        ref = new controller.AddWorker();
        result = "";
    }
    @Given("you are in worker page")
    public void youAreInWorkerPage() {
        Logger.getLogger("You are in worker page");
    }

    @When("you enter {string} , {string} , {string}, {string} and {string}")
    public void youEnterAnd(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Worker worker = new Worker(arg0 , arg1 , arg2 , arg3 , arg4);
        result =ref.addWorkers(worker);
    }

    @Then("you should show please fill all informations about the worker")
    public void youShouldShowPleaseFillAllInformationsAboutTheWorker() {
        assertEquals(result ,"Please Fill All information About worker");
    }

    @Then("you should show the worker added successfully")
    public void youShouldShowTheWorkerAddedSuccessfully() {
        assertEquals(result ,"worker added successfully");
    }

    @Then("you should show use another id")
    public void youShouldShowUseAnotherId() {
        assertEquals(result ,"Use another id");
    }
}
