package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class InventoryPage {
	
	private Page page;
	
	//URL
	 
	private static final String URL = "https://www.saucedemo.com/inventory.html";
	
	//locators
	
	private static final String inventory_container = "#inventory_container";
	private static final String inventory_item = ".inventory_list";
	private static final String addtocart_button = "button[id^='add-to-cart-";
	private static final String cart_icon = ".shopping_cart_link";
	private static final String hamburger_menu = "#react-burger-menu-btn";
	private static final String removecart_button = "button[id^='remove-";
	private static final String shopping_cart_badge = ".shopping_cart_badge";
	
	public InventoryPage(Page page) {
		this.page =page;
	}
	
	//Actions
	public void goToInventoryPage() {
		page.navigate(URL);
		page.waitForLoadState();
	}
	
	public boolean checkIfInventroypageLoaded() {
		return page.locator(inventory_container).isVisible();
	}
	
	public String checkPageTitle() {
		return page.locator(URL).innerText();
	}
	
	//Add first item
	public void addFirstItem() {
		page.locator(addtocart_button).first().click();
	}
	
	//Add by item name
	public void addByItemName(String itemname) {
		page.locator(addtocart_button + itemname + "']").click();
	}
	
	//Get number of items in the cart
	public String getItemsnumberinCart() {
		return page.locator(shopping_cart_badge).innerText();
	}
	
	//clcik on cart
	public void clickOnCart() {
		page.locator(cart_icon).click();
	}
	
	//get number of items on the page
	public int getInventoryItemCount() {
		return page.locator(inventory_item).count();
	}
	
	//get current URL
	public String getcurrentURL() {
		return page.url();
	}

}
