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
@AutomationCommand(name = "SWITCH_TO_MAIN_WINDOW")
public class SwitchToMainWindow implements ActionCommand {

    /**
     * slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(SwitchToMainWindow.class);

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
        LOG.info("Executing SWITCH_TO_MAIN_WINDOW for step");

        try {
            LOG.info("Executing step:- " + step);
            LOG.info("Master window handle is:- "
                    + context.getMasterWindowHandle());
            // LOG.info("Current window handle is:- " +
            // context.getDriver().getWindowHandle());

            for (String str : context.getDriver().getWindowHandles()) {
                LOG.info("window handle is:- " + str);
            }

            context.getDriver().switchTo()
                    .window(context.getMasterWindowHandle());
            status.setStatus(ValidTestStatus.PASS);
            status.setStatusDesc("Switched to main window with title '"
                    + context.getDriver().getTitle() + "'");
        } catch (Exception e) {
            LOG.error("Exception occurred in SWITCH_TO_MAIN_WINDOW", e);
            status.setStatus(ValidTestStatus.FAIL);
            status.setStatusDesc("Exception Occurred :-" + e.getMessage());
        }

        step.setStatus(status);
        return status;
    }

}
