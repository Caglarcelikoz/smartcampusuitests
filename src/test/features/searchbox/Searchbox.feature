@Companies

Feature: Searchbox returns the correct data in the tables when the given name is present in the tables
  This feature verifies that the given name returns the correct data in the tables

  Scenario Outline: Check that given building name in SearchBox returns the correct data in companies table
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the CompaniesButton
    Then I Click The CompaniesButton
    Then I verify there is a CompaniesHeader
    Then I check that the CompaniesHeader has the correct text
    When I verify there is a companiesSearchBox
    Then I give in companyName <companyName>
    When I verify given companyName <companyName> is in table
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

    Examples:
      |companyName|testCase|testRun|
      |XTi        |4007    |193    |
      |XTi        |4007    |203    |
 # |ida mediafoundry    |4007   |203    |
