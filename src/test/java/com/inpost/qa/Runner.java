package com.inpost.qa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        glue = "com.inpost.qa.steps",
        features = "src/test/resources/features/",
        stepNotifications = true)
public class Runner {

}
