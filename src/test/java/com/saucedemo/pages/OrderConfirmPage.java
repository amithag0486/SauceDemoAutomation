package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class OrderConfirmPage {

    private Page page;

    // Locators
    private static final String CONFIRM_CONTAINER  = "#checkout_complete_container";
    private static final String CONFIRM_HEADER     = ".complete-header";
    private static final String CONFIRM_TEXT       = ".complete-text";
    private static final String CONFIRM_IMAGE      = ".pony_express";
    private static final String BACK_HOME_BUTTON   = "#back-to-products";
    private static final String PAGE_TITLE         = ".title";

    // Constructor
    public OrderConfirmPage(Page page) {
        this.page = page;
    }

    // Actions

    // Check confirmation page loaded
    public boolean isConfirmationPageLoaded() {
        return page.locator(CONFIRM_CONTAINER).isVisible();
    }

    // Get page title — "Checkout: Complete!"
    public String getPageTitle() {
        return page.locator(PAGE_TITLE).innerText();
    }

    // Get confirmation header — "Thank you for your order!"
    public String getConfirmationHeader() {
        return page.locator(CONFIRM_HEADER).innerText();
    }

    // Get confirmation text
    public String getConfirmationText() {
        return page.locator(CONFIRM_TEXT).innerText();
    }

    // Check thank you message visible
    public boolean isThankYouMessageVisible() {
        return page.locator(CONFIRM_HEADER).isVisible();
    }

    // Check confirmation image visible
    public boolean isConfirmationImageVisible() {
        return page.locator(CONFIRM_IMAGE).isVisible();
    }

    // Click back to products
    public void clickBackToProducts() {
        page.locator(BACK_HOME_BUTTON).click();
    }

    // Get current URL
    public String getCurrentUrl() {
        return page.url();
    }
}
