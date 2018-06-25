Feature: Testing plus button to add Weight Measurement

  @Measurement_Weight
    Scenario: Insert Weight Measurement after correctly login
      Given OPEN Chrome and start application
      And Click On Login Button
      When Choose region and enter valid username and valid password
      And Press The PLUS Button
      And Click on MEASUREMENT BUTTON
      And Press WEIGHT Button
      And Enter values from the Weight
      Then Weight should be saved