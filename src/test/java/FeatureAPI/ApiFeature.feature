Feature: Verify Railinc login API
  As a user of the Railinc login API,
  I want to verify that the API is working correctly,
  So that I try to log in to the Railinc website.

  Scenario: Verify login endpoint
    Given the login endpoint is available
    When I make a POST request to the login endpoint with invalid credentials
    Then the response status code should be 405