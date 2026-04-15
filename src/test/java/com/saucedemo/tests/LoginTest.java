package com.saucedemo.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.saucedemo.pages.*;

public class LoginTest{
	
	//Initialize Objects
	static Playwright playwright;
	static Browser browser;
	BrowserContext context;
	Page page;
	LoginPage loginPage;
	
	@BeforeAll
	static void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false));
				
	}
	
	@BeforeEach
	void createPage() {
		context = browser.newContext();
		page = context.newPage();
		page.setDefaultTimeout(10000);
		loginPage = new LoginPage(page);
		loginPage.goToLoginPage();
	}
	
	@Test
	//Test if UserName field is visible
	void testifPageloads() {
		assertTrue(loginPage.isUserNameFeildVisible(),"Page is loaded and user field is visble");
	}
	
	@Test
	//Valid login
	void testValidLogin() {
		loginPage.login("standard_user", "secret_sauce");
		assertTrue(loginPage.getCurrentURL().contains("inventory"),"Inside and on homepage");
	}
	
	@AfterEach
	void closepage() {
		context.close();
	}
	
	@AfterAll
	static void closeBrowser() {
		browser.close();
		playwright.close();
	}
	
}