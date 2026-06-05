Feature: SauceDemo Cart and Checkout
  As a logged-in shopper
  I want to add a product and complete checkout
  So that I can successfully place an order

  Background:
    Given the user is logged in as "standard_user"

  Scenario: Add a single product and complete checkout
    When the user adds "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"
    When the user checks out with first name "Srujana" last name "Achalla" and zip "600001"
    Then the order confirmation message "Thank you for your order!" should be displayed

  Scenario: Add two products before checking out
    When the user adds "Sauce Labs Backpack" to the cart
    And the user adds "Sauce Labs Bike Light" to the cart
    Then the cart badge should show "2"
    When the user checks out with first name "Srujana" last name "Achalla" and zip "600001"
    Then the order confirmation message "Thank you for your order!" should be displayed
