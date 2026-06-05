package com.srujana.stepdefs;

import com.srujana.pages.LoginPage;
import com.srujana.pages.ProductsPage;
import com.srujana.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.open();
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the products page should be displayed")
    public void the_products_page_should_be_displayed() {
        productsPage = new ProductsPage(DriverFactory.getDriver());
        assertTrue("Products page was not displayed after login", productsPage.isLoaded());
    }

    @Then("an error message {string} should be shown")
    public void an_error_message_should_be_shown(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}
