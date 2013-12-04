package com.cofigauto.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>TestStatusTest</code> contains tests for the class
 * <code>{@link TestStatus}</code>.
 * 
 * @generatedBy CodePro at 9/11/13 11:17 AM
 * @author vsha28
 * @version $Revision: 1.0 $
 */
public class TestStatusTest {
    /**
     * Run the TestStatus() constructor test.
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Test
    public void testTestStatus_1() throws Exception {
        TestStatus result = new TestStatus();
        assertNotNull(result);
        // add additional test code here
    }

    /**
     * Run the ValidTestStatus getStatus() method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Test
    public void testGetStatus_1() throws Exception {
        TestStatus fixture = new TestStatus();
        fixture.setStatus(ValidTestStatus.FAIL);
        fixture.setStatusDesc("");

        ValidTestStatus result = fixture.getStatus();

        // add additional test code here
        assertNotNull(result);
        assertEquals("FAIL", result.name());
        assertEquals("FAIL", result.toString());
        assertEquals(0, result.ordinal());
    }

    /**
     * Run the String getStatusDesc() method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Test
    public void testGetStatusDesc_1() throws Exception {
        TestStatus fixture = new TestStatus();
        fixture.setStatus(ValidTestStatus.FAIL);
        fixture.setStatusDesc("");

        String result = fixture.getStatusDesc();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the void setStatus(ValidTestStatus) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Test
    public void testSetStatus_1() throws Exception {
        TestStatus fixture = new TestStatus();
        fixture.setStatus(ValidTestStatus.FAIL);
        fixture.setStatusDesc("");
        ValidTestStatus status = ValidTestStatus.FAIL;

        fixture.setStatus(status);

        // add additional test code here
    }

    /**
     * Run the void setStatusDesc(String) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Test
    public void testSetStatusDesc_1() throws Exception {
        TestStatus fixture = new TestStatus();
        fixture.setStatus(ValidTestStatus.FAIL);
        fixture.setStatusDesc("");
        String statusDesc = "";

        fixture.setStatusDesc(statusDesc);

        // add additional test code here
    }

    /**
     * Run the String toString() method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Test
    public void testToString_1() throws Exception {
        TestStatus fixture = new TestStatus();
        fixture.setStatus(ValidTestStatus.FAIL);
        fixture.setStatusDesc("");

        String result = fixture.toString();

        // add additional test code here
        assertEquals("TestStatus [status=FAIL, statusDesc=]", result);
    }

    /**
     * Perform pre-test initialization.
     * 
     * @throws Exception
     *             if the initialization fails for some reason
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @Before
    public void setUp() throws Exception {
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     * 
     * @throws Exception
     *             if the clean-up fails for some reason
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    @After
    public void tearDown() throws Exception {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     * 
     * @param args
     *            the command line arguments
     * 
     * @generatedBy CodePro at 9/11/13 11:17 AM
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(TestStatusTest.class);
    }
}
