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


  Scenario: Register User
    Given user on homepage
    * title should be "Automation Exercise"
    * user clicks LOGIN on menu with Enum
    * the text "New User Signup!" is visible
    * user fills the New User Signup form as follows then clicks signup
      | name  | newUser1            |
      | email | newuser123@user.com |
    * the text "ENTER ACCOUNT INFORMATION" is visible


  #1. Launch browser
  #2. Navigate to url 'http://automationexercise.com'
  #3. Verify that home page is visible successfully
  #4. Click on 'Signup / Login' button
  #5. Verify 'New User Signup!' is visible
  #6. Enter name and email address
  #7. Click 'Signup' button
  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
  9. Fill details: Title, Name, Email, Password, Date of birth
  10. Select checkbox 'Sign up for our newsletter!'
  11. Select checkbox 'Receive special offers from our partners!'
  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
  13. Click 'Create Account button'
  14. Verify that 'ACCOUNT CREATED!' is visible
  15. Click 'Continue' button
  16. Verify that 'Logged in as username' is visible
  17. Click 'Delete Account' button
  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
