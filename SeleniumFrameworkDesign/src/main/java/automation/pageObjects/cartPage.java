package automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.abstractCompo;

public class cartPage extends abstractCompo{

	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems; 
	@FindBy(css=".totalRow button")
	WebElement productTitles;
	
	public Boolean cartItemsList(String prodName)
	{
		Boolean match=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(prodName));
		return match;
	}
	public checkOutPage checkOutButton()
	{
		productTitles.click();
		checkOutPage cop=new checkOutPage(driver);
		return cop;
		
	}
	

}
