package com.cofigauto.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.ActionCommandFactory;
import com.cofigauto.model.AutomationTestCase;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.AutomationTestSuite;
import com.cofigauto.model.TestStatus;
import com.cofigauto.model.ValidTestStatus;

/**
 * @author Vinay Sharma
 * @version 1.1
 */
public abstract class AbstractTestSuitRunner implements TestSuitRunner {

    /**
     * Slf4j Logger instance.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractTestSuitRunner.class);

    /**
     * Runs test suit.
     * 
     * @param suit
     *            AutomationTestSuite
     * @return AutomationTestSuite with updated status.
     */
    final void runTestSuit(final AutomationTestSuite suit) {
        for (AutomationTestCase testCase : suit.getTests()) {
            this.runTestCase(testCase);
        }
    }

    /**
     * Runs test suit.
     * 
     * @param testCase
     *            AutomationTestCase
     */
    private void runTestCase(final AutomationTestCase testCase) {
        TestCaseContext.TestCaseContextBuilder builder = null;
        TestCaseContext context = null;
        ValidTestStatus testCaseStatus = ValidTestStatus.NOT_RUN;
        try {
            builder = new TestCaseContext.TestCaseContextBuilder(testCase);
            context = builder.getTestCaseContext();
            for (AutomationTestCaseStep step : testCase.getSteps()) {
                LOGGER.info("Executing step:- " + step);
                try {
                    ActionCommand command = ActionCommandFactory
                            .getActionCommand(step.getAction());
                    TestStatus status = null;
                    if (command != null) {
                        status = command.execute(step, context);
                    } else {
                        status = new TestStatus();
                        step.setStatus(status);
                        step.getStatus().setStatus(ValidTestStatus.FAIL);
                        step.getStatus()
                                .setStatusDesc("Command not registered");
                    }
                    LOGGER.debug(status.toString());
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                    step.setStatus(new TestStatus());
                    step.getStatus().setStatus(ValidTestStatus.FAIL);
                    step.getStatus().setStatusDesc(
                            "Exception Occurred :- " + e.getMessage());
                    LOGGER.debug(step.getStatus().toString());
                }

                if (step.getStatus().getStatus().equals(ValidTestStatus.FAIL)) {
                    if (step.isFailTestCaseIfFails()) {
                        testCaseStatus = ValidTestStatus.FAIL;
                    }
                    if (step.isExitOnFail()) {
                        break;
                    }
                }

                context.processWindowData();
            }
        } catch (Exception e) {
            LOGGER.error("Exception Occurred in running TestCase", e);
            testCaseStatus = ValidTestStatus.FAIL;
        } finally {
            if (null != context && null != context.getDriver()
                    && testCase.isCloseBrowserOnExit()) {
                context.getDriver().quit();
            }
        }

        if (testCaseStatus != ValidTestStatus.FAIL) {
            testCaseStatus = ValidTestStatus.PASS;
        }

        testCase.setStatus(testCaseStatus);

    }

}
