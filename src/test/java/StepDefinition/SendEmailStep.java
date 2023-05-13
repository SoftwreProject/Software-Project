package StepDefinition;

import controller.SendEmail;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.control.Label;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;

public class SendEmailStep {
    private SendEmail sendEmail;
    private String customerID;
    private String emailRecipient;

    @Mock
    private SendEmail mockedSendEmail;

    public SendEmailStep() {
        MockitoAnnotations.initMocks(this);
    }

    @Given("^a valid customer ID$")
    public void givenValidCustomerID() {
        customerID = "C1"; // Replace with a valid customer ID
    }

    @When("^I trigger the email sending process$")
    public void whenTriggerEmailSending() throws MessagingException {
        sendEmail = new SendEmail();
        sendEmail.setup();
        emailRecipient = "test@example.com"; // Replace with the desired email recipient
        sendEmail.draft(emailRecipient);
    }

    @Then("^the email should be drafted$")
    public void thenEmailDrafted() throws MessagingException {
        // Mock the sendEmail object and verify that the draft method was called
        doCallRealMethod().when(mockedSendEmail).draft(anyString());
        mockedSendEmail.draft(emailRecipient);
        verify(mockedSendEmail, times(1)).draft(emailRecipient);
    }

    @Then("^the email should not be sent$")
    public void thenEmailNotSent() throws MessagingException {
        // Mock the sendEmail object and verify that the sendemail method was not called
        doCallRealMethod().when(mockedSendEmail).sendemail();
        mockedSendEmail.sendemail();
        verify(mockedSendEmail, never()).sendemail();
    }

    @Then("^an appropriate message should be displayed$")
    public void thenAppropriateMessageDisplayed() throws MessagingException {
        // Mock the sendEmail object
        SendEmail mockedSendEmail = mock(SendEmail.class);

        // Mock the label object
        Label mockedErrorMessageLabel = mock(Label.class);

        // Set up the expected error message
        String expectedErrorMessage = "The email has been sent successfully";

        // Call the method that sets the error message label
        mockedSendEmail.errorMessageLabel = mockedErrorMessageLabel;
        mockedSendEmail.setup();
        mockedSendEmail.draft(anyString());
        mockedSendEmail.sendemail();

        // Verify that the appropriate message is set on the error message label
        verify(mockedErrorMessageLabel).setText(expectedErrorMessage);

        // Get the actual error message from the label
        String actualErrorMessage = mockedErrorMessageLabel.getText();

        // Assert that the actual error message matches the expected error message
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}

