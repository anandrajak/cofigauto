package com.cofigauto.runner;

import com.cofigauto.model.AutomationTestSuite;


/**
 * @author vinay sharma
 * @since 1.1
 *
 */
public interface TestSuitRunner {

    /**
     * This Method reads configurations from the file, creates
     * AutomationTestSuite instance for it, runs tests, updated
     * AutomationTestSuite instance and returns it.
     * 
     * @param testFilePath
     * @return AutomationTestSuite instance with run status.
     */
    AutomationTestSuite runTestSuite(final String testFilePath);

}
