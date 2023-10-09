Feature: Contact Us functionality


  @ContactUs
  Scenario: Send Message Successfully
    Given user on homepage
    When  user clicks CONTACTUS on menu with Enum
    Then  the CONTACT page should be visible
    When  user submits the contact form as follows
      | name    | ali               |
      | email   | deneme@deneme.com |
      | subject | test deneme       |
      | message | test mesaji       |
      | file    | c:\temp\Java.txt  |
    Then accept popup
    Then the text "Success! Your details have been submitted successfully." is visible

  @ContactUs
  Scenario: Send Message Successfully
    Given user on homepage
    When  user clicks CONTACTUS on menu with Enum
    Then  the CONTACT page should be visible
    When  user submits the contact form as follows
      | name    | ali               |
      | email   | deneme@deneme.com |
      | subject | test deneme       |
      | message | test mesaji       |
      | file    | c:\temp\Java.txt  |
    Then dismiss popup
    Then the text "Success! Your details have been submitted successfully." is not visible



