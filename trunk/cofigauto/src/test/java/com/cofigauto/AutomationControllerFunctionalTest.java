package com.cofigauto;

import org.junit.Test;
import org.reflections.util.ClasspathHelper;

/**
 */
public class AutomationControllerFunctionalTest {
	/*private static final Logger LOG = LoggerFactory.getLogger(AutomationTestSuiteTest.class);
*/

	@Test
	public void testAutomationController() {
		AutomationController.runTestSuite(ClasspathHelper.getContextClassLoader().getResource("Test_Scenarios.xls").getPath());
	}

}
