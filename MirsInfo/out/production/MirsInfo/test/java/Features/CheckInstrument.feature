Feature: Testing the results after search
  @mirsInfo
  Scenario: Get the input values from a xls file and search for the results
    Given Open Chrome Browser and start application
    And Enter input values
    Then Get the results and store