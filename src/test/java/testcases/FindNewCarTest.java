package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.NewCarPage;
import base.BaseTest;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class FindNewCarTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void findNewCars(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("CarWaleSuite", "findNewCars", data.get("Runmode"), excel);
		browser = getBrowser(data.get("browser"));
		navigate(browser,Constants.URL);
		
		
		
		HomePage home = new HomePage(page);
		home.findNewcar();
		NewCarPage cars = new NewCarPage(page);
		
		if(data.get("carBrand").equals("kia")) {
			
			cars.gotoKia();
		}else if(data.get("carBrand").equals("toyota")) {
			
			cars.gotoToyota();
		}else if(data.get("carBrand").equals("honda")) {
			
			cars.gotoHonda();
		}else if(data.get("carBrand").equals("bmw")) {
			
			cars.gotoBMW();
		}
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

}}
