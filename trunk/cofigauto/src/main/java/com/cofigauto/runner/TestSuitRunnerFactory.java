package com.cofigauto.runner;

import com.cofigauto.exception.ToolRuntimeException;

/**
 * The class <code>ExcelTestSuitRunnerFactory</code> implements static methods
 * that return instances of the implementations of interface class
 * <code>{@link TestSuitRunner}</code>.
 * 
 * @author vinay sharma
 * @version $Revision: 1.1 $
 */
public final class TestSuitRunnerFactory {
    /**
     * Prevent creation of instances of this class.
     */
    private TestSuitRunnerFactory() {
    }

    /**
     * Create an instance of the implementing class if interface
     * <code>{@link TestSuitRunner}</code>.
     */
    public static TestSuitRunner createTestSuitRunner(
            final ValidTestSuitRunnerTypes runnerType) {
        TestSuitRunner runner = null;
        if (runnerType == null
                || runnerType.equals(ValidTestSuitRunnerTypes.EXCEL)) {
            runner = new ExcelTestSuitRunner();
        } else if (runnerType.equals(ValidTestSuitRunnerTypes.XML)) {
            runner = new XmlTestSuitRunner();
        } else if (runnerType.equals(ValidTestSuitRunnerTypes.JSON)) {
            throw new ToolRuntimeException(
                    "JSON test suit run not yer supported");
        }

        if (runner == null) {
            throw new ToolRuntimeException(
                    "Runner cannot be identified for test suit");
        }
        return runner;
    }
}
