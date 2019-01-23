@General
Feature: CUI shows a welcome message when opening the web app
  This feature verifies that the CUI shows a welcome message when opening the web app

  Scenario: Check that the CUI shows a welcome message
    Given I launch Chrome browser
    When I Open localhost
    Then I Verify That The CUI Shows A Welcome Message
    Then I close the browser window