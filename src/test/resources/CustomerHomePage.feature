Feature: Customer Home Page
  Scenario Outline: Empty ID
    Given you are in customer page
    When you enter the customer "<id>"
    Then you should show Empty ID
    Examples:
      | id |
      |    |
  Scenario Outline: Empty ID
    Given you are in customer page
    When you enter the customer "<id>"
    Then you should show the name
    Examples:
      | id |
      | C1 |

    Scenario: Given the Date
      Given you are in customer page
      Then you will have the Date of Today

      Scenario Outline: Show All function
        Given you are in customer page
        When You enter the "<id>"
        Then You will show Done Word
        Examples:
          | id |
          | C1 |