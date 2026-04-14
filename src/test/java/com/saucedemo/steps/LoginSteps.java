package com.saucedemo.steps;

import com.microsoft.playwright.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import com.saucedemo.pages.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class LoginSteps {
	
	//Initialize Objects
		Playwright playwright;
		Browser browser;
		BrowserContext context;
		Page page;
		LoginPage loginPage;
		
		@Before
		public void setUp() {
		
			playwright = Playwright.create();
			browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setHeadless(false));

			context = browser.newContext();
			page = context.newPage();
			page.setDefaultTimeout(10000);
			loginPage = new LoginPage(page);
		}
		
		//Step definitions
		
		@Given("I am on SauceDemo Login page")
		public void iamonSauceDemoLoginpage() {
			loginPage.goToLoginPage();
		}
		
		@When("I login with username {string} and password {string}")
		public void loginWithUsernameandPassword(String username, String password) {
			loginPage.login(username, password);
		}
		
		@Then("I should be redirected to the inventory page")
		public void ishouldberedirectedtoinventorypage() {
			assertTrue(loginPage.getCurrentURL().contains("inventory"));
		
		}
		@Then("I should get a error message")
		public void iShouldgetaErrorMsg() {
			assertTrue(loginPage.isErrorMessageVisible(),"Error msg visible");
		}
			
		@After
		public void closeup() {
			context.close();
			browser.close();
			playwright.close();
		}
		

}
