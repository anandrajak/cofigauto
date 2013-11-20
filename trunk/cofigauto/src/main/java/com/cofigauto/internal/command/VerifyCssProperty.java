/**
 * 
 */
package com.cofigauto.internal.command;

import org.apache.commons.lang.StringUtils;
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
@AutomationCommand(name = "VERIFY_CSS_PROPERTY")
public class VerifyCssProperty implements ActionCommand {

	private static final Logger LOG = LoggerFactory.getLogger(VerifyCssProperty.class);

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
		try {
			WebElement element = null;
			String[] nameValuePair;
			String name = null;
			String value = null;
			if (StringUtils.isNotBlank(step.getData())) {
				nameValuePair = step.getData().split("=");

				if (nameValuePair != null && nameValuePair.length == 2) {
					name = nameValuePair[0];
					value = nameValuePair[1];
				}
			}

			if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)) {
				element = IdentifierType.getElementForIdentifier(step.getIdentifierType(), step.getIdentifier(),
						step.getData(), context.getDriver());
				if (element != null) {
					String attributeValue = element.getCssValue(name);

					if (StringUtils.isNotBlank(attributeValue) && attributeValue.equals(value)) {
						status.setStatus(ValidTestStatus.PASS);
					} else {
						status.setStatus(ValidTestStatus.FAIL);
						status.setStatusDesc("Got css property value '" + attributeValue + "'. Expected was '" + value
								+ "'. property name '" + name + "'");
					}
				} else {
					status.setStatus(ValidTestStatus.FAIL);
					status.setStatusDesc("Element not found");
				}
			} else {
				status.setStatus(ValidTestStatus.FAIL);
				status.setStatusDesc("property name and value not provided in data section. valid format is 'name=value'");
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
