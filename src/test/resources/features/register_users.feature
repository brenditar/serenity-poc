# language: en
Feature: User Registration

  Scenario: Successful user registration
    Given there are no users registered
    When I register a user with name "Brenda" and email "brenda@email.com"
    Then the user with email "brenda@email.com" should exist

  Scenario: Registration fails for duplicate email
    Given a user with email "brenda@email.com" is already registered
    When I register a user with name "Brenda2" and email "brenda@email.com"
    Then the registration should fail

  Scenario Outline: Registration with various data
    Given there are no users registered
    When I register a user with name "<name>" and email "<email>"
    Then the user with email "<email>" should exist

    Examples:
      | name   | email              |
      | Alice  | alice@email.com    |
      | Bob    | bob@email.com      |
