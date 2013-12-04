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
@AutomationCommand(name = "SWITCH_WINDOW")
public class SwitchWindow implements ActionCommand {

    /**
     * slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(SwitchWindow.class);

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
        LOG.info("Executing SWITCH_WINDOW for step");
        if (step.getData() == null || step.getData().trim().equals("")) {
            LOG.error("No Window number provided for switching");
            status.setStatus(ValidTestStatus.FAIL);
            status.setStatusDesc("No Window number provided for switching");
        } else {
            try {
                LOG.info("Executing step:- " + step);

                int windowCount = Integer.parseInt(step.getData().trim());

                if (windowCount > context.getWindowCount()) {
                    LOG.error("Window count is greater than max count");
                    status.setStatus(ValidTestStatus.FAIL);
                    status.setStatusDesc("Window count is greater than "
                    + "max count");
                } else {
                    String windowHandle = context
                            .getWindowHandleByNumber(windowCount);
                    context.getDriver().switchTo().window(windowHandle);

                    status.setStatusDesc("Switched to window with title '"
                            + context.getDriver().getTitle() + "'");
                    status.setStatus(ValidTestStatus.PASS);
                }
            } catch (Exception e) {
                LOG.error("Exception occurred in SWITCH_WINDOW", e);
                status.setStatus(ValidTestStatus.FAIL);
                status.setStatusDesc("Exception Occurred :-" + e.getMessage());
            }
        }
        step.setStatus(status);
        return status;
    }

}
