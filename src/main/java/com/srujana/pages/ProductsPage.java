package com.srujana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By pageTitle = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink  = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(pageTitle) && getText(pageTitle).equalsIgnoreCase("Products");
    }

    /**
     * SauceDemo exposes a data-test attribute like
     * data-test="add-to-cart-sauce-labs-backpack" for each product,
     * so we can derive the locator from the product name.
     */
    public void addProductToCart(String productName) {
        String dataTest = "add-to-cart-" + productName.trim().toLowerCase().replace(" ", "-");
        click(By.cssSelector("[data-test='" + dataTest + "']"));
    }

    public String getCartBadgeCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }
}
