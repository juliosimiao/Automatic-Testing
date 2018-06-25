Feature: Testing plus button to add new Activity

  @Add_Activity
  Scenario: Insert activity when user is already in the home page
    Given Open Chrome with user already in the home page
    When Click on plus button in the right side
    And Insert values from the activity
    Then Activity should be saved