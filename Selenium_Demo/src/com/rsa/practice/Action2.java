package com.rsa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Action2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']")))
			.click().keyDown(Keys.SHIFT).sendKeys("caps").build().perform();
		driver.findElement(By.id("showInput")).click();
		String msg=driver.findElement(By.id("message")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "CAPS");
		driver.quit();

	}

}
