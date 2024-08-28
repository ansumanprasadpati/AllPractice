package automation.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		String prodName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
		LandingPage lp=new LandingPage(driver);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("ansu@xyz.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ansuman1@3");
		driver.findElement(By.name("login")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".offset-sm-1")));
		List <WebElement> products=driver.findElements(By.cssSelector(".offset-sm-1"));
		WebElement pro=products.stream().filter(p->p.findElement(By.tagName("b"))
				.getText().equals(prodName)).findFirst().orElse(null);
		pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List <WebElement> cartItems=driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean pName=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(prodName));
		Thread.sleep(2000);
		//Assert.assertTrue(pName);		
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		WebElement country=driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
		country.sendKeys("ind");
		w.until(ExpectedConditions.visibilityOfElementLocated((By.className("ta-results"))));
		List<WebElement>c_List=driver.findElements(By.cssSelector(".ta-results button span"));
		c_List.stream().filter(c->c.getText().equalsIgnoreCase("India")).findFirst().orElse(null).click();
		driver.findElement(By.className("action__submit")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.hero-primary")));
		String thankyou_MSG=driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		Assert.assertTrue(thankyou_MSG.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
		
	}

}