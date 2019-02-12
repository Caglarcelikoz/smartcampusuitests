@Companies

Feature: Companies SearchBox
  This feature verifies that the given companies name returns the correct data in the Companies table

  Scenario Outline: Check that given building name in SearchBox returns the correct data in companies table
    Given I launch Chrome browser
    When I Open localhost
    Then I look for the CompaniesButton
    Then I Click The CompaniesButton
    Then I verify there is a CompaniesHeader
    Then I check that the CompaniesHeader has the correct text
    Then I verify there is a companiesSearchBox
    Then I give in companyName <companyName>
    Then I verify given companyName <companyName> is in table
    Then add to testrun <testRun> <testCase>
    Then I close the browser window

  Examples:
  |companyName|testCase|testRun|
  |XTi        |4007    |193    |
  |XTi        |4007    |203    |
 # |ida mediafoundry        |4007    |203    |
