@Employees

Feature: Menu Buttons
  This feature verifies that the Menu Buttons directs the user to the Correct Page

  Scenario Outline: Check the Employees Button directs the user to the EmployeesPage
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the EmployeesButton
    Then I Click The EmployeesButton
    Then I verify there is a employeesHeader
    Then I check that the employeesHeader has the correct text
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |testCase|testRun|
      |3641    |193    |
      |3641    |203    |
      |3641    |382    |

  Scenario Outline: Check that  the Companies Button directs the user to the CompaniesPage
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
      |3642    |382    |

  Scenario Outline: Check that  the Buildings Button directs the user to the BuildingsPage
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the BuildingButton
    Then I Click The BuildingsButton
    Then I verify there is a buildingsHeader
    Then I check that the buildingsHeader has the correct text
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

  Examples:
  |testCase|testRun|
  |3640    |193    |
  |3640    |382    |

