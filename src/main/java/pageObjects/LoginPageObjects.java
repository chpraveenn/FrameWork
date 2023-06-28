package pageObjects;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase {
	
	By EMAIL = By.xpath("//input[@name='login[email]']"); 
	By PASSWORD = By.xpath("//input[@name='login[password]']");
	By login_button = By.xpath("//button[text()='Login ']");
	
	
	
//	////form[@class='login-form']/div/div/i/following-sibling::input[@name='login[email]']
//	@FindBy(xpath="")
//	WebElement txt_email;
//	
//	//form[@class='login-form']/div/div/i/following-sibling::input[@name='login[password]']
//	 @FindBy(xpath="//input[@name='login[password]']")
//	 WebElement txt_password;
//	 
//	//div[@class='form-actions']/label/following-sibling::button[text()='Login ']
//	 
//	 @FindBy(xpath = "")
//	 WebElement btn_login;
//	 
//	 //Initializing all page objects for given driver instance
//	 public LoginPageObjects(WebDriver driver ) {
//		 PageFactory.initElements(driver, this);
//	 }
	 
	 public void login(String email, String password) {
		 
		 sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(EMAIL), "LoginEmailField", email);
		 sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(PASSWORD), "LoginEmailField", password);
		 click_custom(DriverFactory.getInstance().getDriver().findElement(login_button), "LoginButton");
	 }
	 
 
}
