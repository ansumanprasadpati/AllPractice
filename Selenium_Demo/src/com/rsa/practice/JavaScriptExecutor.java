package com.rsa.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int sum=0;
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		List<WebElement> value=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i= 0; i< value.size();i++)
		{
			sum=sum+ Integer.parseInt(value.get(i).getText());
			
		}
		System.out.println(sum);
		String text=driver.findElement(By.className("totalAmount")).getText();
		int tValue=Integer.parseInt(text.split(":")[1].trim());	
		Assert.assertEquals(sum, tValue);
		
	}

}
