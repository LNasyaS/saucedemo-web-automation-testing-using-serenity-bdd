@Login
Feature: Login
  As user i want to login to the web Saucedemo.com

  @TC1
  Scenario: Standard login with valid credentials
    Given user open the web page
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then  User is already on the landing page

  @TC2
  Scenario Outline: User login with invalid credentials
    Given user open the web page
    When User input "<userName>" as userName and "<password>" as password and click login
    Then User see error "<errorMessage>" on login page
    Examples:
      | userName      | password     | errorMessage                                                              |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      | nasya         | abc123       | Epic sadface: Username and password do not match any user in this service |
      |               |              | Epic sadface: Username is required                                        |