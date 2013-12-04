package com.cofigauto.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>TimeStampLoggerTest</code> contains tests for the class <code>{@link TimeStampLogger}</code>.
 *
 * @generatedBy CodePro at 9/11/13 11:19 AM
 * @author vsha28
 * @version $Revision: 1.0 $
 */
public class TimeStampLoggerTest {
	/**
	 * Run the TimeStampLogger() constructor test.
	 *
	 * @generatedBy CodePro at 9/11/13 11:19 AM
	 */
	@Test
	public void testTimeStampLogger_1()
		throws Exception {
		TimeStampLogger result = new TimeStampLogger();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the String getTimeformat() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:19 AM
	 */
	@Test
	public void testGetTimeformat_1()
		throws Exception {
		TimeStampLogger fixture = new TimeStampLogger();
		fixture.setTimeformat("");

		String result = fixture.getTimeformat();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setFile(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:19 AM
	 */
	@Test
	public void testSetFile_1()
		throws Exception {
		TimeStampLogger fixture = new TimeStampLogger();
		fixture.setTimeformat("");
		String file = "";

		fixture.setFile(file);

		// add additional test code here
	}

	/**
	 * Run the void setTimeformat(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/11/13 11:19 AM
	 */
	@Test
	public void testSetTimeformat_1()
		throws Exception {
		TimeStampLogger fixture = new TimeStampLogger();
		fixture.setTimeformat("");
		String timeformat = "";

		fixture.setTimeformat(timeformat);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/11/13 11:19 AM
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
	 * @generatedBy CodePro at 9/11/13 11:19 AM
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
	 * @generatedBy CodePro at 9/11/13 11:19 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TimeStampLoggerTest.class);
	}
}