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
 */
@AutomationCommand(name = "BROWSE_BACK")
public class BrowseBack implements ActionCommand {

	private static final Logger LOG = LoggerFactory.getLogger(BrowseBack.class);

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
		LOG.info("Executing BROWSE BACK for step");
		try {
			LOG.info("Executing step:- " + step);
			context.getDriver().navigate().back();
			status.setStatusDesc("back to page with title '" + context.getDriver().getTitle() + "'");
			status.setStatus(ValidTestStatus.PASS);
		} catch (Exception e) {
			LOG.error("Exception occurred in browser back", e);
			status.setStatus(ValidTestStatus.FAIL);
			status.setStatusDesc("Exception Occurred :-" + e.getMessage());
		}
		step.setStatus(status);
		return status;
	}

}