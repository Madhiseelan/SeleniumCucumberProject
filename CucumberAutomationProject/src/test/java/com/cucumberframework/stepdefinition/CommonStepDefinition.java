package com.cucumberframework.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumberframework.builder.WebCapabilitiesBuilder;
import com.cucumberframework.common.CommonLibrary;
import com.cucumberframework.common.ConfigVariables;
import com.cucumberframework.factory.WebDriverFactory;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.Scenario;

public class CommonStepDefinition {
		protected static WebDriver driver;
	    protected DesiredCapabilities caps;
	    private static Logger logger = LogManager.getLogger(CommonStepDefinition.class);
	    protected static Properties prop;
	    public ConfigVariables configVariable;

	    @Before
	    public void beforeScenario() throws Exception {
			logger.info("Test execution start method");
			caps = new WebCapabilitiesBuilder().addBrowser(ConfigVariables.browser).addBrowserDriverExecutablePath(System.getProperty("user.dir") + File.separator + ConfigVariables.driverPath)
				.addVersion(ConfigVariables.version).addPlatform(ConfigVariables.platform).build();
			
			driver = new WebDriverFactory().createDriver(caps);
			CommonLibrary.openUrl(ConfigVariables.url);
			
			if (!ConfigVariables.breakPoint.equalsIgnoreCase("Mobile")) {
			    driver.manage().window().maximize();
			}
			driver.manage().deleteAllCookies();
	    }

	    @After
	    public void afterScenario(Scenario scenario) throws InterruptedException, IOException {
		if (scenario.isFailed()) {
		    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.embed(screenshot, "image/png");
		}
		
		driver.close();
		driver.quit();
	    }
	}

