Feature: Login

  @login
  Scenario: Login with user defined in yaml file
    Given user on homepage
    When  user clicks LOGIN on menu with Enum
    And   user login as "user"
    Then  login should be successful

  @signup
  Scenario: Sign up
    Given user on homepage
    When  user clicks SIGNUP on menu with Enum
    And   user fills the New User Signup form as follows
      | name  | newUser1            |
      | email | newuser123@user.com |

    Then  login should be successful


  Scenario: aaa
    When  user save "1000" as "miktar"
    Then  "miktar" degeri "1000" olmali
