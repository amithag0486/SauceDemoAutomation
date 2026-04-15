package com.saucedemo.pages;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutOverviewPage {
	
	private Page page;
	
	//locators
	
	private static final String checkout_Container = "#checkout_summary_container";
	private static final String cart_list = ".cart_list";
	private static final String inventory_item_name= ".inventory_item_name";
	private static final String finish_button = "#finish";
	private static final String cancel_button = "#cancel";
	private static final String pageTile = ".title";
	
	public CheckoutOverviewPage(Page page) {
		this.page =page;
	}
	
	//Actions
	
		//get page title
			public String getPageTitle() {
				return page.locator(pageTile).innerText();
			}
			
			//Check if the checkout overview page is loaded
			public boolean isOnCheckouOverviewtPage() {
				return page.locator(checkout_Container).isVisible();
			}
			
			public void clickFinish() {
				page.locator(finish_button).click();
			}
			
			public void clickCancel() {
				page.locator(cancel_button).click();
			}
			
			//Find a item by itemName
			//check which item is on the list
			public List<String> getItemsTitle(){
				 List<String> titles = new ArrayList<>();
				 List<Locator> locators = page.locator(inventory_item_name).all();
				 for (int i = 0; i<locators.size(); i++) {
					 titles.add(locators.get(i).innerText());
				 }
				 return titles;
				 
			}
			
			//How many iTems on the list
			public int getNumberofitems() {
				return page.locator(cart_list).count();
			}
			
			public String getCurrentURL() {
				return page.url();
			}

}
