@sanity
Feature: Create New User with Dynamic payload usingpost method

  Scenario Outline: To create a user with correct credentials
    Given User hits into the application url
    And User will pass the payload
    When User will submit the post request with "<endpoint>"
    Then validate the status code with "<status_code>"

    Examples: 
      | endpoint | status_code |
      | post     |         200 |