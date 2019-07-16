package com.cucumberframework.browseroption;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserOption extends BrowserOption {

	ChromeOptions chromeOption = new ChromeOptions();
	
	@Override
    public void setHeadless(boolean value) {
		chromeOption.setHeadless(value);
    }

    public ChromeOptions build() {
    	return chromeOption;
    }
	
}
