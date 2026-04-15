package com.saucedemo.steps;

import com.microsoft.playwright.*;
import com.saucedemo.pages.*;
import io.cucumber.java.*;

public class BaseSteps {
	
    // Shared state between step files
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    // Shared page objects
    public static LoginPage loginPage;
    public static InventoryPage inventoryPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static OrderConfirmPage orderConfirmPage;
    public static CheckoutOverviewPage checkoutOverviewPage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext();
        page = context.newPage();
        page.setDefaultTimeout(10000);

        // Initialize all page objects once
        loginPage        = new LoginPage(page);
        inventoryPage    = new InventoryPage(page);
        cartPage         = new CartPage(page);
        checkoutPage     = new CheckoutPage(page);
        checkoutOverviewPage = new CheckoutOverviewPage(page);
        orderConfirmPage = new OrderConfirmPage(page);
    }

    @After
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }

}
