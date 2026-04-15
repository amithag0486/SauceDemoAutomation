package com.saucedemo.steps;




import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class checkoutSteps {
	
	@When("I add {string} to the cart")
	public void iAddItemtoCart(String itemName) {
		BaseSteps.inventoryPage.addByItemName(itemName);
	}
	
	@And("I click on the cart icon")
	public void iClickonCartIcon() {
		BaseSteps.inventoryPage.clickOnCart();
	}
	
	@And("I verify that I am on cart page")
	public void iVerifyoncartPage() {
		assertTrue(BaseSteps.cartPage.checkOncartPage(), "I am on cart page");
	}
	
	@Then("I verify the item {string} is on the cart")
	public void iverifyItemnameOnCart(String itemName) {
		assertTrue (BaseSteps.cartPage.getItemsTitle().contains(itemName),"Contains the " + itemName);
	}
	
	@And("I click on Checkout")
	public void iClickOnCheckout() {
		BaseSteps.cartPage.clickOnCheckout();
	}
	
	@And("I fill my credentials with firstName {string} lastName {string} and postlCode {string}")
	public void iFillMyCredentials(String firstName, String lastName, String postalCode ) {
		BaseSteps.checkoutPage.fillAllfieldsandClick(firstName, lastName, postalCode);
	}
	
	@And("I click on continue")
	public void iClickOnContinue() {
		BaseSteps.checkoutPage.clickContinue();
	}
	
	@Then("I verify that I am CheckoutOverivew page")
	public void iVerifyOnCheckoutOverviewPage() {
		assertTrue(BaseSteps.checkoutOverviewPage.isOnCheckouOverviewtPage(),"On Checkout Overview Page");
	}
	
	@And("I click on finish")
	public void iClickonFinish() {
		BaseSteps.checkoutOverviewPage.clickFinish();
	}
	
	@Then("I should see the order confirmation message {string}")
	public void iSeeOrderConfirmation(String message) {
		assertEquals(message, BaseSteps.orderConfirmPage.getConfirmationHeader());
	}

			
			
			

}
