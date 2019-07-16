package com.cucumberframework.browseroption;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserOption extends BrowserOption {

	FirefoxOptions firfoxOption = new FirefoxOptions();

	@Override
	public void setHeadless(boolean value) {
		firfoxOption.setHeadless(value);
	}

	public FirefoxOptions build() {
		return firfoxOption;
	}

}
