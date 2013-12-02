// $codepro.audit.disable unnecessaryImport
package com.cofigauto;

import java.io.File;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext.TestCaseContextBuilder;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.ActionCommandFactory;
import com.cofigauto.internal.TestStatus;
import com.cofigauto.internal.ValidTestStatus;
import com.cofigauto.model.AutomationTestCase;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.AutomationTestSuite;

/**
 * @author Vinay Sharma
 * @version 1.0
 */
public class AutomationController {

	/**
	 * 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AutomationController.class);

	/**
	 * Method runTestSuite.
	 * 
	 * @param excelPath
	 *            String
	 * @return AutomationTestSuite
	 */
	public static AutomationTestSuite runTestSuite(String excelPath) {
		AutomationTestSuite suite = null;
		TestCaseContextBuilder builder = null;
		TestCaseContext context = null;

		try {
			suite = new AutomationTestSuite(excelPath);
		} catch (Exception e) {
			LOG.error("Exception Occurred", e);
			System.exit(0);
		}

		for (AutomationTestCase testCase : suite.getTests()) {
			ValidTestStatus testCaseStatus = ValidTestStatus.NOT_RUN;
			try {
				builder = new TestCaseContextBuilder(testCase);
				context = builder.getTestCaseContext();
				for (AutomationTestCaseStep step : testCase.getSteps()) {
					LOG.info("Executing step:- " + step);
					try {
						ActionCommand command = ActionCommandFactory.getActionCommand(step.getAction());
						TestStatus status = null;
						if (command != null) {
							status = command.execute(step, context);
						} else {
							status = new TestStatus();
							step.setStatus(status);
							step.getStatus().setStatus(ValidTestStatus.FAIL);
							step.getStatus().setStatusDesc("Command not registered");
						}
						LOG.debug(status.toString());
					} catch (Exception e) {
						LOG.error(e.getMessage(), e);
						step.setStatus(new TestStatus());
						step.getStatus().setStatus(ValidTestStatus.FAIL);
						step.getStatus().setStatusDesc("Exception Occurred :- " + e.getMessage());
						LOG.debug(step.getStatus().toString());
					}

					if (step.getStatus().getStatus().equals(ValidTestStatus.FAIL)) {
						if (step.isFailTestCaseIfFails()) {
							testCaseStatus = ValidTestStatus.FAIL;
						}
						if (step.isExitOnFail()) {
							break;
						}
					}

					context.processWindowData();
				}
			} catch (Exception e) {
				LOG.error("Exception Occurred in running TestCase", e);
				testCaseStatus = ValidTestStatus.FAIL;
			} finally {
				if (null != context  && null != context.getDriver() && testCase.isCloseBrowserOnExit()) {
					context.getDriver().quit();
				}
			}

			if (testCaseStatus != ValidTestStatus.FAIL) {
				testCaseStatus = ValidTestStatus.PASS;
			}

			testCase.setStatus(testCaseStatus);
		}

		return suite;

	}

	/**
	 * Method main.
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
		try {
			final Options options = new Options();

			// add t option
			options.addOption("help", false, "Prints this");
			options.addOption("f", true, "Test suite excel path from root");
			options.addOption("e", true, "Browser drivers exe path");
			options.addOption("d", true, "Report directory");
			options.addOption("p", true, "Report name prefix");

			CommandLineParser parser = new BasicParser();

			CommandLine commandLine = parser.parse(options, args);
			String fileName = commandLine.getOptionValue("f");
			// String exeDriverPath = commandLine.getOptionValue("e");
			String reportDirectory = commandLine.getOptionValue("d");
			String reportPrefix = commandLine.getOptionValue("p");

			if (StringUtils.isBlank(fileName)) {
				fileName = "test_cases/Test_Scenarios.xls";
			}

			AutomationTestSuite suite = AutomationController.runTestSuite(fileName);

			final ReportBuilder reportBuilder = new ReportBuilder(reportDirectory, reportPrefix);

			LOG.warn("Report created at location '" + reportBuilder.buildReport(suite) + "'");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
