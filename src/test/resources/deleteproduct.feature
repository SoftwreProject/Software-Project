Feature: Delete Product
  Scenario Outline: i want to delete customer with empty id and name
    Given you are in login page
    When you type in  "<id>" or "<name>"
    Then please fill valid information
    Examples:
      | id | name |
      |    |      |

  Scenario Outline: i want to delete customer with invalid name and id
    Given you are in login page
    When you type in  "<id>" or "<name>"
    Then please fill valid information
    Examples:
      | id | name  |
      | 85 | Hanan |

  Scenario Outline: i want to delete customer with invalid name or id and empty name or id
    Given you are in login page
    When you type in  "<id>" or "<name>"
    Then please fill valid information
    Examples:
      | id | name  |
      | 52 |       |
      |    | Ahmad |

  Scenario Outline: i want to delete customer with valid id or valid name
    Given you are in login page
    When you type in  "<id>" or "<name>"
    Then i should show product Deleted Successfully
    Examples:
      | id  | name    |
      | P12 | Ayham   |
      | P13 | Omar    |
      | P14 |         |
      | P15 | Shareef |
      | P16   | Khaled  |