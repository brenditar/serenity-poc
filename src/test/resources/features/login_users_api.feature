Feature: User Login via API

  Scenario Outline: Login with multiple users via API
    Given the API is available
    When I login with email "<email>" and password "<password>"
    Then the response code should be <code>
    And the error message should be "<error>"

    Examples:
      | email                | password   | code | error              |
      | eve.holt@reqres.in   | cityslicka | 200  |                    |
      | eve.holt@reqres.in   |            | 400  | Missing password   |
      | missing@reqres.in    | testpass   | 400  | user not found     | 