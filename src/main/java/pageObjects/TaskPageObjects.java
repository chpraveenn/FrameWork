package pageObjects;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class TaskPageObjects extends TestBase {

	By btn_addTask = By.xpath("//button[@class='btn btn-primary']|//button[text()='Add task']");
	By dd_SelectProjectforNewtaskcreation = By.id("form_projects_id");
	By dd_taskType = By.id("tasks_tasks_type_id");
	By txt_taskName = By.xpath("//*[@id='tasks_name']");
	By btn_save = By.xpath("//button[@type='submit' and  text()='Save']");
	By dd_taskLabel = By.xpath("//*[@id='tasks_tasks_label_id']");
	By dd_taskStatus = By.xpath("//*[@id='tasks_tasks_status_id']" );
	By dd_taskPriority = By.xpath("//*[@id='tasks_tasks_priority_id']" );
	
	
	By field_Search = By.xpath("//i[@class='fa fa-search']");
	By txt_Search = By.xpath("//*[@id='search_keywords']");
	By btn_Search = By.xpath("//input[@type='submit' and @value='Search']");

	public void crateTask() throws Throwable {
		
		
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_SelectProjectforNewtaskcreation),"NewTaskProjectDropDwon", "New Development - Internal WebSite");
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_taskType), "NewTask", "Defects (Hourly rate $0.00)");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_taskName), "newTaskName", "DemoTask");
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_taskStatus), "NewTaskStatus", "Open");
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_taskPriority), "NewTaskPriority", "Medium");
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_taskLabel), "NewTaskLabel", "Task");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_save), "NewTaskSaveButton");
	}
	
	
	public void Search_Verify_TaskCreationOnUI() throws Throwable {
		
		moveToElement_custom(DriverFactory.getInstance().getDriver().findElement(field_Search), "TaskSearchOption");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Search), "TaskSearchBox", "DemoTask");
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Search), "SearchButton");
		//table verification
		assertEqualsString_custom("DemoTask", getTaskTableCellValueByColumnName("Name"), "TaskNameInTable");

	}

	private String getTaskTableCellValueByColumnName(String columnName) {

		String valueXpath = "//table[starts-with(@id, 'itmes_listing')]/tbody/tr/td[count(//table[starts-with(@id, 'itmes_listing')]/thead/tr/th/div[text()='"+ columnName + "']/parent::th/preceding-sibling::th)+1]";
		String value = DriverFactory.getInstance().getDriver().findElement(By.xpath(valueXpath)).getText();
		return value;
	}

}
