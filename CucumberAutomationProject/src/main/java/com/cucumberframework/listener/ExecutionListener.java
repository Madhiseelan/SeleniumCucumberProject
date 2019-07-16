package com.cucumberframework.listener;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IExecutionListener;

import com.cucumberframework.common.ConfigVariables;
import com.cucumberframework.util.LoadPropertyConfiguration;

public class ExecutionListener implements IExecutionListener {
	private static Logger logger = LogManager.getLogger(ExecutionListener.class);
	protected static Properties prop;

	public void onExecutionStart() {
		logger.info("Loading and Initializing properties file...");

		try {
			prop = LoadPropertyConfiguration.initializeConfigurationFromFile(
					System.getProperty("user.dir") + "/src/test/resources/config.properties");
		} catch (Exception e) {
			logger.info("Error in Loading properties file.." + System.getProperty("user.dir")
					+ "/src/test/resources/config.properties");
			logger.error(e.getMessage());
		}

		new ConfigVariables().init(prop);
		logger.info("Test Execution start method is completed");

		/*
		 * try { prop =
		 * LoadPropertyConfiguration.initializeConfigurationFromFile(System.getProperty("user.dir") + "/src/test/resources/config.properties"); } 
		 * catch (IOException | PropertyNotFoundException e) {
		 * 		logger.info("Error in Loading properties file....." +
		 * 				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		 * logger.error(e.getMessage()); } new ConfigVariables().init(prop);
		 * logger.info("Execution start method is completed");
		 */

	}

	public void onExecutionFinish() {
		logger.info("Start creating all cucumber reports"); 
		
		/* 
		 * try {
		 * 			GenerateTestReport.generateCucumberCoverageOverviewReport();
		 * 			GenerateTestReport.generateCucumberUsageReport();
		 * 			GenerateTestReport.generateCucumberChartReport();
		 * 			GenerateTestReport.generateCucumberResultsOverviewReport();
		 * 			GenerateTestReport.generateCucumberDetailedResultsReport();
		 * 			GenerateTestReport.generateCucumberFeatureOverviewReport();
		 * 			GenerateTestReport.generateCucumberJVMReport();
		 * 			GenerateTestReport.openCucumberHtmlReport();
		 * 		logger.info("All the cucumber report creation is completed"); 
		 * } catch (Exception e) { logger.info("Errors in creating cucucmber reports");
		 * 		logger.error(e.getMessage()); }
		 */
	}

}
