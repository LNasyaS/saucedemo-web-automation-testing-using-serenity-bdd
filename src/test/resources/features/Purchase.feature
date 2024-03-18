@Purchase
Feature: purchase
  User want to be able to add items and remove items from shopping cart and complete checkout

  @TC3
  Scenario: User sort products by descending order, add two items to cart, remove one item from cart, and complete the checkout
    Given user open the web page
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then  User is already on the landing page
    When User sort product by "Price (low to high)"
    And User click add to cart item "Sauce Labs Onesie"
    And User click add to cart item "Sauce Labs Bike Light"
    Then User should see the shopping cart icon show the number of "2" items
    When User click shopping cart
    Then User is already on your cart page
    When User click remove button for item "Sauce Labs Bike Light"
    Then User should see the shopping cart icon show the number of "1" items
    When User click checkout button
    Then User is already on checkout your information page
    When User input "Spongebob" as firstName and "Squarepants" as lastName and "140786" as zip and click continue
    Then User is already on checkout overview page
    And User can see the verified total price
    When User click finish button
    Then User is already on checkout complete page


