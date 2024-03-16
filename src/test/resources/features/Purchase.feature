@Purchase
Feature: purchase
  User want to be able to add items and remove items from my shopping cart and complete checkout

  Scenario: User sort product and add to carts
    Given user open the web page
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then  User is already on the landing page
    When User sort product by "Name (Z to A)"
    And User click add to cart item "Sauce Labs Onesie"
    And User click add to cart item "Test.allTheThings() T-Shirt (Red)"
    And User click add to cart item "Sauce Labs Backpack"
    Then User should see the shopping cart icon show the number of "3" items
    When User click shopping cart
    Then User is already on Your Cart page
    When User click remove button for item "Test.allTheThings() T-Shirt (Red)"
    Then User should see the shopping cart icon show the updated number of "2" items
    When User click Checkout button
    Then User is already on Checkout: Your Information page
    When User input "Spongebob" as First Name and "Squarepants" as Last Name and "140786" as Zip Code and click continue
    Then User is already on Checkout: Overview page
    When User can see the verified total price
    And User click Finish button
    Then User is already on Checkout:Complete! page


