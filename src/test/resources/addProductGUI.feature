Feature: Add Product GUI
  Scenario Outline: one or more empty value in Text Fields
    Given you are in login page
    When When you type "<id>" ,"<owner>", "<category>", "<high>", "<width>"
    Then i should show please fill all information about the product
    Examples:
      | id | owner | category | high | width |  |
      | P6 |       | T-Shirt  |      | 0     |  |

  Scenario Outline: Enter Cover
    Given you are in login page
    When When you type "<id>" ,"<owner>", "<category>", "<high>", "<width>"
    Then I should see Cover Product added Successfully
    Examples:
      | id  | owner | category | high | width |  |
      | P17 | C1    | Cover    | 0    | 0     |  |

  Scenario Outline: Enter Carpet
    Given you are in login page
    When When you type "<id>" ,"<owner>", "<category>", "<high>", "<width>"
    Then I should see Carpet Product added Successfully
    Examples:
      | id  | owner | category | high | width |  |
      | P18 | C1    | Carpet   | 0    | 0     |  |

#  Scenario Outline: fill all values
#    Given you are in login page
#    When When you type "<id>" ,"<owner>", "<category>", "<high>", "<width>"
#    Then I should see the product added successfully
#    Examples:
#      | id  | owner | category | high | width |  |
#      | P12 | C1    | Carpet   | 4    | 4     |  |
#      | P13 | C1    | Cover    | 0    | 0     |  |
#      | P14 | C1    | Carpet   | 9    | 18    |  |
#      | P15 | C1    | Cover    | 0    | 0     |  |
#      | P16 | C1    | Carpet   | 4    | 7     |  |