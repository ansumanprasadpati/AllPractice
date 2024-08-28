package com.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		//MultiCheckBox
		driver.findElement(By.id("box")).click();
		//SingleCheckBox
		driver.findElement(By.id("isAgeSelected")).click();
		String text=driver.findElement(By.id("txtAge")).getText();
		Assert.assertEquals(text, "Checked");
	}

}
