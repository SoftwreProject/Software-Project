Feature: Add All Feature
  Scenario Outline: Empty ID
    Given you are in add all page
    When you write the "<id>"
    Then You will get Empty id
    Examples:
      | id |
      |    |
    Scenario Outline: Incorrect id
      Given you are in add all page
      When you write the "<id>"
      Then You will get Wrong ID
      Examples:
        | id  |
        | 989 |
  Scenario Outline: Incorrect id
      Given you are in add all page
      When you write the "<id>"
      Then You will get the result
    Examples:
      | id |
      | P1 |



