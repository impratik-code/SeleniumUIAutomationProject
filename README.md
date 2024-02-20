# UI Automation Test Suite

This UI Automation Test Suite is designed for automated testing of the Entrata web application. It includes page object repositories, test scripts, test data, and utilities necessary for running automated tests.

## Project Structure

The project is organized as follows:

- **EntrataPageObjectRepo**: Contains Java classes representing page objects for different pages of the Entrata web application. Each page object class encapsulates the locators and methods related to that specific page.
  - **EntrataHomePage.java**: Page object class for the home page of the Entrata application.
  - **EntrataLogInPage.java**: Page object class for the login page of the Entrata application.
  - **EntrataSignInPage.java**: Page object class for the sign-in page of the Entrata application.
  - **EntrataWatchDemoPage.java**: Page object class for the watch demo page of the Entrata application.
  - **ResidentLoginPage.java**: Page object class for the resident login page of the Entrata application.

- **Tests**: Contains Java classes representing test scripts for automated testing of various functionalities of the Entrata web application.
  - **UIAutomationTests.java**: Contains test methods for verifying different functionalities and scenarios of the Entrata application.

- **TestUtilities**: Contains utility classes and methods used across the test scripts for common functionalities like reading test data, handling browser operations, etc.

- **TestData.xml**: XML file containing test data used by the test scripts for parameterization and data-driven testing.

## Running Tests

To run the automated tests:

1. Clone or download the project from the GitHub repository.

2. Set up your development environment with the necessary dependencies (Java, Selenium WebDriver, TestNG, etc.).

3. Import the project into your preferred IDE (Eclipse, IntelliJ IDEA, etc.).

4. Ensure that the WebDriver executable (e.g., chromedriver.exe for Chrome) is available and properly configured in the project.

5. Modify the test data in the TestData.xml file as needed for your test scenarios.

6. Update "String FilePath" to your local TestData.xml Path. Example, String FilePath = "Your/local path/UIAutomationTestSuit/src/Tests/TestData.xml"

7. Execute the test scripts either individually or collectively using TestNG test suites.

8. Monitor the test execution results in the test output directory and review any failures or errors encountered during testing.

## Contributing

Contributions to this project are welcome! If you find any bugs, issues, or have suggestions for improvements, please open an issue or submit a pull request on GitHub.

## License

This project is licensed under the [MIT License](LICENSE).
