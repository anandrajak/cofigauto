package com.cofigauto.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ConfigurationException;
import com.cofigauto.exception.ToolRuntimeException;

/**
 */
public class IdentifierType {

  private static final Logger LOG = LoggerFactory
      .getLogger(IdentifierType.class);

  /**
   * Method getElementForIdentifier.
   * 
   * @param type
   *          String
   * @param identifier
   *          String
   * @param index
   *          String
   * @param driver
   *          WebDriver
   * @return WebElement
   * @throws ConfigurationException
   */
  @SuppressWarnings("unchecked")
  public static WebElement getElementForIdentifier(final String type,
      final String identifier, final String index, final WebDriver driver)
      throws ConfigurationException {

    WebElement webElement = null;
    boolean isElementList = false;
    try {
      ValidIdentifierType identType = ValidIdentifierType.getByName(type);
      if (identType.equals(ValidIdentifierType.JavaScript)) {
        Object obj = ((JavascriptExecutor) driver).executeScript(identifier);
        if (obj != null && (obj instanceof ArrayList)
            && ((List<WebElement>) obj).size() > 0) {
          webElement = ((List<WebElement>) obj).get(0);
        } else if (obj != null && (obj instanceof WebElement)) {
          webElement = (WebElement) obj;
        } else if (obj != null) {
          LOG.error("Cannot process = " + obj);
        } else {
          LOG.warn("No element found with identifier = " + identifier);
        }
      } else {
        Object element = identType.getMethod().invoke(driver, identifier);
        if (element != null) {
          if (identType.getReturnType().equals(
              IdentifierMethodReturnType.WEB_ELEMENT)) {
            webElement = (WebElement) element;
          } else if (identType.getReturnType().equals(
              IdentifierMethodReturnType.LIST)
              && StringUtils.isNotBlank(index)) {
            isElementList = true;
            List<WebElement> lst = ((List<WebElement>) element);
            if (lst != null) {
              LOG.info("TOTAL elements found for identifier = " + lst.size());
            }
            Integer ind = Integer.parseInt(index.trim());
            if (lst != null) {
              LOG.info("getting index = " + ind);
            }
            if (lst.size() > ind) {
              webElement = ((List<WebElement>) element).get(ind);
            } else {
              webElement = ((List<WebElement>) element).get(0);
            }
          }
        } else {
          throw new ConfigurationException("No element found with identifier "
              + identifier);
        }
      }
    } catch (NoSuchElementException exp) {
      if (isElementList) {
        LOG.warn("No element found with identifier '" + identifier
            + "' and index '" + index + "'");
      } else {
        LOG.warn("No element found with identifier = " + identifier);
      }
    } catch (InvocationTargetException iexp) {
      if (iexp.getCause() instanceof NoSuchElementException) {
        if (isElementList) {
          LOG.warn("No element found with identifier '" + identifier
              + "' and index '" + index + "'");
        } else {
          LOG.warn("No element found with identifier = " + identifier);
        }
      }
    } catch (Exception e) {
      throw new ConfigurationException("Exception in getting element", e);
    }

    return webElement;
  }

  /**
	 */
  public enum IdentifierMethodReturnType {
    LIST, WEB_ELEMENT;
  }

  /**
	 */
  public enum ValidIdentifierType {
    ID("findElementById", IdentifierMethodReturnType.WEB_ELEMENT), Name(
        "findElementByName", IdentifierMethodReturnType.WEB_ELEMENT), Name_index(
        "findElementsByName", IdentifierMethodReturnType.LIST), JavaScript("",
        IdentifierMethodReturnType.WEB_ELEMENT), CssClass(
        "findElementByClassName", IdentifierMethodReturnType.WEB_ELEMENT), CssClass_index(
        "findElementsByClassName", IdentifierMethodReturnType.LIST), Xpath(
        "findElementByXPath", IdentifierMethodReturnType.WEB_ELEMENT), Xpath_index(
        "findElementsByXPath", IdentifierMethodReturnType.LIST), linkText(
        "findElementByLinkText", IdentifierMethodReturnType.WEB_ELEMENT), linkText_index(
        "findElementsByLinkText", IdentifierMethodReturnType.WEB_ELEMENT), partialLinkText(
        "findElementByPartialLinkText", IdentifierMethodReturnType.WEB_ELEMENT), partialLinkText_index(
        "findElementsByPartialLinkText", IdentifierMethodReturnType.LIST);

    private static Map<String, ValidIdentifierType> ID_TYPE_NAME = new HashMap<String, ValidIdentifierType>();
    private Method method;
    private IdentifierMethodReturnType returnType;

    static {
      for (ValidIdentifierType type : ValidIdentifierType.values()) {
        ID_TYPE_NAME.put(type.name().toUpperCase(), type);
      }
    }

    /**
     * Constructor for ValidIdentifierType.
     * 
     * @param methodName
     *          String
     * @param returnType
     *          IdentifierMethodReturnType
     */
    ValidIdentifierType(final String methodName, final IdentifierMethodReturnType returnType) {
      if (StringUtils.isBlank(methodName)) {
        return;
      }

      try {
        Method method = RemoteWebDriver.class.getDeclaredMethod(methodName,
            String.class);
        this.method = method;
        this.returnType = returnType;
      } catch (Exception e) {
        throw new ToolRuntimeException(
            "methodName is wrong for identifier type");
      }
    }

    /**
     * Method getByName.
     * 
     * @param name
     *          String
     * @return ValidIdentifierType
     * @throws ConfigurationException
     */
    public static ValidIdentifierType getByName(final String name)
        throws ConfigurationException {

      ValidIdentifierType type = ID_TYPE_NAME.get(name.trim().toUpperCase());

      if (type != null) {
        return type;
      } else {
        throw new ConfigurationException("Invalid IdentifierType name '" + name
            + "'");
      }
    }

    /**
     * Method getMethod.
     * 
     * @return Method
     */
    public Method getMethod() {
      return method;
    }

    /**
     * Method getReturnType.
     * 
     * @return IdentifierMethodReturnType
     */
    public IdentifierMethodReturnType getReturnType() {
      return returnType;
    }

  }

}
