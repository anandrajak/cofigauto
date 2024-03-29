package com.cofigauto.internal.command;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.TestCaseContext;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.AutomationCommand;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.TestStatus;
import com.cofigauto.model.ValidTestStatus;

/**
 * @author Vinay Sharma
 * 
 * @version $Revision: 1.0 $
 */
@AutomationCommand(
    name = "WAIT")
public class Wait implements ActionCommand {

  /**
   * slf4j Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(Wait.class);

  /**
   * Default wait time.
   */
  private static final long DEFAULT_WAIT = 5000;

  /**
   * Milliseconds in a second.
   */
  private static final long MILLI_SECONDS_IN_SECOND = 1000;

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
   *          AutomationTestCaseStep
   * @param context
   *          TestCaseContext
   * @return TestStatus
   * @see com.cofigauto.internal.ActionCommand#execute(AutomationTestCaseStep,
   *      TestCaseContext)
   */
  @Override
  public final TestStatus execute(final AutomationTestCaseStep step,
      final TestCaseContext context) {
    TestStatus status = new TestStatus();
    LOG.info("Executing WAIT for step");
    try {
      LOG.info("Starting Wait ..... ");
      /*
       * new WebDriverWait(context.getDriver(),
       * StringUtils.isNotBlank(step.getData()) ? Double.valueOf(
       * step.getData()).longValue() : 5, 1000);
       */
      long waitTime = DEFAULT_WAIT;

      if (StringUtils.isNotBlank(step.getData())) {
        waitTime = Double.valueOf(step.getData()).longValue()
            * MILLI_SECONDS_IN_SECOND;
      }
      LOG.info("Wait time is " + waitTime);
      Thread.sleep(waitTime);
      LOG.info("Wait time over");
      status.setStatus(ValidTestStatus.PASS);

    } catch (Exception e) {
      LOG.error("Exception occurred in wait. Exiting wait. ", e);
      status.setStatus(ValidTestStatus.FAIL);
      status.setStatusDesc("Exception Occurred :-" + e.getMessage());
    }
    step.setStatus(status);
    return status;
  }

}
