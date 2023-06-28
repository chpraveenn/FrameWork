package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects  extends TestBase{

	WebDriver driver = null;
	
	
	By sidebarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Dashboard']"); 

//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Dashboard']")
//	WebElement sidebarMenu_dashboard;

//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Projects']")
//	WebElement sidebarMenu_Projects;
//
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Projects']/ancestor::a/following-sibling::ul//span[text()='View All']")
//	WebElement sideMedu_Projects_ViewAll;	
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Projects']/ancestor::a/following-sibling::ul//span[text()='Add Project']")
//	WebElement sideMedu_Projects_AddProject;
//
	
	By sidebarMenu_Tasks = By.xpath("//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Tasks']");
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Tasks']")
//	WebElement sidebarMenu_Tasks;

	By sideMedu_Tasks_ViewAll = By.xpath("//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Tasks']/ancestor::a/following-sibling::ul//span[text()='View All']");
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Tasks']/ancestor::a/following-sibling::ul//span[text()='View All']")
//	WebElement sideMedu_Tasks_ViewAll;

	By sideMedu_Tasks_AddTask = By.xpath("//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Tasks']/ancestor::a/following-sibling::ul//span[text()='Add Task']");
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Tasks']/ancestor::a/following-sibling::ul//span[text()='Add Task']")
//	WebElement sideMedu_Tasks_AddTask;
//
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Users']")
//	WebElement sidebarMenu_Users;
//
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Users']/ancestor::a/following-sibling::ul//span[text()='View All']")
//	WebElement sideMedu_Users_ViewAll;
//
//	@FindBy(xpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='Users']/ancestor::a/following-sibling::ul//span[text()='Add Task']")
//	WebElement sideMedu_Users_AddUser;

//	public HomePageObjects(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//		this.driver = driver;
//	}

	// like the following method, we can implement for all the menu items
//	public void clickOnTheTaskM() {
//		sidebarMenu_Tasks.click();
//	}
	// but instead of creating various methods like that we create one method
	// call the method by pass menu item as parameter

	public void clickOnSideMenu(String menu) {
		String menuXpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='" + menu + "]";
		driver.findElement(By.xpath(menuXpath)).click();

	}
	
	
	public void clickOnSideMenu(String menu, String subMenu) {
		String menuXpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='"+menu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
		String subMenuXpath = "//ul[@class='page-sidebar-menu']/li/a/i/following-sibling::span[text()='" + menu + "']/ancestor::a/following-sibling::ul//span[text()='"+subMenu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(subMenuXpath)).click();

	}
	
	public void checkIfDashBoardIsOpened() {
		Assert.assertTrue(isElementPresent_custom(DriverFactory.getInstance().getDriver().findElement(sidebarMenu_Dashboard), "DashBoardMenu"));
		
		
	}

}
