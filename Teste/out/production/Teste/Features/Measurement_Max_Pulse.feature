Feature: Testing plus button to add Max Pulse

  @Measurement_Max_Pulse
  Scenario: Insert Max Pulse Measurement after correctly login
    Given Open Chrome browser and start application
    And Click on Login button
    When Select Region and enter valid username and valid password
    And Press the Plus Button Button
    And Press Measurement Button
    And Press Max Pulse Button
    And Enter values from the Max Pulse
    Then Max Pulse should be saved