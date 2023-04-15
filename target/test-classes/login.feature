#Feature: Login
#  Scenario: i have wrong password or username
#    Given you in main page
#    When you enter a username and password
#    Then you must show a message Failed
#
#    Scenario: i have a correct password and username
#      Given you in main page
#      When you enter a username and password
#      Then you must show a message correct



#  Background:
#    Given I go to '/login'
#    And the field 'email' is empty
#    And the field 'password' is empty

#  Scenario: Error on empty fields
#    When I click on 'enter'
#    Then field 'email' should be with error
#    And field 'password' should be with error
Feature: Login in my program
  @scenario1
  Scenario Outline: Wrong password or password
    Given you are in login page
    When I type in email "<email>" And I type in password "<password>"
    Then I should see E-mail or password is incorrect
    Examples:
      | email          | password |
      | abcd@gmail.com | 112233   |

@scenario2
  Scenario Outline: Login successfully
    Given you are in login page
    When I type in email "<email>" And I type in password "<password>"
    Then I should see Access your account
   Examples:
     | email                | password |
     | ayham.1222@gmail.com | 012345   |