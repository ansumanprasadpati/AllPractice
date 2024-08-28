package automation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.abstractCompo;

	public class orderPage extends abstractCompo{

		WebDriver driver;
		public orderPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
		List<WebElement> orderedItems; 
		@FindBy(css=".totalRow button")
		WebElement productTitles;
		
		public Boolean orderedItemsList(String prodName)
		{
			Boolean match=orderedItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(prodName));
			return match;
		}
		

}