@CUI
Feature: Testing the buttons of the CUI
  This feature verifies that the CUI buttons work correctly

  Scenario Outline: Check that the CUI shows a message with the text "buildings" when clicking the buildings button
    Given I launch Chrome browser
    When I Open localhost
    Then I Verify That The CUI Shows A Welcome Message
    Then I Verify That There Is A Buildings Button In The CUI
    Then I Click On The Buildings Button In The CUI
    Then I Verify That There The CUI Shows A Message With The Text buildings
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |testCase|testRun|
      |4563    |382    |
