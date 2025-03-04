package automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.abstractCompo;

public class LandingPage extends abstractCompo{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement user_Email; //variable. different from argument which passed in FindBy annotation.
	@FindBy(id="userPassword")
	WebElement user_Password;
	@FindBy(id="login")
	WebElement submitButton;
	//WebElement loginButton=driver.findElement(By.name("login"));
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	//modifying the landing page URL.
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	//
	public productCatalogue loginPageActions(String email,String pwd)
	{
		user_Email.sendKeys(email);
		user_Password.sendKeys(pwd);
		submitButton.click();
		productCatalogue pc=new productCatalogue(driver);
		return pc;
	}
	public String getErrorMessage()
	{
		waitForWebElement(errorMessage);
		return errorMessage.getText();
	}
}
