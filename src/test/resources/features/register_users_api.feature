Feature: User Registration via API

  Scenario: Successful user registration via API
    Given the API is available
    When I register a user with email "eve.holt@reqres.in" and password "pistol"
    Then the response code should be 200

  Scenario: Registration fails with missing password
    Given the API is available
    When I register a user with email "sydney@fife" and no password
    Then the response code should be 400
    And the error message should be "Missing password" 