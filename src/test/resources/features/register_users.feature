# language: en
Feature: User Registration

  Scenario: Successful user registration
    Given Brenda is a client who wants to manage her banking products
    When she sends the required information for registration
    Then she should get a virtual account to log in whenever she needs
