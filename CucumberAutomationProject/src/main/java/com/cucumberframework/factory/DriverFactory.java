package com.cucumberframework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverFactory 
{
	WebDriver createDriver(DesiredCapabilities caps);
	WebDriver getDriver();
}
