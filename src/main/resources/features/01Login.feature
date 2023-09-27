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
    And   user fills the New User Signup form as follows then clicks signup
      | name  | newUser1            |
      | email | newuser123@user.com |

    Then  login should be successful


  @login1
  Scenario: Login with By
    Given user on homepage
    And   user clicks LOGIN on menu with Enum
    When  user fill the input "Email Address" as "atezgider@gmail.com"
    And   user fill the input "Password" as "atezgider"
    And   user clicks the button "Login"

