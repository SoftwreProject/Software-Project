Feature: Show the Status of Product
  Scenario Outline : You Enter Empty ID
    Given You are in Product page
    When you enter an "<ID>"
    Then you must show EmptyID
    Examples:
      | ID |
      |    |
  Scenario Outline : You Enter wrong ID
    Given You are in Product page
    When you enter an "<ID>"
    Then wrong ID
    Examples:
      | ID   |
      | P878 |
  Scenario Outline : You Enter correct ID
    Given You are in Product page
    When you enter an "<ID>"
    Then Get correctly
    Examples:
      | ID |
      | P5  |
