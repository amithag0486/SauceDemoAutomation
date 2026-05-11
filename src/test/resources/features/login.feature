Feature: SauceDemo Login

Background:
	Given I am on SauceDemo Login page
	
Scenario Outline: Valid Login
	When I login with username "<username>" and password "<password>"
	Then I should be redirected to the inventory page
	
	Examples:
	| username | password |
	| standard_user | secret_sauce |
	| performance_glitch_user | secret_sauce |
	| visual_user | secret_sauce |
	
Scenario Outline: Invalid Login
	When I login with username "<invalidusername>" and password "<password>"
	Then I should get a error message
	
	Examples:
	| invalidusername | password |
	| performance_glitch_use | secret_sauce |
	| visual_ | secret_sauce |
	|         | secret_sauce |
	| standard_user |        |