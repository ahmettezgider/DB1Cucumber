Feature: Login

  Scenario: Login with user defined in yaml file

    Given user on homepage

    When  user clicks SIGNUP on menu with Enum

    And   user fills the login form as "user"

    And   user clicks to button "Login"

    Then  login should be successful