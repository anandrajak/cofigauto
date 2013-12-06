package com.cofigauto;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ConfigurationException;
import com.cofigauto.internal.Browser;
import com.cofigauto.model.AutomationTestCase;

/**
 */
public class TestCaseContext {
    /**
     * Selenium Remote web driver instance.
     */
    private RemoteWebDriver driver;
    /**
     * main window handle.
     */
    private String masterWindowHandle;
    /**
     * Total count of open windows.
     */
    private int windowCount = 0;
    /**
     * window number to handle map
     */
    private Map<Integer, String> windowNumberToHandleMap = new HashMap<Integer, String>();
    /**
     * window handle to number map.
     */
    private Map<String, Integer> windowHandleToNumberMap = new HashMap<String, Integer>();

    /**
     * Slf4j Logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(TestCaseContext.class);

    /**
     * Test Case Context Builder.
     */
    public static class TestCaseContextBuilder {
        private TestCaseContext context = new TestCaseContext();

        /**
         * Constructor for TestCaseContextBuilder.
         * 
         * @param testCase
         *            AutomationTestCase
         * @throws ConfigurationException
         */
        public TestCaseContextBuilder(final AutomationTestCase testCase)
                throws ConfigurationException {
            context.driver = Browser.getDriverByName(testCase.getBrowserName());
        }

        /**
         * Method getTestCaseContext.
         * 
         * @return TestCaseContext
         */
        public final TestCaseContext getTestCaseContext() {
            return this.context;
        }
    }

    /**
     * Method getDriver.
     * 
     * @return RemoteWebDriver
     */
    public final RemoteWebDriver getDriver() {
        return driver;
    }

    /**
     * Method getMasterWindowHandle.
     * 
     * @return String
     */
    public final String getMasterWindowHandle() {
        return masterWindowHandle;
    }

    /**
     * Method setMasterWindowHandle.
     * 
     * @param masterWindowHandleName
     *            String
     */
    public final void setMasterWindowHandle(final String masterWindowHandleName) {
        this.masterWindowHandle = masterWindowHandleName;
    }

    /**
     * @return the windowCount
     */
    public final int getWindowCount() {
        return windowCount;
    }

    /**
     * Method getWindowNumberByHandle.
     * 
     * @param handle
     *            String
     * @return int
     */
    public final int getWindowNumberByHandle(final String handle) {
        return this.windowHandleToNumberMap.get(handle) != null
                ? this.windowHandleToNumberMap.get(handle)
                : 0;
    }

    /**
     * Method getWindowHandleByNumber.
     * 
     * @param number
     *            int
     * @return String
     */
    public final String getWindowHandleByNumber(final int number) {
        return this.windowNumberToHandleMap.get(number);
    }

    public final void processWindowData() {

        if (driver == null) {
            return;
        }

        for (String handle : driver.getWindowHandles()) {
            Integer windowNumber = this.windowHandleToNumberMap.get(handle);
            boolean isNew = (((windowNumber != null) && (windowNumber != 0))
                    ? false
                    : true);
            if (isNew) {
                LOG.info("found new window with handle " + handle);
                LOG.info("New window number = " + this.getWindowCount());
            }
            if (isNew) {
                this.windowCount++;
                this.windowNumberToHandleMap.put(this.getWindowCount(), handle);
                this.windowHandleToNumberMap.put(handle, this.getWindowCount());
            }
        }

        if (this.getWindowCount() > 0) {
            LOG.info("Total windows open = " + this.getWindowCount());
            LOG.info("Current window handle = "
                    + this.getDriver().getWindowHandle());
            LOG.info("Current window number = "
                    + this.getWindowNumberByHandle(this.getDriver()
                            .getWindowHandle()));
        }
    }

    /**
     * Method processWindowClose.
     * 
     * @param number
     *            int
     */
    public final void processWindowClose(final int number) {

        String windowHandle = this.getWindowHandleByNumber(number);
        this.windowHandleToNumberMap.remove(windowHandle);
        this.windowNumberToHandleMap.remove(number);

        Map<Integer, String> newWindowNumberToHandleMap = new HashMap<Integer, String>();
        Map<String, Integer> newWindowHandleToNumberMap = new HashMap<String, Integer>();
        int count = 0;
        for (int i : windowNumberToHandleMap.keySet()) {
            count++;
            if (i > number) {
                newWindowNumberToHandleMap.put(i - 1,
                        windowNumberToHandleMap.get(i));
                newWindowHandleToNumberMap.put(windowNumberToHandleMap.get(i),
                        i - 1);
            } else {
                newWindowNumberToHandleMap.put(i,
                        windowNumberToHandleMap.get(i));
                newWindowHandleToNumberMap.put(windowNumberToHandleMap.get(i),
                        i);
            }
        }

        windowCount = count;

    }

}
