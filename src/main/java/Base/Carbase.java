package Base;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import ExtentListeners.ExtentListeners;

public class Carbase {

	
public Page page;
	
	public Carbase(Page page) {
		
		this.page = page;
	}
	
	
	
	public String getCarTitle(String title) {
	
		try {
		ExtentListeners.getExtent().info("Finding Car with Heading : " + title);
		return page.locator(BasePage.OR.getProperty("carTitle_XPATH")).innerText();
		}catch(Throwable t) {
			

			ExtentListeners.getExtent()
					.fail("Error while Finding Cars with Heading : " + title + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
			return null;
		}
		
	}
	
	
	public void getCarBrandNameAndPrices() {
		
	
		Locator carNames = page.locator(BasePage.OR.getProperty("carNames_XPATH"));
		Locator carPrices = page.locator(BasePage.OR.getProperty("carPrices_XPATH"));
		
		
		for(int i=0; i<carPrices.count(); i++) {
			
			System.out.println(carNames.nth(i).innerText()+"----Car price is : "+carPrices.nth(i).innerText());
			
		}
		
	}

	
	
	
}
