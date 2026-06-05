# SauceDemo — Selenium + Cucumber BDD Automation Framework

[![UI Tests](https://github.com/Srujana113/MiniProject_automationWebbrowser/actions/workflows/tests.yml/badge.svg)](https://github.com/Srujana113/MiniProject_automationWebbrowser/actions/workflows/tests.yml)

A clean, interview-ready test automation framework that validates **login** and **cart/checkout** flows on [saucedemo.com](https://www.saucedemo.com), built with **Selenium WebDriver (Java)**, **Cucumber BDD**, and the **Page Object Model**.

## 🧰 Tech Stack

| Layer            | Tool                               |
|------------------|------------------------------------|
| Language         | Java 17                            |
| Browser Driver   | Selenium WebDriver 4               |
| BDD              | Cucumber (Gherkin)                 |
| Test Runner      | JUnit 4                            |
| Build / Deps     | Maven                              |
| Design Pattern   | Page Object Model (POM)            |
| Reporting        | Cucumber HTML & JSON reports       |

> Selenium 4's built-in **Selenium Manager** downloads the matching ChromeDriver automatically — no manual driver setup required.

## ✅ What it tests

- **Login:** valid login, locked-out user, and invalid credentials (data-driven via `Scenario Outline`)
- **Checkout:** add product(s) to cart, verify cart badge count, complete the checkout flow, assert the order confirmation

## 📁 Project Structure

```
saucedemo-selenium-cucumber/
├── pom.xml
└── src
    ├── main/java/com/srujana/pages/      # Page Objects
    │   ├── BasePage.java                 # shared wait/interaction helpers
    │   ├── LoginPage.java
    │   ├── ProductsPage.java
    │   ├── CartPage.java
    │   └── CheckoutPage.java
    └── test
        ├── java/com/srujana/
        │   ├── runners/TestRunner.java   # Cucumber + JUnit entry point
        │   ├── stepdefs/                 # Glue: maps Gherkin → Java
        │   │   ├── LoginSteps.java
        │   │   └── CheckoutSteps.java
        │   ├── hooks/Hooks.java          # driver setup/teardown + screenshots
        │   └── utils/DriverFactory.java  # ThreadLocal WebDriver
        └── resources/features/           # Gherkin specs
            ├── login.feature
            └── checkout.feature
```

## ▶️ How to Run

**Prerequisites:** JDK 17+, Maven 3.8+, and Google Chrome installed.

```bash
# Run the full suite (opens a real Chrome window)
mvn clean test

# Run headless (no visible browser — good for CI)
mvn clean test -Dheadless=true
```

After the run, open the report at:

```
target/cucumber-report.html
```

## 🔄 Running in CI (GitHub Actions)

Create `.github/workflows/tests.yml`:

```yaml
name: UI Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
      - run: mvn clean test -Dheadless=true
```

## 💡 Talking Points for Interviews

- **Page Object Model** keeps locators and page actions out of the tests, so a UI change is a one-line fix in one class.
- **Explicit waits** in `BasePage` remove flaky `Thread.sleep` calls.
- **Cucumber** turns requirements into living, business-readable documentation.
- **`Scenario Outline`** demonstrates data-driven testing.
- **ThreadLocal driver** makes the framework parallel-execution ready.
- **Failure screenshots** are auto-attached to the report via an `@After` hook.
