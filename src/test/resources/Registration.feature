Feature: Registration

  Scenario: Successful registration
    Given Given Navigate to registration page
    When Enter valid data for registration
    And Enter date of birth
    Then Click on the Submit button