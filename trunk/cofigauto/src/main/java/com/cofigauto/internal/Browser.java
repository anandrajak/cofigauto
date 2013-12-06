package com.cofigauto.internal;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.cofigauto.exception.ConfigurationException;

/**
 */
public final class Browser {

    /**
     * private default constructor
     */
    private Browser() {
        // throw new ToolRuntimeException("Cannot instantiate this class");
    }

    /**
     * Method getDriverByName.
     * 
     * @param name
     *            String
     * @return RemoteWebDriver
     * @throws ConfigurationException congfig exception
     */
    public static RemoteWebDriver getDriverByName(final String name)
            throws ConfigurationException {
        RemoteWebDriver driver = null;
        try {

            ValidBrowser browser = ValidBrowser.getByName(name);

            if (browser != null) {
                driver = browser.getDriverClass().newInstance();
            }

        } catch (Exception e) {
            throw new ConfigurationException(
                    "Exception in getting driver instance", e);
        }

        if (driver == null) {
            throw new ConfigurationException("Invalid browser name '" + name
                    + "'");
        }

        return driver;
    }

    /**
     * Method getDriverByName.
     * 
     * @param name
     *            String
     * @param desiredCapabilities
     *            Capabilities
     * @return RemoteWebDriver
     * @throws ConfigurationException
     */
    public static RemoteWebDriver getDriverByName(final String name,
            final Capabilities desiredCapabilities)
            throws ConfigurationException {
        try {
            ValidBrowser browser = ValidBrowser.getByName(name);
            RemoteWebDriver driver;
            if (browser != null && desiredCapabilities != null) {
                driver = browser.getDriverClass()
                        .getConstructor(Capabilities.class)
                        .newInstance(new Object[] { desiredCapabilities });
            } else if (browser != null) {
                driver = browser.getDriverClass().newInstance();
            } else {
                throw new ConfigurationException("Invalid browser name '"
                        + name + "'");
            }

            return driver;
        } catch (Exception e) {
            throw new ConfigurationException(
                    "Exception ingetting driver instance", e);
        }
    }

    public enum ValidBrowser {
        IE(InternetExplorerDriver.class), Firefox(FirefoxDriver.class), Chrome(
                ChromeDriver.class), Safari(SafariDriver.class);

        private static Map<String, ValidBrowser> browserName = new HashMap<String, ValidBrowser>();
        private final Class<? extends RemoteWebDriver> driverClass;

        static {
            for (ValidBrowser browser : ValidBrowser.values()) {
                browserName.put(browser.name().toUpperCase(), browser);
            }
        }

        /**
         * Constructor for ValidBrowser.
         * 
         * @param browserDriverClass
         *            Class<? extends RemoteWebDriver>
         */
        ValidBrowser(final Class<? extends RemoteWebDriver> browserDriverClass) {
            this.driverClass = browserDriverClass;
        }

        /**
         * Method getByName.
         * 
         * @param name
         *            String
         * @return ValidBrowser
         * @throws ConfigurationException
         */
        public static ValidBrowser getByName(final String name)
                throws ConfigurationException {

            if (StringUtils.isBlank(name)) {
                throw new ConfigurationException("Browser name is blank");
            }

            ValidBrowser browser = browserName.get(name.trim().toUpperCase());

            if (browser != null) {
                return browser;
            } else {
                throw new ConfigurationException("Invalid browser name '"
                        + name + "'");
            }
        }

        /**
         * Method getDriverClass.
         * 
         * @return Class<? extends RemoteWebDriver>
         */
        public Class<? extends RemoteWebDriver> getDriverClass() {
            return driverClass;
        }
    }

}
