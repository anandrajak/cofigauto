package com.cofigauto.internal;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * The class <code>BrowserTest</code> contains tests for the class
 * <code>{@link Browser}</code>.
 * 
 * @generatedBy CodePro at 9/11/13 11:19 AM
 * @author vsha28
 * @version $Revision: 1.0 $
 */
public class BrowserTest {
    /**
     * Run the RemoteWebDriver getDriverByName(String) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ConfigurationException.class)
    public void testGetDriverByName_1() throws Exception {
        String name = "";

        RemoteWebDriver result = Browser.getDriverByName(name);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the RemoteWebDriver getDriverByName(String,Capabilities) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ConfigurationException.class)
    public void testGetDriverByName_2() throws Exception {
        String name = "";
        Capabilities desiredCapabilities = new DesiredCapabilities();

        RemoteWebDriver result = Browser.getDriverByName(name,
                desiredCapabilities);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the RemoteWebDriver getDriverByName(String,Capabilities) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ConfigurationException.class)
    public void testGetDriverByName_3() throws Exception {
        String name = "";
        Capabilities desiredCapabilities = null;

        RemoteWebDriver result = Browser.getDriverByName(name,
                desiredCapabilities);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the RemoteWebDriver getDriverByName(String,Capabilities) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ConfigurationException.class)
    public void testGetDriverByName_4() throws Exception {
        String name = "";
        Capabilities desiredCapabilities = new DesiredCapabilities();

        RemoteWebDriver result = Browser.getDriverByName(name,
                desiredCapabilities);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Perform pre-test initialization.
     * 
     * @throws Exception
     *             if the initialization fails for some reason
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
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
     * @generatedBy CodePro at 9/11/13 11:19 AM
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
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(BrowserTest.class);
    }
}
