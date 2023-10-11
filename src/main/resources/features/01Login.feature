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

  @register1
  Scenario: Register User
    Given user on homepage
    Given title should be "Automation Exercise"
    * user clicks LOGIN on menu with Enum
    Given the text "New User Signup!" is visible
    * user fills the New User Signup form as follows then clicks signup
      | name  | newUser1            |
      | email | newuser123@user.com |
    Given the text "ENTER ACCOUNT INFORMATION" is visible
    And   user fill the input "Password" as "pass"
    And   user select "12" as Day, "January" as Month, "1990" as Year
    And   user fill the input "First name" as "First name"
    And   user fill the input "Last name" as "Last name"
    And   user fill the input "Company" as "Company"
    And   user fill the input "Address *" as "Address 1"
    And   user fill the input "Address 2" as "Address 2"
    And   user fill the input "State" as "State"
    And   user fill the input "City" as "City"
    And   user fill the input "Zipcode" as "123456"
    And   user fill the input "Mobile Number" as "123456789"
    And   user clicks the button "Create Account"
    Then  the text "ACCOUNT CREATED!" is visible

    And   user clicks LOGIN on menu with Enum
    When  user clicks DELETEACCOUNT on menu with Enum
    Then  the text "ACCOUNT DELETED!" is visible

  @register2
  Scenario: Register User 2
    Given user on homepage
    Given title should be "Automation Exercise"
    * user clicks LOGIN on menu with Enum
    Given the text "New User Signup!" is visible
    * user fills the New User Signup form as follows then clicks signup
      | name  | newUser1            |
      | email | newuser123@user.com |
    Given the text "ENTER ACCOUNT INFORMATION" is visible
    When  user fill the registerform as follows
      | Password      | pass       |
      | days          | 12         |
      | months        | January    |
      | years         | 1990       |
      | First name    | First name |
      | Last name     | Last name  |
      | Company       | Company    |
      | Address *     | Address 1  |
      | Address 2     | Address 2  |
      | country       | Canada     |
      | State         | State      |
      | City          | City       |
      | Zipcode       | 123456     |
      | Mobile Number | 123456789  |
    And   user clicks the button "Create Account"
    Then  the text "ACCOUNT CREATED!" is visible

    And   user clicks LOGIN on menu with Enum
    When  user clicks DELETEACCOUNT on menu with Enum
    Then  the text "ACCOUNT DELETED!" is visible


  @test
  Scenario: Register User 3
    Given user on homepage
    Given title should be "Automation Exercise"
    * user clicks LOGIN on menu with Enum
    Given the text "New User Signup!" is visible
    * user fills the New User Signup form as follows then clicks signup
      | name  | newUser1            |
      | email | newuser123@user.com |
    Given the text "ENTER ACCOUNT INFORMATION" is visible
    When  user fill the general form as follows
      | input  | Password      | pass       |
      | select | days          | 12         |
      | select | months        | January    |
      | select | years         | 1990       |
      | input  | First name    | First name |
      | input  | Last name     | Last name  |
      | input  | Company       | Company    |
      | input  | Address *     | Address 1  |
      | input  | Address 2     | Address 2  |
      | select | Country       | Canada     |
      | input  | State         | State      |
      | input  | City          | City       |
      | input  | Zipcode       | 123456     |
      | input  | Mobile Number | 123456789  |
    And   user clicks the button "Create Account"
    Then  the text "ACCOUNT CREATED!" is visible

    And   user clicks LOGIN on menu with Enum
    When  user clicks DELETEACCOUNT on menu with Enum
    Then  the text "ACCOUNT DELETED!" is visible