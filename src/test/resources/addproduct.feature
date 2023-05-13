#Feature: Add Product
#  Scenario Outline: one or more empty value
#    Given you are in login page
#    When When you type in "<id>" ,"<owner>", "<category>", "<high>", "<width>"
#    Then i should show please fill all information
#    Examples:
#      | id | owner | category | high | width |  |
#      | P6 |       | T-Shirt  |      | 0     |  |
#
#  Scenario Outline: Enter used id
#    Given you are in login page
#    When When you type in "<id>" ,"<owner>", "<category>", "<high>", "<width>"
#    Then I should see please enter new id
#    Examples:
#      | id | owner | category | high | width |  |
#      | P1 | 12    | Rug      | 0    | 0     |  |
#
#  Scenario Outline: fill all values
#    Given you are in login page
#    When When you type in "<id>" ,"<owner>", "<category>", "<high>", "<width>"
#    Then I should see the product added successfully
#    Examples:
#      | id  | owner | category | high | width |  |
#      | P12 | C1    | Carpet   | 4    | 4     |  |
#      | P13 | C1    | Cover    | 0    | 0     |  |
#      | P14 | C1    | Carpet   | 9    | 18    |  |
#      | P15 | C1    | Cover    | 0    | 0     |  |
#      | P16 | C1    | Carpet   | 4    | 7     |  |