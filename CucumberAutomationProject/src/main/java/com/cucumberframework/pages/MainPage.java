package com.cucumberframework.pages;

import com.cucumberframework.factory.WebDriverFactory;

public class MainPage extends WebDriverFactory{

	public static String logo_IMG = "//img[@class='logo img-responsive']~XPATH";
	public static String search_BOX = "search_query_top-ID";
	public static String search_BTN = "submit_search-NAME"; 
	public static String dresses_BTN = "//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]~XPATH";
	public static String tshirts_BTN = "//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]~XPATH";
	public static String signin_BTN = "//a[@title='Log in to your customer account']~XPATH";
	
		/*
			//Page Repository using Page Factory
			@FindBy(xpath="//img[@class='logo img-responsive']")
			public static WebElement logo;
		
			@FindBy(id="search_query_top")
			WebElement search_BOX;
			
			@FindBy(name="submit_search")
			WebElement search_BTN;
			
			@FindBy(xpath="//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
			WebElement dresses_BTN;
		
			@FindBy(xpath="//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]")
			WebElement tshirts_BTN;
			
			@FindBy(xpath="//a[@title='Log in to your customer account']")
			WebElement signin_BTN;
			
			//Initializing the Page Objects
			public MainPage() {
				PageFactory.initElements(driver, this);
			}
		*/
}
