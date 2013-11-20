package com.cofigauto;

import org.junit.Test;

import com.cofigauto.AutomationController;

/**
 */
public class AutomationControllerFunctionalTest {
	/*private static final Logger LOG = LoggerFactory.getLogger(AutomationTestSuiteTest.class);
*/

	@Test
	public void testAutomationController() {
		AutomationController.runTestSuite("\\Users\\vsha28\\workspace\\ps\\src\\test\\resources\\Test_Scenarios.xls");
	}

}
