#Feature: Show the Information of Customer
#  Scenario Outline: Enter an Empty id
#    Given you are in customer page
#    When you enter the "<id>"
#    Then you must show Empty ID
#    Examples:
#      | id |
#      |    |
#
#    Scenario Outline: Enter an wrong id
#      Given you are in customer page
#      When you enter the "<id>"
#      Then you must show Wrong ID
#      Examples:
#        | id  |
#        | C99 |
#
#  Scenario Outline: Enter a correct ID
#    Given you are in customer page
#    When you enter the "<id>"
#    Then you must show the information of customer
#    Examples:
#      | id   |
#      | C111 |
#
