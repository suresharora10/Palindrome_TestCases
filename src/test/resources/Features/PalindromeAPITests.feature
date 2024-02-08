Feature:  API Automation tests for the Spring Boot REST service
  Description: The purpose of this feature file is to cover API automation test cases for a Palindrome program having input as an integer and string

  Background:
    Given the api server is running
    And the status code is "200"
    And response is "Hello world"

  @api
  Scenario Outline: User inputs integer value
    Given user passes <actualnumber>
    Then the status code is "200"
    And the result of program is <expectednumber>
    Examples:
      | actualnumber | expectednumber |
      | 0            | 1              |
      | 121          | 111            |
      | 2147483647   | 2147447412     |
      | -2147483648  | 2147447412     |

  @api
  Scenario: User inputs an integer exceeding range
    Given user passes a number "123456879522" in the request
    Then the status code is "400"
    And response is "Invalid value passed."