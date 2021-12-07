Feature: This feature file is used for WalletHub Assignments

  @Assignment1
  Scenario Outline: user Logged into Facebook and Post a Status in Timeline
    Given User logged into Facebook by providing valid Credentials
    When user logged in with "<Username>" and "<password>"
    Then Verify user is on Facebook Login Page
    And Post a Status "<Message>" and Verify message is posted in Timeline
    And Close browser
    Examples:
      | Username      | password      | Message     |
      | Test userName | Test Password | Hello World |

  @Assignment2
  Scenario Outline: user logged into WalletHub WebPage and Post a Review and Verify
    Given user logged into WalletHub Review page
    When user provides Rating by using "<Number>"
    Then user Selects "<dropdown Value>" and write "<ReviewText>" in Review text field
    When user logged into WalletHub Review page by Providing "<EmailID>" and "<password>"
    And Verify Same "<ReviewText>" is Posted in WalletHub Review page
    And Close browser
    Examples:
      | EmailID    | password      | Number | dropdown Value   | ReviewText                                                                                                                                                                                                           |
      | Test Email | Test Password | 4      | Health Insurance | Your health insurance policy provides you with financial assistance at the time of a medical emergency. Health risks and uncertainties are part of life. Hence, it is important you opt for a health insurance plan. |
