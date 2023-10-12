Feature: OrangeHRM

  Scenario: Test Login
    Given orangehrm user on "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When  orangehrm user fill "Username" as "Admin"
    And   orangehrm user fill "Password" as "admin123"
    And   orangehrm user clicks the "Login" button
    *     orangehrm user clicks the "Admin" button
    *     orangehrm user fill "Username" as "Anthony.Nolan"
    *     orangehrm from "Employee Name" textbox search "Anthony" then select "Anthony Nolan"
    *     orangehrm user clicks the 2.nt "Search" button
