package com.cofigauto.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.model.AutomationTestSuite;

/**
 * @author Vinay Sharma
 * @version 1.1
 */
public final class ExcelTestSuitRunner extends AbstractTestSuitRunner
        implements
            TestSuitRunner {

    /**
     * slf4j logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(ExcelTestSuitRunner.class);

    /**
     * Private default constructor.
     */
    public ExcelTestSuitRunner() {
    }

    /**
     * Method runTestSuite.
     * 
     * @param excelPath
     *            String
     * @return AutomationTestSuite
     */
    public AutomationTestSuite runTestSuite(final String excelPath) {
        AutomationTestSuite suit = null;

        try {
            suit = new AutomationTestSuite(excelPath);
        } catch (Exception e) {
            LOG.error("Exception Occurred", e);
            System.exit(0);
        }

        this.runTestSuit(suit);

        return suit;
    }
}
