package StepDefinition;
import controller.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class HomePageSteps {
    private HomePage homePage;
    private String workerCount;
    private String customerCount;
    private String carpetsWorkerCount;
    private String coverWorkerCount;
    private String carpetProductCount;
    private String coverProductCount;
    private String moneyForCarpet;
    private String moneyForCover;

    @Given("you are on the Home page")
    public void youAreOnHomePage() {
        homePage = new HomePage();
    }

    @When("you center the Home page")
    public void youCenterHomePage() throws Exception {
//        homePage.centerHomePage(null);
    }

    @Then("you should see the following data:")
    public void youShouldSeeTheFollowingData(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String label = row.get("Label");
            String expectedValue = row.get("Expected Value");

            switch (label) {
                case "Worker Count":
                    Assert.assertEquals(expectedValue, homePage.WorkerCountLabel.getText());
                    break;
                case "Customer Count":
                    Assert.assertEquals(expectedValue, homePage.customerCountLabel.getText());
                    break;
                case "Carpets Worker Count":
                    Assert.assertEquals(expectedValue, homePage.carpetsWorkerCountLabel.getText());
                    break;
                case "Cover Worker Count":
                    Assert.assertEquals(expectedValue, homePage.coverWorkerContLabel.getText());
                    break;
                case "Carpet Product Count":
                    Assert.assertEquals(expectedValue, homePage.carpetProductCountLabel.getText());
                    break;
                case "Cover Product Count":
                    Assert.assertEquals(expectedValue, homePage.coverProductCountLabel.getText());
                    break;
                case "Money for Carpet":
                    Assert.assertEquals(expectedValue, homePage.moneyForCarpetLabel.getText());
                    break;
                case "Money for Cover":
                    Assert.assertEquals(expectedValue, homePage.moneyForCoverLabels.getText());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid label: " + label);
            }
        }
    }
}
