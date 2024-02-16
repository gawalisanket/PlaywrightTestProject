package Pages;

import com.microsoft.playwright.Page;

import Base.BasePage;

public class NewCarPage extends BasePage {
	
	

	
	
	public NewCarPage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void gotoHonda()
	{
		page.click("//div[text()='Honda']");
		
	}
	
	public void gotoKia()
	{
		page.click("//div[text()='Kia']");
	}
	
	public void gotoToyota()
	{
		page.click("//div[text()='Toyota']");
	}
	
	public void gotoBMW()
	{
		page.click("//div[text()='BMW']");
	}

}
