Feature: Add Customer
  Scenario Outline: one or more null value
      Given you are in login page
      When you type in "<id>" ,"<name>", "<phone>", "<address>", "<city>", "<street>" and  "<email>" , "<password>"
      Then I should see Please fill in all information about yourself
      Examples:
        | id | name  | phone   | address | city | street | email         | password |
        | 1  | Ayham | 0598285 | Sofen   |      |        | aaa@gmail.com | 112      |

  Scenario Outline: Enter used id to add new customer
      Given you are in login page
    When you type in "<id>" ,"<name>", "<phone>", "<address>", "<city>", "<street>" and  "<email>" , "<password>"
      Then I should see Enter new id
      Examples:
        | id | name  | phone   | address | city     | street | email         | password |
        | 1  | Ayham | 0598285 | Sofen   | Qalqilya | Sofen  | aaa@gmail.com | 1323     |

      Scenario Outline: fill all values
      Given you are in login page
        When you type in "<id>" ,"<name>", "<phone>", "<address>", "<city>", "<street>" and  "<email>" , "<password>"
      Then I should see the customer added successfully
      Examples:
        | id | name    | phone    | address | city     | street | email         | password |
        | 88 | Ayham   | 0598285  | Sofen   | Qalqilya | 22     | aaa@gmail.com | 123      |
        | 2  | Omar    | 05878787 | Noqqar  | Qalqilya | 22     | aaa@gmail.com | 133      |
        | 3  | Omar    | 05878787 | Noqqar  | Qalqilya | 22     | aaa@gmail.com | 331      |
        | 4  | Ayham   | 0598285  | Sofen   | Qalqilya | 22     | aaa@gmail.com | 342      |
        | 5  | Khaled  | 58585858 | dasd    | ddas     | dd     | aaa@gmail.com | 441      |
        | 6  | Shareef | das      | fds     | ddasd    | das    | aaa@gmail.com | 424      |