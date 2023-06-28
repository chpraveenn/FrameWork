package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//to implement thread safe driver or synchronization
	//we should use Thread class synchronization methods 
	
	//instead of using synchronization methods we use ThreadLocal class
	
	//here we use two design patterns
	//singleton design pattern - only one instance exists ever, provide global access to use mulltiple time 
	//for this we can implement method by implementing  factory design pattern
	
	//avoiding creating an instance from other class - make it as private
	
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	public static DriverFactory getInstance() {
		return instance;
	}
	//up to above line singleton design pattern
	
	//implementing thread safe driver - synchronization
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
		
	}
	
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	
	public void closeBrowser() {
		driver.get().close();
		driver.remove(); //removes current threadlocal driver copy
	}
	
	
}
