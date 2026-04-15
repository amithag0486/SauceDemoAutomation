package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage{
	
	
	private Page page;
	
	
	//URL
	
	private static final String URL ="https://www.saucedemo.com/";
	
	//Locators
	private static final String UserName_Field = "#user-name";
	private static final String Password_Field = "#password";
	private static final String Login_Button = "#login-button";
	private static final String Error_Msg= ".error-message-container";
	
	//Contrtucor
	
	public LoginPage(Page page) {
		this.page = page;
		
	}
	
	//Actions
	
	public void goToLoginPage() {
		page.navigate(URL);
		page.waitForLoadState();
	}
	
	public void enterUsername(String username) {
		page.locator(UserName_Field).fill(username);
	}
	
	public void enterPassword(String password) {
		page.locator(Password_Field).fill(password);
	}
	
	public void clickLoginButton() {
		page.locator(Login_Button).click();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	//Getters for asserstion
	
	public boolean isUserNameFeildVisible() {
		return page.locator(UserName_Field).isVisible();
	}
	
	public boolean isPasswordFeildVisible() {
		return page.locator(Password_Field).isVisible();
	}
	
	public boolean isErrorMessageVisible() {
		return page.locator(Error_Msg).isVisible();
	}
	
	public String getErrorMessage() {
		return page.locator(Error_Msg).innerText();
	}
	
	public String getCurrentURL() {
		return page.url();
	}
	
}