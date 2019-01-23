@General
Feature: logo click
  This feature verifies that clicking the logo directs the user to the Home page

  Scenario: Check that Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the Smart Campus logo
    Then I Click The Smart Campus logo
    Then I verify that I'm redirected to the home page
    Then I close the browser window