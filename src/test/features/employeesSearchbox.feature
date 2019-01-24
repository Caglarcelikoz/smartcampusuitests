@Employees

Feature: Employees SearchBox
  This feature verifies that the given employee firstname returns the correct data in the employee table

  Scenario Outline: Check that given firstname in SearchBox returns the correct data in employee table
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the EmployeesButton
    Then I Click The EmployeesButton
    Then I verify there is a employeesHeader
    Then I check that the employeesHeader has the correct text
    Then I verify there is a employeesSearchBox
    Then I give in firstname:Jaakie
    Then I verify given firstname:Jaakie is in table
    Then add to testrun <testCase>
    Then I close the browser window

    Examples:
    |testCase|
    |7168    |