Feature: Testing plus button to add Morning Measurement

  @Measurement_Morning
  Scenario: Insert Morning Measurement after correctly login
    Given Open Chrome and start application
    And Click on login button
    When Select region and enter valid username and valid password
    And Press the PLUS Button Button
    And Press MEASUREMENT Button
    And Press Morning Measurement Button
    And Enter values from the Morning Measurement
    Then Morning Measurement should be saved