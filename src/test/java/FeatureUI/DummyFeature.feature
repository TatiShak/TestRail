Feature: Railinc Web UI Test
  As a user of Railinc website
  I want to verify the various pages on the website
  So that I can ensure the functionality of the website.

  Scenario: Verify Railinc Home Page
    Given I am on the Railinc Home Page
    Then I verify the page logo

  Scenario: Verify Railinc About Us Page
    Given I am on the Railinc Home Page
    When I click on the About Us link
    Then I should be redirected to the About Us page
    And I should see title in the page title
