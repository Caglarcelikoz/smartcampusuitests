@General
Feature: restartButton click
  This feature verifies that clicking the restart button restarts the conversation between the CUI and user

  Scenario: Check that the restartbutton are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the restart button
    Then I Click The restart button
    Then I Verify That The CUI Shows A Welcome Message
    Then I close the browser window