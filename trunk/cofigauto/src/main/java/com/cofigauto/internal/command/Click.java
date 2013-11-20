package com.cofigauto.internal.command;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.AutomationCommand;
import com.cofigauto.internal.IdentifierType;
import com.cofigauto.internal.TestStatus;
import com.cofigauto.internal.ValidTestStatus;
import com.cofigauto.model.AutomationTestCaseStep;

/**
 * @author Vinay Sharma
 * 
 * @version $Revision: 1.0 $
 */
@AutomationCommand(name = "CLICK")
public class Click implements ActionCommand {

	private static Logger LOG = LoggerFactory.getLogger(Click.class);

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
		WebElement element = null;
		try {
			element = IdentifierType.getElementForIdentifier(step.getIdentifierType(), step.getIdentifier(),
					step.getData(), context.getDriver());
			if (element != null) {
				element.click();
				status.setStatus(ValidTestStatus.PASS);
			} else {
				status.setStatus(ValidTestStatus.FAIL);
				status.setStatusDesc("Element not found");
			}
		} catch (NoSuchElementException exp) {
			LOG.error("Element not found. Identifier= '" + step.getIdentifier() + "'");
			status.setStatus(ValidTestStatus.FAIL);
			status.setStatusDesc("Element not found");
		} catch (Exception e) {
			LOG.error("Exception occurred", e);
			status.setStatus(ValidTestStatus.FAIL);
			status.setStatusDesc("Exception Occurred :-" + e.getMessage());
		}
		step.setStatus(status);
		return status;
	}

}
