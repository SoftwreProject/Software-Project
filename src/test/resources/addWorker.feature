Feature: Add Worker
  Scenario Outline: Empty one Or more Value
    Given you are in worker page
    When you enter "<id>" , "<name>" , "<phone>", "<address>" and "<specialization>"
    Then you should show please fill all informations about the worker
    Examples:
      | id | name | phone | address | specialization |
      | 15 |      | 11    | Nablus  |                |

  Scenario Outline: full informations
    Given you are in worker page
    When you enter "<id>" , "<name>" , "<phone>", "<address>" and "<specialization>"
    Then you should show the worker added successfully
    Examples:
      | id | name  | phone | address | specialization |
      | W5 | Ahmad | 11    | Hebron  | Carpet         |
  Scenario Outline: full informations
    Given you are in worker page
    When you enter "<id>" , "<name>" , "<phone>", "<address>" and "<specialization>"
    Then you should show use another id
    Examples:
      | id | name  | phone | address | specialization |
      | W5 | Ahmad | 11    | Hebron  | Carpet         |