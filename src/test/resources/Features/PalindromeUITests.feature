Feature: UI End-to-End tests for the ReactJS web app
  Description: The purpose of this feature file is to cover end to end UI test cases for a Palindrome program having input as an integer and string

  Background:
    Given user login to "http://localhost:3000" in chrome browser

  @ui
  Scenario Outline: User inputs value on the UI
    Given user passes <actualvalue> in the text box
    When clicks on Submit
    Then the browser displays the answer is <expectedvalue>
    And the browser is closed
    Examples:
      | actualvalue | expectedvalue |
      | 121         | 111           |
      | 2147483647  | 2147447412    |
      | -2147483648 | 2147447412    |
      | 0           | 1             |

  @ui
  Scenario: User inputs an integer exceeding range on the UI
    Given user passes a number "123456879526" in the text box
    When clicks on Submit
    Then the browser displays error message as "Invalid value passed."
    And the browser is closed+