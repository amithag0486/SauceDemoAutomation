package com.saucedemo.pages;

import java.util.List;

import com.microsoft.playwright.Locator;
import java.util.ArrayList;


import com.microsoft.playwright.Page;



public class CartPage {
	
	private Page page;
	
	//Locators
	
	private static final String cart_container = "#cart_contents_container";
	private static final String cart_list = ".cart_list";
	private static final String pageTile = ".title";
	private static final String cart_itemname = ".inventory_item_name";
	private static final String remove_button = "button[id^='remove-";
	private static final String checkout_button = "#checkout";
	private static final String continueShopping_button = "#continue-shopping";
	
	
	
	public CartPage(Page page) {
		this.page =page;
	}
	
	//Actions
	//Check if the cart page is loaded
	public boolean checkOncartPage() {
		return page.locator(cart_container).isVisible();
	}
	
	//check number of items in the cart
	public int getNumberofitems() {
		return page.locator(cart_list).count();
	}
	
	//check which item is on the list
	public List<String> getItemsTitle(){
		 List<String> titles = new ArrayList<>();
		 List<Locator> locators = page.locator(cart_itemname).all();
		 for (int i = 0; i<locators.size(); i++) {
			 titles.add(locators.get(i).innerText());
		 }
		 return titles;
		 
	}
	
	//get page title
	public String getPageTitle() {
		return page.locator(pageTile).innerText();
	}
	
	//click remove a particular item
	public void removeOneItem(String itemname) {
		page.locator(remove_button + itemname + "']").click();
	}
	
	//click checkout
	public void clickOnCheckout() {
		page.locator(checkout_button).click();
	}
	
	//click countiune checkout
	public void clickContiuneShopping() {
			page.locator(continueShopping_button).click();
		}
	
	//get current URL
		public String getcurrentURL() {
			return page.url();
		}
		
		

}
