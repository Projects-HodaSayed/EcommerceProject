@smoke
Feature: User add product to wishlist
  Scenario: User add product to wishlist and a message will appear
    When User click on wishlist button
    Then Success message will appear

  Scenario: User add product to wishlist and check Qty value
    When User click on wishlist button
    And After Wishlist success message disappear user open wishlist link
    Then Check Qty value bigger than zero



