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

  Scenario: Check that main elements on Google Homepage are displayed
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the BuildingButton
    Then I Click The BuildingsButton
    Then I verify there is a buildingsHeader
    Then I check that the buildingsHeader has the correct text
    Then save to testrail
    Then I close the browser window

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  Examples:
  |testCase|testRun|
  |3640    |193    |
<<<<<<< HEAD
  |3640    |382    |
=======
  |3640    |203    |
>>>>>>> 64c689cb46d46efa3ae9a10224d1cec61a419b4d

=======
>>>>>>> parent of 64c689c... 'tests'
=======
>>>>>>> parent of 64c689c... 'tests'
=======
>>>>>>> parent of 64c689c... 'tests'
=======
>>>>>>> parent of 64c689c... 'tests'
