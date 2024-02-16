package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.SelectOption;

import ExtentListeners.ExtentListeners;

public class BasePage {
	
	
	public static Page page;
	public static Properties OR = new Properties();
	private static FileInputStream fis;

	
	public BasePage(Page page) {
		
		this.page = page;
		
		try {
			fis = new FileInputStream("./src/main/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void click(String locatorKey) {

		try {
			page.locator(OR.getProperty(locatorKey)).click();
			ExtentListeners.getExtent().info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Clicking on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	
	public void mouseHover(String locatorKey) {

		try {
			page.hover(OR.getProperty(locatorKey));
			ExtentListeners.getExtent().info("Moving on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while Moving on an Element : " + locatorKey + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public boolean isElementPresent(String locatorKey) {

		try {
			page.waitForSelector(OR.getProperty(locatorKey), new WaitForSelectorOptions().setTimeout(2000));

			ExtentListeners.getExtent().info("Finding an Element : " + locatorKey);
			return true;
		} catch (Throwable t) {

			ExtentListeners.getExtent().fail("Error while finding an Element : " + locatorKey);

			return false;
		}

	}

	public void type(String locatorKey, String value) {
		try {
			page.locator(OR.getProperty(locatorKey)).fill(value);
			ExtentListeners.getExtent()
					.info("Typing in an Element : " + locatorKey + " and entered the value as :" + value);
		} catch (Throwable t) {

			ExtentListeners.getExtent().fail(
					"Error while typing in an Element : " + t.getMessage() + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	
	public void select(String locatorKey, String value) {
		try {
			page.selectOption(OR.getProperty(locatorKey),new SelectOption().setLabel(value));
			ExtentListeners.getExtent()
					.info("Selecting an Element : " + locatorKey + " and selected the value as :" + value);
		} catch (Throwable t) {

			ExtentListeners.getExtent().fail(
					"Error while Selecting an Element : " + t.getMessage() + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	
	
	
	
	

}
