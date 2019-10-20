# Automation Web Exercise

The aim of this exercise is to test a basic scenario where a user search a product in Amazon and test if the product
is added to shopping cart correctly.
It has been developed using Selenium and Cucumber

## Getting Started

To execute this project you need:
- Java
- Maven

To view and edit the code you can use:
- Eclipse
- IntelliJ

### Install Java on Windows

1. Download java and follow the steps specified at the official page:
https://java.com/en/download/help/windows_manual_download.xml

2. Set the java environment Path
For example:
C:\ProgramFiles\Java\jdk-12\bin

3. Verify Java installation
Go to command prompt and type:

```
java -version
```

If you see the version, Java is installed

### Install Java on Mac

1. Download java and follow the steps specified at the official page:
https://java.com/en/download/help/mac_install.xml

### Install Maven on Windows and Mac
Follow the steps: https://maven.apache.org/install.html

### Execute the project

Go to command prompt and do to the directory where you have the project.
For example c:/AutomationWebExercise

Type the command:
```
mvn test
```

If you want to generate a pretty hml report with the results, type the following command after the test execution:

```
mvn cluecumber-report:reporting
```
The report will be generated at target/generated-report

For more information about cluecumber report:
https://github.com/trivago/cluecumber-report-plugin


## Project Structure

All the developed code is in the following path, orginized by packages:
 - src/test/java

 Below are explained each of them

### Feature file
src/test/java/resources/functionalTests

In the file Amazon_Test.feature is defined a feature and the scenario that defines the test case proposed at the
exercise. The Scenario Outline allows several executions for several test data, in this case I have used two examples
of product search: "Iphone 11" and "Iphone XR"

### Step definitions
src/test/java/stepsDefinitions

For this test case, maybe it is enough a single class with all the steps, but I have divided the steps in three related
Steps file in order to show how to share the TestContext between the steps.
The Steps classes are divided depending on the type of operation performed by the user:
 - SearchSteps : Involves all the steps the user performs to search a product. In this case, perform a search at the Main Page.
 - AddToShoppingCartSteps: Involves all the steps needed when user add a product into the shopping cart.
   In this case select a product from the results page and add add it into the shopping cart.
 - ShoppingSteps: Involves all the steps needed at the final process to shop a product. In this case,
   click the button to shopping cart and check into the shopping cart page thant the product has been added properly.

### Page Objects
src/test/java/pageObjects

I have used Page Object Design Pattern and Selenium PageFactory

The pages involved in the test are the following:

MainPage: Is the main page, where user perform the search of the product

ResultsPage: Where are shown all the products that match with the previous search

DetailPage: Where the detail of the product is shown after the user click on the list of the ResultsPage

PreShoppingPage: Is the page shown before go to shopping cart with the products selected and other recommendations

ShoppingCartPage: Is the page of the shopping cart

In all of the Page Objects the elements of the page are found using PageFactory with the @FindBy annotation

### PageObjectManager
src/test/java/managers/PageObjectManager

Creates an instance of a Page Object if it has not been created. If has, returns the instance.

### ConfigFileReader
src/test/java/providers

For this project I have created a Configuration.properties file with some basic data needed during the project, for
example, url, environment, etc.
This file is read by ConfigFileReader src/test/java/providers
As it needs to be accessed globally, in order to have only one Instance, I have implemented a Singleton Pattern.
FileReaderManager has a static reference to its own and returns the reference from the static getInstance() method.
src/test/java/managers/FileReaderManager

### WebdriverManager
src/test/java/managers/WebDriverManager

To create the WebDriver, some information is in Configuration.properties file and are provided by the ConfigFileReader
WebDriverManager checks if driver has been created before, if not, creates it.
Is prepared to be executed locally and with Chrome.
Exposes two methods: getDriver() and closeDriver();

### TestContext
src/test/java/cucumber/TestContext

In order to share state between all the Steps, I have used the library PicoContainer
that supports Cucumber to Manage the Dependency Injection.
Cucumber detects classes with steps definitions, passes them to PicoContainer and it creates the new instances.

All the information that the Steps need are in:
  - WebDriver (Provided by WebDriverManager)
  - Page Objects (Provided by PageObjectManager)

### TestRunner
src/test/java/runners/TestRunner

Other way to run the test is right click TestRunner class, "Run TestRunner"
Here there are specified some Cucumber Options.














