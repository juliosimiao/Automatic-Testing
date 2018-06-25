Feature: Testing if description of exercise on web page is the same that on the file
  @listOfExercises
  Scenario: Check if description of exercise matches if xls file after user correctly sign in
    Given Open Chrome Browser and start application
    And Enter user and password
    When Insert the name of the exercice in the search field
    And Check if the exercise exists and verify if the description of the exercise matches with the file

