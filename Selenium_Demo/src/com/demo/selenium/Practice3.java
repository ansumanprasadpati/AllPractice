package com.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.cssSelector(".text-right.mt-20 button[type='submit']")).click();
		System.out.println(driver.switchTo().alert());

	}

}
