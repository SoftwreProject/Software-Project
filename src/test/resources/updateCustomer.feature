#Feature: Update Customer Information
#  Scenario Outline: incorrect id
#    Given you are in login page
#    When you type in field "<id>" ,"<name>", "<phone>", "<address>", "<city>" And "<street>"
#    Then i should show the id is empty or in correct
#    Examples:
#      | id | name  | phone    | address  | city     | street |
#      | 55 | yaser | 05858585 | Qalqilya | Qalqilya | Sofen  |
#
#  Scenario Outline: empty id
#    Given you are in login page
#    When you type in field "<id>" ,"<owner>", "<phone>", "<address>", "<city>" And "<street>"
#    Then i should show the id is empty or in correct
#    Examples:
#      | id | owner  | phone    | address  | city     | street |
#      |    | yaser | 05858585 | Qalqilya | Qalqilya | Sofen  |
#
#  Scenario Outline: accepted id
#    Given you are in login page
#    When you type in field "<id>" ,"<owner>", "<phone>", "<address>", "<city>" And "<street>"
#    Then i should show the user updated successfully
#    Examples:
#      | id | owner | phone | address     | city   | street       |
#      | C1 | Yaser | 0598  | Building 13 | Nablus | Sofen street |