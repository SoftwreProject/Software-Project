Feature: Add Product
  Scenario Outline: one or more empty value
    Given you are in login page
    When When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then i should show please fill all information
    Examples:
      | id | name    | category | high | width |
      | 1  | T-Shirt |          | 0    | 0     |

  Scenario Outline: Enter used id
    Given you are in login page
    When When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then I should see please enter new id
    Examples:
      | id | name    | category | high | width |
      | 1  | T-Shirt | Rug      | 0    | 0     |
  Scenario Outline: fill all values
    Given you are in login page
    When When you type in "<id>" ,"<name>", "<category>", "<high>", "<width>"
    Then I should see the product added successfully
    Examples:
      | id | name    | category | high | width |
      | 88 | Ayham   | rug      | 4    | 4     |
      | 2  | Omar    | T-Shirt  | 0    | 0     |
      | 3  | Osama   | Shoes    | 0    | 0     |
      | 4  | Khaled  | shirt    | 0    | 0     |
      | 5  | Shareef | pants    | 0    | 0     |