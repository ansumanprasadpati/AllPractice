package automation.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.pageObjects.cartPage;
import automation.pageObjects.checkOutPage;
import automation.pageObjects.confirmationPage;
import automation.pageObjects.productCatalogue;
import automation.testComponents.BaseClass;

public class errorValidation extends BaseClass{
	
	@Test(groups={"ErrorHandling"})
	public void catchErrorMessage()
	{
		lp.loginPageActions("ansu@xyz.com", "32974");
		lp.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
	}
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException {

		String prodName = "ZARA COAT 3";
		productCatalogue pc = lp.loginPageActions("ansu@xyz.com", "Ansuman1@3");
		List<WebElement> products = pc.listOfProducts();
		pc.addProdtoCart(prodName);
		cartPage cp = lp.goToCart();
		Boolean match=cp.cartItemsList("HSK");
		Assert.assertFalse(match);
	}

}
