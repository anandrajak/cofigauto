package com.cofigauto.internal;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.internal.Browser;
import com.cofigauto.internal.IdentifierType;
import com.cofigauto.internal.IdentifierType.ValidIdentifierType;

/**
 */
public class IdentifierTypeFunctionalTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdentifierTypeFunctionalTest.class);
	
	@Test
	public void testGetByName() {
		try {
			ValidIdentifierType.getByName("id");
			ValidIdentifierType.getByName("name");
			ValidIdentifierType.getByName("name_InDex");
			ValidIdentifierType.getByName("javascript");
			ValidIdentifierType.getByName("CssClasS");
			ValidIdentifierType.getByName("CssClass_INDEX");
			ValidIdentifierType.getByName("XpatH");
			ValidIdentifierType.getByName("Xpath_INDex");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception occurred");
		}
	}

	@Test
	public void testGetElementForIdentifier_IE() {
		RemoteWebDriver driver=null;
		try {
			driver = Browser.getDriverByName("ie");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			
			
			new WebDriverWait(driver, 5);
			
			submitSearch(ValidIdentifierType.ID.name().toLowerCase(), "gbqfq", "0", driver);
			
			new WebDriverWait(driver, 5);
			submitSearch(ValidIdentifierType.CssClass.name().toLowerCase(), "gbqfif", "0", driver);
			new WebDriverWait(driver, 5);
			submitSearch(ValidIdentifierType.CssClass_index.name().toLowerCase(), "gbqfif", "0", driver);
			new WebDriverWait(driver, 5);
			submitSearch(ValidIdentifierType.Name.name().toLowerCase(), "q", "0", driver);
			new WebDriverWait(driver, 5);
			submitSearch(ValidIdentifierType.Name_index.name().toLowerCase(), "q", "0", driver);
			new WebDriverWait(driver, 5);
			
			WebElement element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath.name().toLowerCase(),
					"//html/body/div", "0", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));

			}
			

			element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath_index.name().toLowerCase(),
					"//html/body/div", "1", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));
			}
			
			submitSearch(ValidIdentifierType.JavaScript.name().toLowerCase(), " return document.getElementById('gbqfq')", "0", driver);

		} catch (Exception e) {
			LOGGER.error("Exception occurred", e);
			fail("Exception occurred");
		} finally{
			if(driver!=null){
				driver.close();
			}
		}
	}
	
	@Test
	public void testGetElementForIdentifier_FIREFOX() {
		RemoteWebDriver driver=null;
		try {
			driver = Browser.getDriverByName("firefox");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			
			
			
			submitSearch(ValidIdentifierType.ID.name().toLowerCase(), "gbqfq", "0", driver);
			submitSearch(ValidIdentifierType.CssClass.name().toLowerCase(), "gbqfif", "0", driver);
			submitSearch(ValidIdentifierType.CssClass_index.name().toLowerCase(), "gbqfif", "0", driver);
			submitSearch(ValidIdentifierType.Name.name().toLowerCase(), "q", "0", driver);
			submitSearch(ValidIdentifierType.Name_index.name().toLowerCase(), "q", "0", driver);
			
			
			WebElement element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath.name().toLowerCase(),
					"//html/body/div", "0", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));

			}
			

			element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath_index.name().toLowerCase(),
					"//html/body/div", "1", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));
			}
			
		

			submitSearch(ValidIdentifierType.JavaScript.name().toLowerCase(), " return document.getElementById('gbqfq')", "0", driver);
		
		} catch (Exception e) {
			LOGGER.error("Exception occurred", e);
			fail("Exception occurred");
		} finally{
			if(driver!=null){
				driver.close();
			}
		}
	}

	@Test
	public void testGetElementForIdentifier_CHROME() {
		RemoteWebDriver driver=null;
		try {
			driver = Browser.getDriverByName("CHROME");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			
			
			
			submitSearch(ValidIdentifierType.ID.name().toLowerCase(), "gbqfq", "0", driver);
			submitSearch(ValidIdentifierType.CssClass.name().toLowerCase(), "gbqfif", "0", driver);
			submitSearch(ValidIdentifierType.CssClass_index.name().toLowerCase(), "gbqfif", "0", driver);
			submitSearch(ValidIdentifierType.Name.name().toLowerCase(), "q", "0", driver);
			submitSearch(ValidIdentifierType.Name_index.name().toLowerCase(), "q", "0", driver);
			
			
			WebElement element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath.name().toLowerCase(),
					"//html/body/div", "0", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));

			}
			

			element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath_index.name().toLowerCase(),
					"//html/body/div", "1", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));
			}
			
		

			submitSearch(ValidIdentifierType.JavaScript.name().toLowerCase(), " return document.getElementById('gbqfq')", "0", driver);
		
		} catch (Exception e) {
			LOGGER.error("Exception occurred", e);
			fail("Exception occurred");
		} finally{
			if(driver!=null){
				driver.close();
			}
		}
	}

	@Test
	public void testGetElementForIdentifier_SAFARI() {
		RemoteWebDriver driver=null;
		try {
			driver = Browser.getDriverByName("SAFARI");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			
			
			
			submitSearch(ValidIdentifierType.ID.name().toLowerCase(), "gbqfq", "0", driver);
			submitSearch(ValidIdentifierType.CssClass.name().toLowerCase(), "gbqfif", "0", driver);
			submitSearch(ValidIdentifierType.CssClass_index.name().toLowerCase(), "gbqfif", "0", driver);
			submitSearch(ValidIdentifierType.Name.name().toLowerCase(), "q", "0", driver);
			submitSearch(ValidIdentifierType.Name_index.name().toLowerCase(), "q", "0", driver);
			
			
			WebElement element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath.name().toLowerCase(),
					"//html/body/div", "0", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));

			}
			

			element = IdentifierType.getElementForIdentifier(ValidIdentifierType.Xpath_index.name().toLowerCase(),
					"//html/body/div", "1", driver);
			if (element == null) {
				fail("Element is null");
			} else {
				LOGGER.info("######################################################");
				LOGGER.info(element.getTagName());
				LOGGER.info(element.getAttribute("style"));
			}
			
		

			submitSearch(ValidIdentifierType.JavaScript.name().toLowerCase(), " return document.getElementById('gbqfq')", "0", driver);
		
		} catch (Exception e) {
			LOGGER.error("Exception occurred", e);
			fail("Exception occurred");
		} finally{
			if(driver!=null){
				driver.close();
			}
		}
	}

	
	/**
	 * Method submitSearch.
	 * @param type String
	 * @param identifier String
	 * @param index String
	 * @param driver RemoteWebDriver
	 */
	private void submitSearch(String type, String identifier, String index, RemoteWebDriver driver) {
		try {

			WebElement element = IdentifierType.getElementForIdentifier(type, identifier, index, driver);
			if (element == null) {
				fail("Element is null");
			}
			
			element.clear(); 
			element.sendKeys("webdriver");

			driver.findElement(By.name("btnG")).click();
			new WebDriverWait(driver, 3,1).until(ExpectedConditions.titleIs("webdriver - Google Search"));
		} catch (Exception e) {
			LOGGER.error("Exception occurred", e);
			fail("Exception occurred");
		}
	}

}
