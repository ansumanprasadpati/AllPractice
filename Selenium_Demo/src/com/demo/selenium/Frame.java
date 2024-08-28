package com.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
		Actions a=new Actions(driver);
		driver.switchTo().frame("//div[@class='navbar__inner']/div[2]/div[3]/button");
		a.moveToElement(driver.findElement(By.xpath("//div[@class='navbar__inner']/div[2]/div[3]/button"))).build().perform();
	}

}
