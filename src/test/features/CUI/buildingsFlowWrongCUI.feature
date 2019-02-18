@CUI
Feature: The CUI returns the correct building
  This feature verifies that the CUI returns the correct building

  Scenario Outline: Check that the CUI returns the correct building
    Given I launch Chrome browser
    When I Open localhost
    Then I Verify That The CUI Shows A Welcome Message
    Then I Verify That There Is A Buildings Button In The CUI
    Then I Verify That There Is A Companies Button In The CUI
    Then I Verify That There Is A Employees Button In The CUI
    When I Click On The Buildings Button In The CUI
    Then I Verify That There The CUI Shows A Message With The Text:buildings
    And I Verify That The CUI Asks Which Building The User Is Looking For
    When I give in BuildingName <companyName> On The InputField
    And I Click On The Send Button
    Then I Verify That The CUI Shows The Correct Messages When The Given Building Name Not Exists
    When I Click On The Buildings Button To Check The Table With All Buildings
    Then I Verify That The Buildings Page Is Opened
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |testCase|testRun|companyName|
      |4749    |382    |Test       |
