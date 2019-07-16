package com.cucumberframework.steplibrary;

import org.testng.Assert;

import com.cucumberframework.common.CommonLibrary;
import com.cucumberframework.common.ConfigVariables;
import com.cucumberframework.pages.MainPage;

public class MainPageLibrary extends CommonLibrary {

	public static void verifyMainPage() {

		try {
			if (ConfigVariables.breakPoint.equalsIgnoreCase("Mobile")) {
				System.out.println("Identify the Mobile Element and find it");
			} else {
				findElement(MainPage.logo_IMG);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyMainLogo() {
		Boolean logoDisplay = isElementDisplayed(MainPage.logo_IMG);
		Assert.assertTrue(logoDisplay);
	}

	public static void verifyScreenTitle() {
		String MainPageTitle = getTitle();
		Assert.assertEquals(MainPageTitle, "My Store");
	}

}
