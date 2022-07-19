Feature: MyAccount-Login Feature
  Description: This feature will test a Login feature

  #Simple login without parameters
  Scenario: Log-in with valid username and password
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on My Account Menu
    And Enter registered username and password
    And Click on login button
    Then User must successfully login to the web page

  #Simple login with Data table params with header
  Scenario: Log-in with valid username and password with Data table
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on My Account Menu
    And Enter registered username and password
      | user            | password         |
      | pavanoltraining | Test@selenium123 |
    And Click on login button
    Then User must successfully login to the web page