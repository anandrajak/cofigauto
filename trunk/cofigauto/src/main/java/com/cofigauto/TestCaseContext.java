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
	private RemoteWebDriver driver;
	private String masterWindowHandle;
	private int windowCount = 0;
	private Map<Integer, String> windowNumberToHandleMap = new HashMap<Integer, String>();
	private Map<String, Integer> windowHandleToNumberMap = new HashMap<String, Integer>();

	private static Logger LOG = LoggerFactory.getLogger(TestCaseContext.class);

	/**
	 */
	public static class TestCaseContextBuilder {
		private TestCaseContext context = new TestCaseContext();

		/**
		 * Constructor for TestCaseContextBuilder.
		 * @param testCase AutomationTestCase
		 * @throws ConfigurationException
		 */
		public TestCaseContextBuilder(AutomationTestCase testCase) throws ConfigurationException {
			context.driver = Browser.getDriverByName(testCase.getBrowserName());
		}

		/**
		 * Method getTestSuiteContext.
		 * @return TestCaseContext
		 */
		public TestCaseContext getTestSuiteContext() {
			return this.context;
		}
	}

	/**
	 * Method getDriver.
	 * @return RemoteWebDriver
	 */
	public RemoteWebDriver getDriver() {
		return driver;
	}

	/**
	 * Method getMasterWindowHandle.
	 * @return String
	 */
	public String getMasterWindowHandle() {
		return masterWindowHandle;
	}

	/**
	 * Method setMasterWindowHandle.
	 * @param masterWindowHandle String
	 */
	public void setMasterWindowHandle(String masterWindowHandle) {
		this.masterWindowHandle = masterWindowHandle;
	}

	/**
	
	 * @return the windowCount */
	public int getWindowCount() {
		return windowCount;
	}

	/**
	 * Method getWindowNumberByHandle.
	 * @param handle String
	 * @return int
	 */
	public int getWindowNumberByHandle(String handle) {
		return this.windowHandleToNumberMap.get(handle) != null ? this.windowHandleToNumberMap.get(handle) : 0;
	}

	/**
	 * Method getWindowHandleByNumber.
	 * @param number int
	 * @return String
	 */
	public String getWindowHandleByNumber(int number) {
		return this.windowNumberToHandleMap.get(number);
	}

	public void processWindowData() {

		if(driver==null) {
			return;
		}
		
		for (String handle : driver.getWindowHandles()) {
			Integer windowNumber = this.windowHandleToNumberMap.get(handle);
			boolean isNew = (((windowNumber != null) && (windowNumber != 0)) ? false : true);
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
			LOG.info("Current window handle = " + this.getDriver().getWindowHandle());
			LOG.info("Current window number = " + this.getWindowNumberByHandle(this.getDriver().getWindowHandle()));
		}
	}

	/**
	 * Method processWindowClose.
	 * @param number int
	 */
	public void processWindowClose(int number) {

		String windowHandle = this.getWindowHandleByNumber(number);
		this.windowHandleToNumberMap.remove(windowHandle);
		this.windowNumberToHandleMap.remove(number);

		Map<Integer, String> newWindowNumberToHandleMap = new HashMap<Integer, String>();
		Map<String, Integer> newWindowHandleToNumberMap = new HashMap<String, Integer>();
		int count = 0;
		for (int i : windowNumberToHandleMap.keySet()) {
			count++;
			if (i > number) {
				newWindowNumberToHandleMap.put(i - 1, windowNumberToHandleMap.get(i));
				newWindowHandleToNumberMap.put(windowNumberToHandleMap.get(i), i - 1);
			} else {
				newWindowNumberToHandleMap.put(i, windowNumberToHandleMap.get(i));
				newWindowHandleToNumberMap.put(windowNumberToHandleMap.get(i), i);
			}
		}

		windowCount = count;

	}

}
