
# Palindrome

This project includes both UI and API test cases for a Palindrome program. 


## Prerequisites

Reactjs, Java, Maven, Intellij and Git is installed on your local machine.
  
## Assumptions

1. Both Spring Boot API and Reactjs applications are running.
2. Created a separated module for test cases so that if in future there are changes in the application the test cases don't required to be build again and can be used seperately.
## Run Locally

Clone the project

```bash
  git clone https://github.com/suresharora10/Palindrome_Suresh.git
```

Go to the project directory

```bash
  cd <project_dir>\client\palindrome-ui
```

Install dependencies

```bash
  npm install
```

Start the UI application

```bash
  npm run start
```

Go to the project directory

```bash
  cd <project_dir>\server
  ```

Start the API application

```bash
  mvn spring-boot:run
```


## Documentation


1. Created a BDD cucumber framework -  Palindrome_TestCases.
2. Created seperate feature files - PalindromeAPITests and PalindromeUITests for both API and UI test cases respectively.
3. PalindromeStepDef includes the definitions for all the feature files.
4. TestRunner class is used to provide mapping between the feature files and step definitions file.
5. Added below dependencies in POM.xml
*   cucumber-java
*   junit
*   selenium-java
*   gherkin
*   cucumber-core
*   cucumber-junit
*   cucumber-reporting
*   hamcrest-core
*   io.rest-assured
*   cucumber-jvm-deps
*   maven-surefire-plugin

6. Used cucumber-reporting dependency for generating the HTML report.    


    


## Running Tests

To run unit tests for the API, go to <project_dir>\server
```bash
  mvn test
```

To run unit tests for the UI, go to <project_dir>\client\palindrome-ui
```bash
  npm test
```

To run both end to end test cases for both UI and API, go to <project_dir>\Palindrome_TestCases\
```bash
  mvn clean test -D"cucumber.filter.tags=@ui or @api"
```
## TestResults

*   API Unit TestResults - 
*   UI Unit TestResults -
*   API E2E TestResults -
*   UI E2E TestResults - 
## Improvements In The Code

* Added backend validation whether input is a valid number.
    * String validation
    * Integer out of range validation

* Added UI validation in the input field to accept only numeric values.
