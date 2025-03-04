package automation.AbstractComponents;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.pageObjects.cartPage;
import automation.pageObjects.orderPage;

public class abstractCompo{
	
	WebDriver driver;
	public WebDriverWait w;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	@FindBy(css="[routerlink*=\"myorders\"]")
	WebElement myOrders;
	
	
	public abstractCompo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void elementToAppear(By by)
	{
		w= new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		
	}
	public void waitForWebElement(WebElement findby)
	{
		w= new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findby));
	}
	public cartPage goToCart()
	{
		//cartButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cartButton);
		return new cartPage(driver);
	}
	
	public void elementToDisappear(By by)
	{
		w= new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	public orderPage myOrderList()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", myOrders);
		return new orderPage(driver);
	}
	
	

}
