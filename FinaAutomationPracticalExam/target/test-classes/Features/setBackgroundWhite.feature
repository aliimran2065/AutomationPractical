@TestWhite
Feature: Change Background Color

  Scenario: White Background Change
    Given the "Set White Background" button exists
    When I click on the White button
    Then the background color will change to white
