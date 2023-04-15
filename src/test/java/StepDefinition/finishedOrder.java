package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import software.FinishedOrder;

public class finishedOrder {
    FinishedOrder F = new FinishedOrder();
    @Given("The order is finished")
    public void the_order_is_finished() {
        System.out.println("The Order is finished");
    }
    @When("The time of order is finished")
    public void the_time_of_order_is_finished() {
        System.out.println("The time of order is finished");
    }
    @Then("The email should be sending to the user successfully")
    public void the_email_should_be_sending_to_the_user_successfully() {
        assert (F.endTimeOfOrder.equals("16/5/2002"));

    }
}
