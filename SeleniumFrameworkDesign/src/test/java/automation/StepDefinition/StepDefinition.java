package automation.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.pageObjects.LandingPage;
import automation.pageObjects.cartPage;
import automation.pageObjects.checkOutPage;
import automation.pageObjects.confirmationPage;
import automation.pageObjects.productCatalogue;
import automation.testComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	LandingPage lp;
	productCatalogue pc;
	checkOutPage cop;
	cartPage cp;
	confirmationPage conP;
	
	@Given("I landed on the eCommerce homePage")
	public void I_landed_on_the_eCommerce_homePage() throws IOException
	{
		lp=launchApp();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String name, String password)
	{
		pc=lp.loginPageActions(name, password);
	}
	@When("^I add product (.+) to the cart$")
	public void I_add_product_to_the_cart(String productName)
	{
		List<WebElement> products = pc.listOfProducts();
		pc.addProdtoCart(productName);
	}
	@And("^Go to checkout with the product (.+) and submit the order$")
	public void Go_to_checkout_with_the_product_and_submit_the_order(String productName)
	{
		cp = lp.goToCart();
		cp.cartItemsList(productName);
		cop = cp.checkOutButton();
		cop.enterCountry();
		cop.selectCountryFromList();
		conP = cop.submitOrder();
	}
	@Then("Then Confirmation message {string} message will display on ConfirmationPage")
	public void confirmation_message_display(String string) 
	{
		String getMessage = conP.confirmMessage();
		// Assert.assertTrue(pName);
		Assert.assertTrue(getMessage.equalsIgnoreCase(string)); 
	}

}
