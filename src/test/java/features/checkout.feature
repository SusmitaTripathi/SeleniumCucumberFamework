Feature: Place Order of Products

  @PlaceOrder
  Scenario Outline: Add Product to cart
    Given User is on greencart landing page
    When User searches with shortname <Name> and extracts actual name of product
    And User added "3" items of selected product to cart
    Then User proceeds to checkout and validates the <Name> items in checkout page
    And User enters promo code and proceeds to place order
    Examples:
      | Name |
      | Tom  |
      | Beet |