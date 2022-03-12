package com.inpost.com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-json.json"},
        glue = "com.inpost.com.steps",
        features = "src/test/resources/features")

public class Runner {
}
