package com.srujana.stepdefs;

import com.srujana.pages.CartPage;
import com.srujana.pages.CheckoutPage;
import com.srujana.pages.LoginPage;
import com.srujana.pages.ProductsPage;
import com.srujana.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CheckoutSteps {

    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String username) {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.open();
        loginPage.login(username, "secret_sauce");
        productsPage = new ProductsPage(DriverFactory.getDriver());
    }

    @When("the user adds {string} to the cart")
    public void the_user_adds_to_the_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("the cart badge should show {string}")
    public void the_cart_badge_should_show(String expectedCount) {
        assertEquals(expectedCount, productsPage.getCartBadgeCount());
    }

    @When("the user checks out with first name {string} last name {string} and zip {string}")
    public void the_user_checks_out(String firstName, String lastName, String zip) {
        productsPage.openCart();
        cartPage = new CartPage(DriverFactory.getDriver());
        cartPage.clickCheckout();
        checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.enterDetails(firstName, lastName, zip);
        checkoutPage.finishOrder();
    }

    @Then("the order confirmation message {string} should be displayed")
    public void the_order_confirmation_message_should_be_displayed(String expectedMessage) {
        assertEquals(expectedMessage, checkoutPage.getConfirmationMessage());
    }
}
