Feature: Product functionality


  Scenario: Add a product to the Cart
    Given user on homepage
    When  user clicks PRODUCTS on menu with Enum
    And   user search "Blue"
    And   user add "Blue Top" to the Cart
    Then  the text "Your product has been added to cart." is visible
    Then  I click the "Continue Shopping" button
    And   the text "Your product has been added to cart." is not visible







