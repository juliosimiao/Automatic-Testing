Feature: Testing plus button to add Blood Sugar

  @Measurement_Blood_Sugar
  Scenario: Insert Blood sugar Measurement after correctly login
    Given Open CHROME and start application
    And Click on login Button
    When Select region and Enter valid username and valid password
    And Press the PLUS BUTTON
    And Press MEASUREMENT BUTTON
    And Press BLOOD SUGAR Button
    And Enter values from the Blood Sugar
    Then Blood Sugar should be saved