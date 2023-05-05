#Feature: Login in my program
#  @scenario1
#  Scenario Outline: Wrong password or password
#    Given you are in login page
#    When I type in email "<username>" And I type in password "<password>"
#    Then I should see E-mail or password is incorrect
#    Examples:
#      | username | password |
#      | C1       | 112233   |
#
#  @scenario2
#  Scenario Outline: Login successfully
#    Given you are in login page
#    When I type in email "<username>" And I type in password "<password>"
#    Then I should see Access your account
#   Examples:
#     | username | password |
#     | C1       | 123456   |
#
#  @scenario3
#  Scenario Outline: Login successfully
#    Given you are in login page
#    When I type in email "<username>" And I type in password "<password>"
#    Then Empty password or username
#    Examples:
#      | username | password |
#      |          | 777      |
