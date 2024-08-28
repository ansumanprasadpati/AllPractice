package com.rsa.practice;

import java.time.Duration;
import java.util.Arrays;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.support.ui.ExpectedConditions;

//import org.openqa.selenium.support.ui.WebDriverWait;

public class eCommerceKart {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		WebElement promoInfo=driver.findElement(By.cssSelector("span.promoInfo"));
		w.until(ExpectedConditions.visibilityOf(promoInfo));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded)

	{

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

//Brocolli - 1 Kg

//Brocolli,    1 kg

			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

//format it to get actual vegetable name

//convert array into array list for easy search

//  check whether name you extracted is present in arrayList or not-

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{

				j++;

//click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length)

				{

					break;

				}

			}

		}

	}

}
