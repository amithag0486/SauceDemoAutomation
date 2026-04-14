Feature: SauceDemo Login

Background:
	Given I am on SauceDemo Login page
	
Scenario: Valid Login
	When I login with username "standard_user" and password "secret_sauce"
	Then I should be redirected to the inventory page