package com.rsa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[text()='Link Hover']"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='p-15']/div[1]/div[1]"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='p-15']/div[1]/div[2]"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='p-15']/div[2]/div[2]"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.className("image-card"))).build().perform();

	}

}
