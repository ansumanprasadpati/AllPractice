package automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automation.AbstractComponents.abstractCompo;

public class productCatalogue extends abstractCompo{
	
	WebDriver driver;
	
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".offset-sm-1")
	List<WebElement>products;
	
	
	By prodListBy=By.cssSelector(".offset-sm-1");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg=By.id("toast-container");
	By animate= By.cssSelector(".ng-animation");
			
	public List<WebElement> listOfProducts()
	{
		elementToAppear(prodListBy);
		return products;
	}
	
	public WebElement getProductbyName(String prodName)
	{
		WebElement pro=listOfProducts().stream().filter(p->p.findElement(By.tagName("b"))
				.getText().equals(prodName)).findFirst().orElse(null);
		return pro;	
	}
	
	public cartPage addProdtoCart(String prodName)
	{	
		WebElement pro=getProductbyName(prodName);		
		pro.findElement(addToCart).click();
		elementToAppear(toastMsg);
		elementToDisappear(animate);
		cartPage cp=new cartPage(driver);
		return cp;
	}

}
