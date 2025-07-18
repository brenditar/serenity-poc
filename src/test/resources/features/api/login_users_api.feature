Feature: User Login via API

  Scenario Outline: Login with multiple users via API
    Given the API for login is available
    When I login with email "<email>" and password "<password>" via API
    Then the login response code should be <code>
    And the login error message should be "<error>"

    Examples:
      | email                | password   | code | error              |
      | eve.holt@reqres.in   | cityslicka | 200  |                    |
      | eve.holt@reqres.in   |            | 400  | Missing password   |
      | missing@reqres.in    | testpass   | 400  | user not found     | 