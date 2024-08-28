package com.demo.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import dev.failsafe.internal.util.Assert;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String text="Welcome to LambdaTest";
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.lambdatest.com/selenium-playground/");
		//driver.findElement(By.linkText("Simple Form Demo")).click();
		String linkName=driver.findElement(By.linkText("Simple Form Demo")).getText();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		Assert.assertEquals(linkName, "Simple Form Demo");
		Thread.sleep(2000);
		/*String URL=driver.getCurrentUrl();
		if(URL.contains("simple-form-demo"))
		{
			System.out.println("URL Validated successfully");
		}else
		{
			System.out.println("URL not validated");
		}*/
		
		//driver.findElement(By.id("user-message")).sendKeys("Welcome to LambdaTest");
		driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']")).sendKeys(text);		
		driver.findElement(By.id("showInput")).click();
		String msg =driver.findElement(By.id("message")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg, text);
		
	}

}
