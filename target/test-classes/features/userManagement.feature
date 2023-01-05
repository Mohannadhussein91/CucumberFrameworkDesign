@Regression @userManagement 
Feature: Crater User Management
  user management focuses on user creation, update and delete 
  and also authentication.
  
  Background:
   Given user is on the login page 
  
  @ValidLoginTest @loginTests @smokeTest
  Scenario: User is able to login successfully
    When user enters valid "husseinmohanad@gmail.com" and "Password1234"
    And clicks on the login button
    Then user should be on the dashboard page
    
    
    
    
  @inValidLoginTest @loginTests
  Scenario: Invalid login attempts
    When user enters invalid "hello@john.com" and "password1234"
    And clicks on the login button  
    Then an error message appears
    And user is not logged in
   
    
    @invalidTestSets
    Scenario Outline: Invalid login attempts
    When user enters invalid "<useremail>" and "<password>"
    And clicks on the login button 
    Then an error message appears
    And user is not logged in
    
    Examples: 
    | useremail                   |   password    |    
    | husseinmohanad@gmail.com    |   stagdsjksjd |
    | nothing@gmail.com           |   Testing123  |
    |                             |   Testing123  |
    |	nothing@gmail.com           |               |
    
    
    
    
    
    
