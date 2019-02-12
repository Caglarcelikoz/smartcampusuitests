@Companies

Feature: Companies Button
  This feature verifies that the Companies Button directs the user to the CompaniesPage

  Scenario Outline: Check that main elements on Google Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the CompaniesButton
    Then I Click The CompaniesButton
    Then I verify there is a CompaniesHeader
    Then I check that the CompaniesHeader has the correct text
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

  Examples:
  |testCase|testRun|
  |3642    |193    |
  |3642    |203    |