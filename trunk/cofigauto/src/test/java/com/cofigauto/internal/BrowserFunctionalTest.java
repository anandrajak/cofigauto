package com.cofigauto.internal;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cofigauto.internal.Browser;
import com.cofigauto.internal.Browser.ValidBrowser;


/**
 */
public class BrowserFunctionalTest {

	@Test
	public void testGetByName() {
        try{
        	ValidBrowser.getByName("ie");
        	ValidBrowser.getByName("IE");
        	ValidBrowser.getByName("Firefox");
        	ValidBrowser.getByName("firefox");
        	ValidBrowser.getByName("Chrome");
        	ValidBrowser.getByName("CHROME");
        	ValidBrowser.getByName("Safari");
        	ValidBrowser.getByName("SaFarI");
        } catch (Exception e){
        	e.printStackTrace();
        	fail("Exception occurred");
        }
	}

	@Test
	public void testGetDriverByNameString() {
		 try{
			 RemoteWebDriver driver;
			 driver = Browser.getDriverByName("ie");
			 getGooglePageAndClose(driver);
			 driver = Browser.getDriverByName("Firefox");
			 getGooglePageAndClose(driver);
			 driver = Browser.getDriverByName("Chrome");
			 getGooglePageAndClose(driver);
			 driver = Browser.getDriverByName("SaFarI");
			 getGooglePageAndClose(driver);
	        } catch (Exception e){
	        	e.printStackTrace();
	        	fail("Exception occurred");
	        }
	}
	
	
	/**
	 * Method getGooglePageAndClose.
	 * @param driver RemoteWebDriver
	 */
	private void getGooglePageAndClose(RemoteWebDriver driver){
		   driver.get("http://www.google.com");
		    driver.findElement(By.name("q")).sendKeys("webdriver");
		    driver.findElement(By.name("btnG")).click();
		    new WebDriverWait(driver, 3)
		        .until(ExpectedConditions.titleIs("webdriver - Google Search"));

		driver.close();
	}

}
