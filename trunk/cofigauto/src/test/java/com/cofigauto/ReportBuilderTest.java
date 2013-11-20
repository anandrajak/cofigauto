package com.cofigauto;

import org.junit.*;
import static org.junit.Assert.*;

import com.cofigauto.ReportBuilder;
import com.cofigauto.exception.ToolRuntimeException;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.AutomationTestSuite;

/**
 * The class <code>ReportBuilderTest</code> contains tests for the class <code>{@link ReportBuilder}</code>.
 *
 * @generatedBy CodePro at 9/11/13 11:16 AM
 * @author vsha28
 * @version $Revision: 1.0 $
 */
public class ReportBuilderTest {
	/**
	 * Run the String buildReport(AutomationTestSuite) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testBuildReport_1()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestSuite suite = new AutomationTestSuite("");

		String result = fixture.buildReport(suite);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.io.FileNotFoundException: 
		//       at java.io.FileInputStream.open(Native Method)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at com.automation.model.AutomationTestSuite.<init>(AutomationTestSuite.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the String buildReport(AutomationTestSuite) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testBuildReport_2()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestSuite suite = new AutomationTestSuite("");

		String result = fixture.buildReport(suite);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.io.FileNotFoundException: 
		//       at java.io.FileInputStream.open(Native Method)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at com.automation.model.AutomationTestSuite.<init>(AutomationTestSuite.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the String buildReport(AutomationTestSuite) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testBuildReport_3()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestSuite suite = new AutomationTestSuite("");

		String result = fixture.buildReport(suite);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.io.FileNotFoundException: 
		//       at java.io.FileInputStream.open(Native Method)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at com.automation.model.AutomationTestSuite.<init>(AutomationTestSuite.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the String buildReport(AutomationTestSuite) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testBuildReport_4()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestSuite suite = new AutomationTestSuite("");

		String result = fixture.buildReport(suite);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.io.FileNotFoundException: 
		//       at java.io.FileInputStream.open(Native Method)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at com.automation.model.AutomationTestSuite.<init>(AutomationTestSuite.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the String buildReport(AutomationTestSuite) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testBuildReport_5()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestSuite suite = new AutomationTestSuite("");

		String result = fixture.buildReport(suite);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.io.FileNotFoundException: 
		//       at java.io.FileInputStream.open(Native Method)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at com.automation.model.AutomationTestSuite.<init>(AutomationTestSuite.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the String buildReport(AutomationTestSuite) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testBuildReport_6()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestSuite suite = new AutomationTestSuite("");

		String result = fixture.buildReport(suite);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.io.FileNotFoundException: 
		//       at java.io.FileInputStream.open(Native Method)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at java.io.FileInputStream.<init>(Unknown Source)
		//       at com.automation.model.AutomationTestSuite.<init>(AutomationTestSuite.java:28)
		assertNotNull(result);
	}

	/**
	 * Run the ReportBuilder getBuilder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test
	public void testGetBuilder_1()
		throws Exception {

		ReportBuilder result = ReportBuilder.getBuilder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Execution_Report_", result.getFileNamePrefix());
		assertEquals("Report", result.getFileDir());
	}

	/**
	 * Run the String getFileDir() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test
	public void testGetFileDir_1()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");

		String result = fixture.getFileDir();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getFileNamePrefix() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test
	public void testGetFileNamePrefix_1()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");

		String result = fixture.getFileNamePrefix();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setFileDir(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test
	public void testSetFileDir_1()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		String fileDir = "";

		fixture.setFileDir(fileDir);

		// add additional test code here
	}

	/**
	 * Run the void setFileNamePrefix(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test
	public void testSetFileNamePrefix_1()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		String fileNamePrefix = "";

		fixture.setFileNamePrefix(fileNamePrefix);

		// add additional test code here
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_1()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_2()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_3()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_4()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_5()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_6()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_7()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_8()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_9()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Run the void writeTestCaseResult(AutomationTestCaseStep) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	@Test(expected=ToolRuntimeException.class)
	public void testWriteTestCaseResult_10()
		throws Exception {
		ReportBuilder fixture = ReportBuilder.getBuilder();
		fixture.setFileNamePrefix("");
		fixture.setFileDir("");
		AutomationTestCaseStep step = null;

		fixture.writeTestCaseResult(step);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.automation.ReportBuilder.writeTestCaseResult(ReportBuilder.java:95)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/11/13 11:16 AM
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
	 * @generatedBy CodePro at 9/11/13 11:16 AM
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
	 * @generatedBy CodePro at 9/11/13 11:16 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ReportBuilderTest.class);
	}
}