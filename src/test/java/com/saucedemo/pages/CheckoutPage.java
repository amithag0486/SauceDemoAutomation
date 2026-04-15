package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
	
	private Page page;
	
	//locators
	
	private static final String checkout_Container = "#checkout_info_container";
	private static final String first_name = "#first-name";
	private static final String last_name= "#last-name";
	private static final String postal_code = "#postal-code";
	private static final String error_msg = ".error-message-container error";
	private static final String continue_button = "#continue";
	private static final String cancel_button = "#cancel";
	private static final String pageTile = ".title";
	
	public CheckoutPage(Page page) {
		this.page =page;
	}
	
	//Actions
	
	//get page title
		public String getPageTitle() {
			return page.locator(pageTile).innerText();
		}
		
		//Check if the checkout page is loaded
		public boolean isOnCheckoutPage() {
			return page.locator(checkout_Container).isVisible();
		}
		
		public void enterLastName(String lasttName) {
			page.locator(last_name).fill(lasttName);
		}
		
		public void enterFirstName(String firstName) {
			page.locator(first_name).fill(firstName);
		}
		
		public void enterPostalCode(String postalcode) {
			page.locator(postal_code).fill(postalcode);
		}
		
		public void clickContinue() {
			page.locator(continue_button).click();
		}
		
		public void fillAllfieldsandClick(String firstNmae, String lastName, String postalCode ) {
			enterLastName(lastName);
			enterFirstName(firstNmae);
			enterPostalCode(postalCode);
			clickContinue();
		}
		
		public boolean isErrorMessageVisible() {
			return page.locator(error_msg).isVisible();
		}
		
		public void clickCancel() {
		    page.locator(cancel_button).click();
		}
		
		public String getErrorMessage() {
			return page.locator(error_msg).innerText();
		}
		
		public String getCurrentURL() {
			return page.url();
		}

}
