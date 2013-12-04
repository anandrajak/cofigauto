package com.cofigauto.internal;

import com.cofigauto.TestCaseContext;
import com.cofigauto.model.AutomationTestCaseStep;

/**
 */
public interface ActionCommand {
  /**
   * Method execute.
   * 
   * @param step
   *          AutomationTestCaseStep
   * @param context
   *          TestCaseContext
   * @return TestStatus
   */
  TestStatus execute(AutomationTestCaseStep step, TestCaseContext context);
}
