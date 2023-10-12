Feature: OrangeHRM

  Scenario: Test Login
    Given orangehrm user on homepage
    When  orangehrm user fill "Username" as "Admin"
    And   orangehrm user fill "Password" as "admin123"
    And   orangehrm user clicks the button "Login"
