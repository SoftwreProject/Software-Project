Feature: Show Product Information
  Scenario Outline: Enter an Empty id
    Given you are in Product page
    When you enter the product "<id>"
    Then you must show Empty Product ID
    Examples:
      | id |
      |    |

  Scenario Outline: Enter an wrong id
    Given you are in Product page
    When you enter the product "<id>"
    Then you must show Wrong Product ID
    Examples:
      | id    |
      | P1212 |

  Scenario Outline: Enter a correct ID
    Given you are in Product page
    When you enter the product "<id>"
    Then you must show the information of product
    Examples:
      | id   |
      | P111 |