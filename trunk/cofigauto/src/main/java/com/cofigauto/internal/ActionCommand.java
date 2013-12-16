package com.cofigauto.internal;

import com.cofigauto.TestCaseContext;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.TestStatus;

/**
 */
public interface ActionCommand {
    /**
     * Method execute. Executes step, updates status in it and returns status.
     * 
     * @param step
     *            AutomationTestCaseStep
     * @param context
     *            TestCaseContext
     * @return TestStatus
     */
    TestStatus execute(AutomationTestCaseStep step, TestCaseContext context);
}
