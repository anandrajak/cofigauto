package com.cofigauto.internal.command;

import org.apache.commons.lang.StringUtils;
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
@AutomationCommand(name = "VERIFY_TITLE")
public class VerifyTitle implements ActionCommand {

    /**
     * slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(VerifyTitle.class);

    /*
     * (non-Javadoc)
     *
     * @see com.automation.internal.ActionCommand#execute(com.automation.model.
     * AutomationTestCaseStep, com.automation.TestCaseContext)
     */
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
        LOG.info("Executing VERIFY TITLE for step");

        try {
            String title = context.getDriver().getTitle();

            if (StringUtils.isBlank(step.getData())) {
                LOG.error("Cannot verify title as nothing entered for "
                        + "comparison on data column of sheet.");
                status.setStatus(ValidTestStatus.FAIL);
                status.setStatusDesc("Cannot verify title as nothing entered "
                        + "for comparison on data column of sheet.");
            } else if (!step.getData().equals(title)) {
                LOG.warn("Title comparison failed. found '" + title
                        + "' expected was '" + step.getData() + "'");
                status.setStatus(ValidTestStatus.FAIL);
                status.setStatusDesc("Title comparison failed. found '" + title
                        + "' expected was '" + step.getData() + "'");
            } else if (step.getData().equals(title)) {
                status.setStatus(ValidTestStatus.PASS);
                status.setStatusDesc("Title comparison SUCCESSFULL");
            }

        } catch (Exception e) {
            LOG.error("Exception occured in verifying title", e);
            status.setStatus(ValidTestStatus.FAIL);
            status.setStatusDesc("Exception Occurred :-" + e.getMessage());
        }
        step.setStatus(status);
        return status;
    }

}
