Feature: Sending email
  Scenario: send an email
    Given The order is finished
    When The time of order is finished
    Then The email should be sending to the user successfully


