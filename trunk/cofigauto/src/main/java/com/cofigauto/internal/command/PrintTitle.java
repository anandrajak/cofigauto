/**
 * 
 */
package com.cofigauto.internal.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.AutomationCommand;
import com.cofigauto.internal.TestStatus;
import com.cofigauto.internal.ValidTestStatus;
import com.cofigauto.model.AutomationTestCaseStep;

/**
 * @author Vinay Sharma
 * 
 * @version $Revision: 1.0 $
 */
@AutomationCommand(name = "PRINT_TITLE")
public class PrintTitle implements ActionCommand {

	private static final Logger LOG = LoggerFactory.getLogger(PrintTitle.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.automation.internal.ActionCommand#execute(com.automation.model.
	 * AutomationTestCaseStep, com.automation.TestCaseContext)
	 */
	/**
	 * Method execute.
	 * @param step AutomationTestCaseStep
	 * @param context TestCaseContext
	 * @return TestStatus
	 * @see com.cofigauto.internal.ActionCommand#execute(AutomationTestCaseStep, TestCaseContext)
	 */
	@Override
	public TestStatus execute(AutomationTestCaseStep step, TestCaseContext context) {
		TestStatus status = new TestStatus();
		LOG.info("Executing PRINT_TITLE for step");

		try {
			String title = context.getDriver().getTitle();

			status.setStatusDesc(title);
			status.setStatus(ValidTestStatus.PASS);
		} catch (Exception e) {
			LOG.error("Exception occured in verifying title", e);
			status.setStatus(ValidTestStatus.FAIL);
			status.setStatusDesc("Exception Occurred :-" + e.getMessage());
		}
		step.setStatus(status);
		return status;
	}

}
