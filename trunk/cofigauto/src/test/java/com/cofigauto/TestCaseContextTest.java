package com.cofigauto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * The class <code>TestCaseContextTest</code> contains tests for the class <code>{@link TestCaseContext}</code>.
 *
 * @generatedBy CodePro at 9/11/13 11:18 AM
 * @author vsha28
 * @version $Revision: 1.0 $
 */
public class TestCaseContextTest {
	/**
	 * Run the TestCaseContext() constructor test.
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testTestCaseContext_1()
		throws Exception {
		TestCaseContext result = new TestCaseContext();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the RemoteWebDriver getDriver() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testGetDriver_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		RemoteWebDriver result = fixture.getDriver();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String getMasterWindowHandle() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testGetMasterWindowHandle_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		String result = fixture.getMasterWindowHandle();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int getWindowCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testGetWindowCount_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		int result = fixture.getWindowCount();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the String getWindowHandleByNumber(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testGetWindowHandleByNumber_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		int number = 1;

		String result = fixture.getWindowHandleByNumber(number);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the int getWindowNumberByHandle(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testGetWindowNumberByHandle_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		String handle = "";

		int result = fixture.getWindowNumberByHandle(handle);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int getWindowNumberByHandle(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testGetWindowNumberByHandle_2()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		String handle = "";

		int result = fixture.getWindowNumberByHandle(handle);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the void processWindowClose(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowClose_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		int number = 1;

		fixture.processWindowClose(number);

		// add additional test code here
	}

	/**
	 * Run the void processWindowClose(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowClose_2()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		int number = 1;

		fixture.processWindowClose(number);

		// add additional test code here
	}

	/**
	 * Run the void processWindowClose(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowClose_3()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		int number = 1;

		fixture.processWindowClose(number);

		// add additional test code here
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_2()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_3()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_4()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_5()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_6()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_7()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_8()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_9()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_10()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_11()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_12()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_13()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_14()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_15()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void processWindowData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testProcessWindowData_16()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");

		fixture.processWindowData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.TestCaseContext.processWindowData(TestCaseContext.java:99)
	}

	/**
	 * Run the void setMasterWindowHandle(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Test
	public void testSetMasterWindowHandle_1()
		throws Exception {
		TestCaseContext fixture = new TestCaseContext();
		fixture.setMasterWindowHandle("");
		String masterWindowHandle = "";

		fixture.setMasterWindowHandle(masterWindowHandle);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 9/11/13 11:18 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TestCaseContextTest.class);
	}
}