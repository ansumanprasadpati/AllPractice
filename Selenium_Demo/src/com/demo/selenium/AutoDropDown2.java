package com.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropDown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
	//	driver.findElement(By.linkText("JQuery Select dropdown")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@aria-expanded='true']")).click();
		}

}
