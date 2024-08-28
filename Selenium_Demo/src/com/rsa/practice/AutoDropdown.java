package com.rsa.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input[placeholder='Type to Select']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
			}
		}
	}

}
