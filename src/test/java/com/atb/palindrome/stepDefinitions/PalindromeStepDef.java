package com.atb.palindrome.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PalindromeStepDef {
    WebDriver d;
    private static final String BASE_URL = "http://localhost:8080/";
    private static Response response;
    private static RequestSpecification request;

    /**
     * This method is used to login to chrome browser and maxmize the browser window size.
     *
     * @param url - String
     */
    @Given("user login to {string} in chrome browser")
    public void user_login_to_in_chrome_browser(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        d = new ChromeDriver(chromeOptions);
        d.get(url);
        d.manage().window().maximize();
    }

    /**
     * This method is used to pass the input in the text box on UI
     *
     * @param actualValue int
     */
    @Given("user passes {int} in the text box")
    public void user_passes_in_the_text_box(int actualValue) {
        d.findElement(By.xpath("//input[@role='region']")).sendKeys(String.valueOf(actualValue));
    }

    /**
     * This method is used to accept input number exceeding the int range and validate the error message is Invalid value passed.
     *
     * @param actualValue String
     */
    @Given("user passes a number {string} in the text box")
    public void userPassesANumberInTheTextBox(String actualValue) {
        d.findElement(By.xpath("//input[@role='region']")).sendKeys(actualValue);
    }


    /**
     * This method is used to click on submit button after user inputs the value in the text box
     */
    @When("clicks on Submit")
    public void clicks_on_submit() {
        d.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    }

    /**
     * This method is used to close the chrome browser
     */
    @Then("the browser is closed")
    public void theBrowserIsClosed() {
        d.quit();
    }

    /**
     * This method is used to fetch the value from the UI and verify it matches with the expected value
     *
     * @param expectedValue int
     */
    @Then("the browser displays the answer is {int}")
    public void theBrowserDisplaysTheAnswerIsExpectedvalue(Integer expectedValue) {
        Integer valueOnUI = Integer.valueOf(d.findElement(By.xpath("//div[@class='App']/div/p")).getText());
        Assert.assertEquals(expectedValue, valueOnUI);
    }

    /**
     * This method is used to fetch the value from the UI and verify the error message matches with the expected value
     *
     * @param actualValue - String
     */
    @Then("the browser displays error message as {string}")
    public void theBrowserDisplaysErrorMessageAs(String actualValue) {

        d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String valueOnUI = d.findElement(By.xpath("//div[@class='error']")).getText();
        Assert.assertEquals(actualValue, valueOnUI);
    }

    /**
     * This method is used to fetch the base url and stores the response from the get request
     */
    @Given("the api server is running")
    public void the_api_server_is_running() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(BASE_URL);
    }

    /**
     * This method is used to create a response with the input value passed in the url
     *
     * @param actualNumber int
     */
    @Given("user passes {int}")
    public void user_passes(Integer actualNumber) {
        String customURL = BASE_URL + "palindrome/" + actualNumber;
        response = request.get(customURL);
    }

    /**
     * This method is used to validate the status code passed and fetched from the response is same
     *
     * @param actualStatusCode String
     */
    @Then("the status code is {string}")
    public void the_status_code_is(String actualStatusCode) {
        String expectedStatusCode = String.valueOf(response.getStatusCode());
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    /**
     * This method is used to validate the expectedNumber is matching the value coming from the response
     *
     * @param expectedNumber int
     */
    @Then("the result of program is {int}")
    public void the_result_of_program_is(Integer expectedNumber) {
        String expectedResponseNumber = response.asString();
        Assert.assertEquals(expectedResponseNumber, expectedNumber.toString());
    }

    /**
     * This method is to validate that the actualValue (Hello World / Invalid value passed) is matching the response value
     *
     * @param actualValue String
     */
    @And("response is {string}")
    public void responseIs(String actualValue) {
        String expectedResponseValue = response.asString();
        Assert.assertEquals(expectedResponseValue, actualValue);
    }

    /**
     * This method is used to create a response with the input value passed in the url
     *
     * @param actualValue String
     */
    @Given("user passes a number {string} in the request")
    public void userPassesANumberInTheRequest(String actualValue) {
        String customURL = BASE_URL + "palindrome/" + actualValue;
        response = request.get(customURL);
    }

}
