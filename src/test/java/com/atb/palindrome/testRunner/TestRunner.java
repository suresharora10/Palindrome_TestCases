package com.atb.palindrome.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"com.atb.palindrome.stepDefinitions"},
        tags = "@ui or @api",
        plugin = {"pretty"},
        monochrome = true)
public class TestRunner {

}

