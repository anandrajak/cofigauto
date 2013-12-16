package com.cofigauto.internal.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.AutomationCommand;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.TestStatus;
import com.cofigauto.model.ValidTestStatus;

/**
 */
@AutomationCommand(name = "BROWSE_BACK")
public class BrowseBack implements ActionCommand {

    /**
     * slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(BrowseBack.class);

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
        LOG.info("Executing BROWSE BACK for step");
        try {
            LOG.info("Executing step:- " + step);
            context.getDriver().navigate().back();
            status.setStatusDesc("back to page with title '"
                    + context.getDriver().getTitle() + "'");
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
