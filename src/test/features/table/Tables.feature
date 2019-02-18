@Tables

Feature: A Table returns the correct data in the table when the page id opened
  This feature verifies that the employees, buildings and companies tables return the correct data in the table when the page id opened

  Scenario Outline: check that the companies table is correctly loaded with the correct rows and data
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the CompaniesButton
    Then I Click The CompaniesButton
    Then I verify that the correct column titles are visible in the table
    Then I verify that the table contains given companyName <companyName> and the corresponding building details <building>
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |companyName|building|testCase|testRun|
      |XTi        |Corda2, Floor: 4|3641    |193    |
      |ida mediafoundry|Corda1, Floor: 4|3641    |203|
      |Xplore Group|Corda3, Floor: 4|3641    |203|
 # |ida mediafoundry    |4007   |203    |
