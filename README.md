# Automated E-commerce Order Workflow Tests

This project contains an automated test suite for an e-commerce platform’s product purchase and order management workflows. It uses **Selenium WebDriver** with **Java** and **Cucumber (BDD)** to provide readable, maintainable, and data-driven test automation.

---

## 🚀 Features

- End-to-end automation of key user journeys:
    - Product selection and adding to cart
    - Shipping details entry
    - Payment process
    - Order placement and cancellation
- Behavior Driven Development (BDD) with **Cucumber** and **Gherkin** syntax
- Parameterized test scenarios using **Scenario Outlines** and **Examples** for flexible data-driven testing
- Page Object Model (POM) pattern for better code organization and reusability
- TestNG for test execution and reporting

---

## 🛠️ Tech Stack

- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven
- Git & GitHub

---

## 📁 Project Structure

- Automated-Tests/
    - features/                      # Gherkin feature files
        - PurchaseOrder.feature
    - src/
        - main/
            - java/
                - pages/                   # Page Object classes
                - stepdefinitions/         # Cucumber step definitions
                - utils/                   # WebDriver setup and helpers
                - runners/                 # Test runners for Cucumber + TestNG
        - test/
            - resources/
                - config.properties        # Test configuration properties
    - testng.xml                    # TestNG suite configuration
    - pom.xml                       # Maven project file
    - reports/                      # Test execution reports
    - README.md



---

## ⚙️ Configuration (`config.properties`)

The project uses a `config.properties` file located at `src/test/resources/config.properties` to manage test settings dynamically:

| Property             | Description                                               |
|----------------------|-----------------------------------------------------------|
| `Browser`            | Browser type to run tests on (e.g., Chrome, Firefox)     |
| `Browser_headless`    | Run browser in headless mode (`true` or `false`)         |
| `User_browser_profile`| Use a custom browser profile (`true` or `false`)         |
| `Wait_timeout`       | Timeout duration (in seconds) for explicit waits          |
| `Browser_profile_path`| File path to the user’s browser profile (used if enabled) |

This setup allows easy customization of test execution without modifying the code.

---

## 📌 How to Run the Tests

1. **Clone the repo:**

   ```bash
   git clone https://github.com/A5hit/Automated-Tests.git
   cd Automated-Tests

2. **Update config.properties:**
    Modify the file under src/test/resources/ with environment-specific values, such as browser preferences and timeouts.
3. **Run tests with Maven:**
    ```bash
   mvn clean test
4.  **View reports:**
    After test execution, open the generated TestNG report located at reports/testng-report.html in your browser.