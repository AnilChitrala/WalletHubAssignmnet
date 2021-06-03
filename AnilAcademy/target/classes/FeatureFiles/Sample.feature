Feature: Just Checking sample project

  Scenario: Logging into google Website
    Given User logged into Sample Website
    When user logged in with Username and password
    Then Verify user is on Sample website

#  Scenario Outline: Logging into google Website
#    Given User logged into Sample Website
#    When user logged in with "<Username>" and "<password>"
#    Then Verify user is on Sample website
#    Examples:
#      | Username | password |
#

