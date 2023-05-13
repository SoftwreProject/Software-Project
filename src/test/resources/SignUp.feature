#Feature: SignUp
#  Scenario Outline: One or More Empty Term
#    Given you are in signup page
#    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>" and "<password>"
#    Then you should show please fill all informations
#    Examples:
#      | id   | name | PhoneNumber | address | city     | street | email | password |
#      | C171 |      | 878         |         | Qalqilya | Sofen  |       | 123456   |
#  Scenario Outline: duplicate id
#    Given you are in signup page
#    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>" and "<password>"
#    Then You should Show please enter another id
#    Examples:
#      | id  | name  | PhoneNumber | address     | city     | street | email                | password |
#      | C111 | Ayham | 0598595587  | building 22 | Qalqilya | Sofen  | ayham.1399@gmail.com | 123456   |
#
#  Scenario Outline: weak password
#    Given you are in signup page
#    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>" and "<password>"
#    Then You should Show please enter more than five character
#    Examples:
#      | id  | name  | PhoneNumber | address     | city     | street | email                | password |
#      | 101 | Ayham | 0598595587  | building 22 | Qalqilya | Sofen  | ayham.1399@gmail.com | 123      |
#
#  Scenario Outline: Added Successfully
#    Given you are in signup page
#    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>" and "<password>"
#    Then The Customer Added Successfully
#    Examples:
#      | id   | name  | PhoneNumber | address     | city     | street | email                | password |
#      | C101 | Ayham | 0598595587  | building 22 | Qalqilya | Sofen  | ayham.1399@gmail.com | 123456   |
#
#
