package com.cucumberframework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
		glue ="com/cucumberframework/stepdefinition",
		features = "src/test/java/com/cucumberframework/featurefiles",
		plugin = { "html:target/cucumber-htmlreport", "json:target/cucumber-report.json", "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json" },
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{

		
}
