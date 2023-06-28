package testBase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperations;

public class TestBase extends ActionEngine {
	
	BrowserFactoty bf = new BrowserFactoty();
	
	
	@BeforeMethod
	public void launchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");
		
		
		WebDriver driverInstance = bf.createBrowserInstance(browser);
		DriverFactory.getInstance().setDriver(driverInstance);
		WebDriver driver = DriverFactory.getInstance().getDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		
	}
	
	@AfterMethod
	public void tearDowm() {
		DriverFactory.getInstance().closeBrowser();
		
		
	}

}
