Feature: Update Product Information
  Scenario Outline: incorrect id
    Given you are in login page
    When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show the id is empty or incorrect
    Examples:
      | id | name | category | high | width |  |
      | 55 | C1   | rug      | 12   | 25    |  |

  Scenario Outline:
    Given you are in login page
    When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show the id is empty or incorrect
    Examples:
      | id | name | category | high | width |  |
      |    | C1    | rug      | 12   | 25    |  |

  Scenario Outline:
    Given you are in login page
    When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show the product updated successfully
    Examples:
      | id | name | category | high | width |  |
      | 1  | C1    | rug      | 12   | 25    |  |