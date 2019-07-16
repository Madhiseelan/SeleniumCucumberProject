package com.cucumberframework.stepdefinition;

import com.cucumberframework.steplibrary.MainPageLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainPageStepDefinition{
	String mainPageTitle = null;
	
	@Given("^The user is on the Home page$")
	public void The_user_is_on_the_Home_page() {
		MainPageLibrary.verifyMainPage();
	}

	@When("^User verifies the Logo of the page$")
	public void User_verifies_the_Logo_of_the_page() {
		MainPageLibrary.verifyMainLogo();
	}

	@Then("^User verifies the title of the page$")
	public void User_verifies_the_title_of_the_page() {
		MainPageLibrary.verifyScreenTitle();
	}
}
