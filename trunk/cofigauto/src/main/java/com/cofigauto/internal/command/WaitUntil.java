package com.cofigauto.internal.command;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.AutomationCommand;
import com.cofigauto.internal.IdentifierType;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.TestStatus;
import com.cofigauto.model.ValidTestStatus;
import com.google.common.base.Predicate;

/**
 */
@AutomationCommand(name = "WAIT_UNTIL")
public class WaitUntil implements ActionCommand {

    /**
     * slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(WaitUntil.class);

    /**
     * @author vsha28
     */
    final class TestCasePredicate implements Predicate<WebDriver> {
        /**
         * test case step.
         */
        private final AutomationTestCaseStep testCaseStep;

        /**
         * Constructor for TestCasePredicate.
         * 
         * @param automationTestCaseStep
         *            AutomationTestCaseStep
         */
        TestCasePredicate(final AutomationTestCaseStep automationTestCaseStep) {
            this.testCaseStep = automationTestCaseStep;
        }

        /**
         * Method apply.
         * 
         * @param driver
         *            WebDriver
         * @return boolean
         */
        @Override
        public boolean apply(final WebDriver driver) {

            WebElement element = null;
            boolean foundElement = false;
            try {
                element = IdentifierType.getElementForIdentifier(
                        testCaseStep.getIdentifierType(),
                        testCaseStep.getIdentifier(), testCaseStep.getData(),
                        driver);
            } catch (NoSuchElementException exp) {
                LOG.warn("Element not yet found. Identifier= '"
                        + testCaseStep.getIdentifier() + "'");
                foundElement = false;
            } catch (Exception e) {
                LOG.warn(
                        "Exception occurred in wait until condition. Exiting condition.",
                        e);
                foundElement = false;
            }
            if (element != null) {
                foundElement = true;
            }
            LOG.info("Checking condition in wait until ....... returning "
                    + foundElement);
            return foundElement;
        }
    }

    /**
     * Method execute.
     * 
     * @param step
     *            AutomationTestCaseStep
     * @param context
     *            TestCaseContext
     * @return TestStatus
     * @see com.cofigauto.internal.ActionCommand#execute(AutomationTestCaseStep,
     *      TestCaseContext)
     */
    @Override
    public final TestStatus execute(final AutomationTestCaseStep step,
            final TestCaseContext context) {
        TestStatus status = new TestStatus();
        LOG.info("Executing WAIT UNTIL for step");

        if (StringUtils.isNotBlank(step.getIdentifierType())
                && StringUtils.isNotBlank(step.getIdentifier())) {
            try {
                new WebDriverWait(context.getDriver(),
                        StringUtils.isNotBlank(step.getData()) ? Double
                                .valueOf(step.getData()).longValue() : 5, 1000)
                        .until(new TestCasePredicate(step));
                status.setStatus(ValidTestStatus.PASS);
            } catch (TimeoutException texp) {
                LOG.error("wait until Timed out. NOT FOUND Identifier= '"
                        + step.getIdentifier() + "'");
                status.setStatus(ValidTestStatus.FAIL);
                status.setStatusDesc("Element not found. Wait until Timed out.");
            } catch (Exception e) {
                LOG.error("Step FAILED. Exception occurred in step", e);
                status.setStatus(ValidTestStatus.FAIL);
                status.setStatusDesc("Exception Occurred :-" + e.getMessage());
            }

        } else {
            LOG.error("Step wrongly configured. Step FAILED.");
            status.setStatus(ValidTestStatus.FAIL);
            status.setStatusDesc("step wrongly configured. Identifier is blank");
        }
        step.setStatus(status);
        return status;
    }

}
