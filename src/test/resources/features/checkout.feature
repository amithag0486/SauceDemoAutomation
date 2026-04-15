Feature: Add item and checkout on SauceDemo 

Background:
	Given I am on SauceDemo Login page
	Given I login with username "standard_user" and password "secret_sauce"
	
Scenario: Successfully checkout and item
	When I add "sauce-labs-backpack" to the cart
	And I click on the cart icon
	And I verify that I am on cart page
	Then I verify the item "Sauce Labs Backpack" is on the cart
	And I click on Checkout
	And I fill my credentials with firstName "Amitha" lastName "Ganesh" and postlCode "94568"
	Then I verify that I am CheckoutOverivew page
	And I click on finish
	Then I should see the order confirmation message "Thank you for your order!" 
	