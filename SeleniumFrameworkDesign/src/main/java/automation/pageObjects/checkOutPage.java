package automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.abstractCompo;

public class checkOutPage extends abstractCompo{

	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".ta-results button span")
	List<WebElement> c_List;
	@FindBy(className="action__submit")
	WebElement submit;
	
	By countryList= By.className("ta-results");
	
	public List<WebElement> enterCountry()
	{
		country.sendKeys("ind");
		elementToAppear(countryList);
		return c_List;
	}
	public WebElement selectCountryFromList()
	{
		enterCountry().stream().filter(c->c.getText().equalsIgnoreCase("India"))
				.findFirst().orElse(null).click();
		return country;
	}
	public confirmationPage submitOrder()
	{
		submit.click();
		return new confirmationPage(driver);
		
	}



}
