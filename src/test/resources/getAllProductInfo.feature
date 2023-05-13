Feature: Get all product informations
  Scenario Outline: your enter the information of product
    Given you are in Product page
    When you enter "<id>" , "<category>" , "<high>", "<width>" , "<date>" , "<status>" , "<total price>"
    Then You enter all info
    Examples:
      | id  | category | high | width | date      | status  | total price |
      | P44 | Carpet   | 14   | 4     | 17/7/2023 | Waiting | 150         |

    Scenario: You get the information that you enter it
      Given you are in Product page
      Then get all infos