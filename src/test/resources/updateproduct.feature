Feature: Update Product Information
  Scenario Outline: incorrect id
    Given you are in login page
    When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show the id is empty or incorrect
    Examples:
      | id | name  | category | high | width |  |
      | 55 | yaser | rug      | 12   | 25    |  |

  Scenario Outline:
    Given you are in login page
    When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show the id is empty or incorrect
    Examples:
      | id | name  | category | high | width |  |
      |    | yaser | rug      | 12   | 25    |  |

  Scenario Outline:
    Given you are in login page
    When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show the product updated successfully
    Examples:
      | id | name  | category | high | width |  |
      | 1  | yaser | rug      | 12   | 25    |  |