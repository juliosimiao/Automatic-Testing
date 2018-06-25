Feature: Testing plus button to add Blood Pressure

  @Measurement_Blood_Pressure
  Scenario: Insert Blood Pressure Measurement after correctly login
    Given Open Chrome AND start application
    And Click on LOGIN button
    When Select region and insert valid username and valid password
    And Click PLUS Button Button
    And Click on MEASUREMENT Button
    And Press BLOOD PRESSURE Button
    And Enter values from the Blood Pressure
    Then Blood Pressure should be saved