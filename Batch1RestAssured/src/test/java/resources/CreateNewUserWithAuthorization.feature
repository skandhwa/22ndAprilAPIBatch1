@smoke
Feature: Create New User with Dynamic payload usingpost method

  Scenario Outline: To create a user with correct credentials
    Given User logins into the application with corresponding baseUri
    And User will pass the payload with authentication token
    When User will submit the post request with the  "<endpoint>"
    Then validate the status code with  new status code as "<status_code>"
    Then User will validate the responsebody

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
