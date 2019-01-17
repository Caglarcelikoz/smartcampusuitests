@EmployeesButton

Feature: Employees Button
  This feature verifies that the Employees Button directs the user to the EmployeesPage

  Scenario: Check that main elements on Google Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the EmployeesButton
    Then I Click The EmployeesButton
    Then I verify there is a employeesHeader
    Then I check that the employeesHeader has the correct text