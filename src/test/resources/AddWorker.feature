
@AddWorkerFeature
Feature: Add new Worker
  Scenario Outline I entered Incorrect values
    Given Im in the Add Worker Page
    When  I fill in "WorkerID" with "<ID>"
    And  I fill in "WorkerName" with "<name>"
    And   I fill in "WorkerPhone" with "<phone>"
    And   I fill in "WorkerAddress" with "<address>"
    And   I fill in "WorkerSpecialization" with "<specialization>"
    And   I press "SignUp"
    Then  I should <action>
    Examples:
    | ID  |     name    |     phone     |          address       |specialization |              action                     |
    |     |   Shareef   |    059999999  |                        |               |   see   "Please fill All information"     |
    | 456 |             |               |         Nablus         |               |   see "Please fill All information"     |


  Scenario Outline I entered Correct values
    Given Im in the Add Worker Page
    When  I fill in "WorkerID" with "<ID>"
    And  I fill in "WorkerName" with "<name>"
    And   I fill in "WorkerPhone" with "<phone>"
    And   I fill in "WorkerAddress" with "<address>"
    And   I fill in "WorkerSpecialization" with "<specialization>"
    And   I press "SignUp"
    Then  I should <action>
    Examples:
     | ID  |     name    |     phone     |          address       |  specialization  |                     action                         |
     | 123 |   Shareef   |    059999999  |         Qalqlia        |        ss        |   see "The Worker has been Added Successfully"     |
     | 456 |   Sara      |    059784984  |         Nablus         |        ss        |   see "The Worker has been Added Successfully"     |

