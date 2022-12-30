Feature: Crater User Management
  user management focuses on user creation, update and delete 
  and also authentication.

  Scenario: User is able to login successfully
    Given user is on the login page
    When user enters valid username and password
    And clicks on the login button
    Then user should be on the dashboard page
