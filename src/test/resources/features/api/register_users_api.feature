Feature: User Registration via API

  Scenario: Successful user registration via API
    Given the API for registration is available
    When I register a user with email "eve.holt@reqres.in" and password "pistol" via API
    Then the registration response code should be 200

  Scenario: Registration fails with missing password
    Given the API for registration is available
    When I register a user with email "sydney@fife" and no password via API
    Then the registration response code should be 400
    And the registration error message should be "Missing password" 