package com.rsa.practice;
//import java.time.Duration;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.Select;

public class handlingElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		//Select option=new Select(WebElement);
		Thread.sleep(2000);
		int i=1;
		int k=1;
		while(i<3)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		Thread.sleep(2000);
		for(int j =0;j<4;j++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		Thread.sleep(2000);
		while(k<2)
		{
			driver.findElement(By.id("hrefIncInf")).click();
			k++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		driver.close();
	}

}
