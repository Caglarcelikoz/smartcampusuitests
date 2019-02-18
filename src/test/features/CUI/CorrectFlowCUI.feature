@CUI
Feature: The CUI returns the correct result when giving an existing building, company or employee
  This feature verifies that the CUI returns the correct building, company or employee

  Scenario Outline: Check that the CUI returns the correct building
    Given I launch Chrome browser
    When I Open localhost
    Then I Verify That The CUI Shows A Welcome Message
    Then I Verify That There Is A Buildings Button In The CUI
    Then I Verify That There Is A Companies Button In The CUI
    Then I Verify That There Is A Employees Button In The CUI
    When I Click On The Buildings Button In The CUI
    Then I Verify That There The CUI Shows A Message With The Text buildings
    Then I Verify That The CUI Asks Which Building The User Is Looking For
    When I give in BuildingName <buildingName> On The InputField
    And I Click On The Send Button
    Then I Verify That The CUI Shows The Correct Messages When The Given Building Name Exists
    When I Click On No Button In Buildings Flow
    Then I Verify That The CUI Shows A Correct Final Message In The Buildings Flow
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |testCase|testRun|buildingName|
      |4564    |382    |corda1     |

  Scenario Outline: Check that the CUI returns the correct employee
    Given I launch Chrome browser
    When I Open localhost
    Then I Verify That The CUI Shows A Welcome Message
    Then I Verify That There Is A Buildings Button In The CUI
    Then I Verify That There Is A Companies Button In The CUI
    Then I Verify That There Is A Employees Button In The CUI
    When I Click On The Employees Button In The CUI
    Then I Verify That There The CUI Shows A Message With The Text employees
    Then I Verify That The CUI Asks Which Employee The User Is Looking For
    When I give in EmployeeName <employeeName> On The InputField
    And I Click On The Send Button
    Then I Verify That The CUI Shows The Correct Messages When The Given Employee Name Exists
    When I Click On No Button In Employee Flow
    Then I Verify That The CUI Shows A Correct Final Message In The Employee Flow
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |testCase|testRun|employeeName|
      |4757    |382    |Caglar Celikoz     |
