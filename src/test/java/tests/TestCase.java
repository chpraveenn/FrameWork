package tests;

import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.TaskPageObjects;
import testBase.TestBase;

public class TestCase extends TestBase{
	
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	TaskPageObjects taskPage = new TaskPageObjects();
	
//	@Test
//	public void testCase1() {
//		
//		//System.out.println("first test case");
//		//use ActionEngine methods
//		//sendKeys_Custom(driver.findElementBy(By.xpath()), "Email Field", "admin2@localhost.com");
//		//click_Custom(element, "Login Button ");
//		
//		loginPage.login("admin2@localhost.com", "admin@123");
//		
//	}
	
	@Test
	public void testCase2() throws Throwable {
		//step1 - Login 
		loginPage.login("admin2@localhost.com", "admin@123");
		
		//Step2 -check if Dashboard id opened
		
		homePage.checkIfDashBoardIsOpened();
				
		//step3- add task
		homePage.clickOnSideMenu("Tasks", "Add Task");
		
		taskPage.crateTask();
		taskPage.Search_Verify_TaskCreationOnUI();
		
		
	}
	
	}
