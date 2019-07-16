package com.cucumberframework.common;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumberframework.exception.InvalidLocatorStrategyException;
import com.cucumberframework.factory.WebDriverFactory;

public class CommonLibrary extends WebDriverFactory {
	private static Logger logger = LogManager.getLogger(CommonLibrary.class);

	public static WebElement findElement(String locator) {
		By by = null;
		try {
			by = find(locator);
		} catch (Exception e) {
			logger.error(e);
			Assert.assertTrue(false, e.getMessage());
		}
		return driver.findElement(by);
	}

	public static String getTitle() {
		String title = null;

		try {
			title = driver.getTitle();
		} catch (Exception e) {
			Assert.assertTrue(false, e.getMessage());
		}
		return title;
	}

	public static void openUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.assertTrue(false, e.getMessage());
		}
	}

	public static boolean isElementDisplayed(String locator) {
		boolean isElementDisplayed = false;
		By by = null;
		try {
			by = find(locator);
			isElementDisplayed = driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue(false, e.getMessage());
		}
		return isElementDisplayed;
	}

	public static By find(String locator) {
		String actualLocator = null;
		By by = null;

		actualLocator = StringUtils.substringBefore(locator, "~");
		LocatorType locatorType = LocatorType.valueOf(StringUtils.substringAfter(locator, "~").toUpperCase());

		WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(ConfigVariables.waitTimeInSeconds));

		try {
			switch (locatorType) {
			case ID:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(actualLocator)));
				by = By.id(actualLocator);
				break;
			case XPATH:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(actualLocator)));
				by = By.xpath(actualLocator);
				break;
			case NAME:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(actualLocator)));
				by = By.name(actualLocator);
				break;
			case TAG_NAME:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(actualLocator)));
				by = By.tagName(actualLocator);
				break;
			case CSS:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(actualLocator)));
				by = By.cssSelector(actualLocator);
				break;
			case CLASS_NAME:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(actualLocator)));
				by = By.className(actualLocator);
				break;
			case LINK_TEXT:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(actualLocator)));
				by = By.linkText(actualLocator);
				break;
			case PARTIAL_LINK_TEXT:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(actualLocator)));
				by = By.partialLinkText(actualLocator);
				break;
			default:
				throw new InvalidLocatorStrategyException("Unknown locator type '" + locatorType + "'");
			}
			logger.info("Locator identified successfully..!!!!");
			highlightWebElement(driver.findElement(by));
		} catch (Exception e) {
			logger.error(e);
			Assert.assertTrue(false, e.getMessage());
		}

		return by;
	}

	public static void highlightWebElement(WebElement webElement) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
					"color: black; border: 4px solid red;");
		} catch (Exception e) {
			logger.error(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}

	enum LocatorType {
		ID, XPATH, NAME, TAG_NAME, CSS, CLASS_NAME, LINK_TEXT, PARTIAL_LINK_TEXT
	}

}
