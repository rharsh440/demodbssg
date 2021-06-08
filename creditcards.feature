Feature: credit card compare

  Scenario: Compare two credit cards
    Given user launch on dashboard page
    Then user clicks on cards link
    And user clicks on credit cards link
    Then user selects and validates credit cards
      | card1                            | card2               |
      | DBS Altitude Visa Signature Card | DBS Black Visa Card |