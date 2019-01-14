Feature: Google Homepage
  This feature verifies the functionality on Google Homepage

  Scenario: Check that main elements on Google Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the BuildingButton
    Then I Click The BuildingsButton
    Then I verify there is a buildingsHeader
    Then I check that the buildingsHeader has the correct text