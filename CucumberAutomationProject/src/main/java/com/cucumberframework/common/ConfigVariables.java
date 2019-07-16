package com.cucumberframework.common;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigVariables {
	private static Logger logger = LogManager.getLogger(ConfigVariables.class);
	public static String url;
	public static String breakPoint;
	public static String browser;
	public static String platform;
	public static String usname;
	public static String paword;
	public static String version;
	public static String driverPath;
	public static String os;
    public static String headlessBrowser;
    public static String deviceName;
    public static String UDID;
    public static String appiumServerUrl;
    public static String waitTimeInSeconds;
	
	public ConfigVariables() {
	}
	
	public void init(Properties prop) {
		url = readProperty(prop, "url");
		breakPoint = readProperty(prop, "breakPoint");
		browser = readProperty(prop, "browser");
		headlessBrowser = readProperty(prop, "headlessBrowser");
		platform = readProperty(prop, "platform");
		usname = readProperty(prop, "usname");
		paword = readProperty(prop, "paword");
		version = readProperty(prop, "version");
		driverPath = readProperty(prop, "driverPath");
		os = readProperty(prop, "os");
		waitTimeInSeconds = readProperty(prop, "waitTimeInSeconds");
		deviceName = readProperty(prop, "deviceName");
		UDID = readProperty(prop, "UDID");
		appiumServerUrl = readProperty(prop, "appiumServerUrl");
		logger.info("All the properties values are initialized");
	}
	

	public String readProperty(Properties prop, String key) {
			return prop.getProperty(key);
	}
	
}
