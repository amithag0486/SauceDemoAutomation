package com.saucedemo.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;


import io.cucumber.java.en.*;

public class LoginSteps {
	
	
		
		
		//Step definitions
		
		@Given("I am on SauceDemo Login page")
		public void iamonSauceDemoLoginpage() {
			BaseSteps.loginPage.goToLoginPage();
		}
		
		@When("I login with username {string} and password {string}")
		public void loginWithUsernameandPassword(String username, String password) {
			BaseSteps.loginPage.login(username, password);
		}
		
		@Then("I should be redirected to the inventory page")
		public void ishouldberedirectedtoinventorypage() {
			assertTrue(BaseSteps.loginPage.getCurrentURL().contains("inventory"));
		
		}
		@Then("I should get a error message")
		public void iShouldgetaErrorMsg() {
			assertTrue(BaseSteps.loginPage.isErrorMessageVisible(),"Error msg visible");
		}
			
		
		

}
