Feature: Send Email
  Scenario: Send email to the customer
    Given a valid customer ID
    When I trigger the email sending process
    Then the email should be drafted
#    And the email should not be sent
#    And an appropriate message should be displayed
