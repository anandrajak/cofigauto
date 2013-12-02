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
@AutomationCommand(name = "LAUNCH")
public class Launch implements ActionCommand {

    /**
     * slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Launch.class);

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
        LOG.info("Executing LAUNCH for step");
        try {
            if ((StringUtils.isBlank(step.getIdentifierType()) || step
                    .getIdentifierType().equalsIgnoreCase("URL"))
                    && StringUtils.isNotBlank(step.getIdentifier())) {
                context.getDriver().get(step.getIdentifier());
                status.setStatus(ValidTestStatus.PASS);
            } else {
                LOG.error("Step wrongly configured. Step FAILED.");
                status.setStatus(ValidTestStatus.FAIL);
                status.setStatusDesc("Step wrongly configured. Either identifier is blank or identifier type is not URL(type can be left blank)");
            }
        } catch (Exception e) {
            LOG.error("Exception Occurred in LAUNCH of step :- " + step, e);
            status.setStatus(ValidTestStatus.FAIL);
            status.setStatusDesc("Exception Occurred :-" + e.getMessage());
        }
        step.setStatus(status);
        context.setMasterWindowHandle(context.getDriver().getWindowHandle());
        return status;
    }

}
