Feature: SauceDemo Login
  As a registered shopper
  I want to log in to the SauceDemo store
  So that I can browse and purchase products

  Background:
    Given the user is on the SauceDemo login page

  Scenario: Successful login with valid credentials
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the products page should be displayed

  Scenario: Login is blocked for a locked-out user
    When the user logs in with username "locked_out_user" and password "secret_sauce"
    Then an error message "Epic sadface: Sorry, this user has been locked out." should be shown

  Scenario Outline: Login fails with invalid credentials
    When the user logs in with username "<username>" and password "<password>"
    Then an error message "<message>" should be shown

    Examples:
      | username        | password      | message                                                                   |
      | invalid_user    | secret_sauce  | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | wrong_pass    | Epic sadface: Username and password do not match any user in this service |
