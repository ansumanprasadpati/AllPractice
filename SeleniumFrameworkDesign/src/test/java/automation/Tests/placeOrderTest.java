package automation.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.pageObjects.LandingPage;
import automation.pageObjects.cartPage;
import automation.pageObjects.checkOutPage;
import automation.pageObjects.confirmationPage;
import automation.pageObjects.orderPage;
import automation.pageObjects.productCatalogue;
import automation.testComponents.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class placeOrderTest extends BaseClass {
	String prodName;
	@Test (dataProvider="getData",groups= {"multiData"})
	public void placeOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		productCatalogue pc = lp.loginPageActions(input.get("email"),input.get("password"));
		List<WebElement> products = pc.listOfProducts();
		pc.addProdtoCart(input.get("prodName"));
		cartPage cp = lp.goToCart();
		cp.cartItemsList(input.get("prodName"));
		checkOutPage cop = cp.checkOutButton();
		cop.enterCountry();
		cop.selectCountryFromList();
		confirmationPage conP = cop.submitOrder();
		String getMessage = conP.confirmMessage();
		// Assert.assertTrue(pName);
		Assert.assertTrue(getMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods="placeOrder")
	public void orderHistory()
	{
		productCatalogue pc = lp.loginPageActions("ansu@xyz.com", "Ansuman1@3");
		orderPage op=pc.myOrderList();
		Assert.assertTrue(op.orderedItemsList(prodName));
	}
	
@DataProvider
public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map=new HashMap<String,String>();
//		map.put("email", "ansu@xyz.com");
//		map.put("password", "Ansuman1@3");
//		map.put("prodName", "ZARA COAT 3");
//		
//		HashMap<String, String> map1=new HashMap<String,String>();
//		map1.put("email", "demo@xyz.com");
//		map1.put("password", "Ansuman1@3");
//		map1.put("prodName", "IPHONE 13 PRO");
		List<HashMap<String,String>>data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//automation//dataSet//purchaseOrder.json");
		return new Object[][]{{data.get(0)},{data.get(1)}}; 
	}
	
	
	/*@DataProvider
	public Object[][] getData()
	{
		return new Object[][]{{"ansu@xyz.com","Ansuman1@3","ZARA COAT 3"},
			{"demo@xyz.com","Ansuman1@3","IPHONE 13 PRO"}};
	}*/

}