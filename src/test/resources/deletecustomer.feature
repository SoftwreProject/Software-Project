Feature:Delete Customer

  Scenario Outline: i want to delete customer with empty id and name
    Given you are in login page
    When you type in "<id>" or "<name>"
    Then please fill correct information
    Examples:
      | id | name |
      |    |      |

  Scenario Outline: i want to delete customer with invalid name and id
    Given you are in login page
    When you type in "<id>" or "<name>"
    Then please fill correct information
    Examples:
      | id | name  |
      | 85 | Hanan |

  Scenario Outline: i want to delete customer with invalid name or id and empty name or id
    Given you are in login page
    When you type in "<id>" or "<name>"
    Then please fill correct information
    Examples:
      | id | name |
      | 52 |      |
      |    | Adam |

  Scenario Outline: i want to delete customer with valid id or valid name
    Given you are in login page
    When you type in "<id>" or "<name>"
    Then i should show Customer Deleted Successfully
    Examples:
      | id | name |
      | 11 | tp   |
      | 2  | ry   |
      | 9  | wq   |
      | 4  | gg   |
      | 6  | g    |
      | 12 | f    |
      | 10 | r    |
      | 3  | te   |
      | 88 | d    |
      | 7  | c    |
      | 5  | b    |
      | 13 | a    |