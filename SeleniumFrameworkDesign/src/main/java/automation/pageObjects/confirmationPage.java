package automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.abstractCompo;

public class confirmationPage extends abstractCompo{
	
	WebDriver driver;

	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="h1.hero-primary")
	WebElement verifyMSG;
	By confirmMSG=By.cssSelector("h1.hero-primary");
	
	public String confirmMessage()
	{
		elementToAppear(confirmMSG);
		return verifyMSG.getText();
	}

}
