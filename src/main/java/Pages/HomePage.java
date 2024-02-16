package Pages;

import com.microsoft.playwright.Page;

import Base.BasePage;

public class HomePage extends BasePage {
	
	
	
	public HomePage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void findNewcar() {
		
		mouseHover("newCar_XPATH");
		click("findNewCar_XPATH");
		
		//page.hover("//div[normalize-space()='NEW CARS']");

		
	}

}
