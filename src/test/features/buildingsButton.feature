@Building
Feature: Building Button
  This feature verifies that the Building Button directs the user to the BuildingsPage

  Scenario: Check that main elements on Google Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the BuildingButton
    Then I Click The BuildingsButton
    Then I verify there is a buildingsHeader
    Then I check that the buildingsHeader has the correct text
    Then save to testrail
    Then I close the browser window

