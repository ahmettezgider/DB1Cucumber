Feature: Login

  Scenario: Login with user defined in yaml file

    Given user on homepage

    When  user clicks LOGIN on menu with Enum

    And   user login as "user"

    Then  login should be successful