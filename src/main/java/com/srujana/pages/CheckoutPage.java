package com.srujana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("first-name");
    private final By lastNameField  = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton   = By.id("finish");
    private final By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterDetails(String firstName, String lastName, String zipCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, zipCode);
        click(continueButton);
    }

    public void finishOrder() {
        click(finishButton);
    }

    public String getConfirmationMessage() {
        return getText(completeHeader);
    }
}
