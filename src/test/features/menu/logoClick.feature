@General
Feature: logo click
  This feature verifies that clicking the logo directs the user to the Home page

  Scenario Outline: Check that Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the Smart Campus logo
    Then I Click The Smart Campus logo
    Then I verify that I'm redirected to the home page
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |testCase|testRun|
      |3691    |193    |
      |3691    |203    |
      |3691    |382    |