package com.demo.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/auto-complete.php");
	//	driver.findElement(By.linkText("JQuery Select dropdown")).click();
		driver.findElement(By.className("ui-autocomplete-input")).sendKeys("p");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for(WebElement option:options)
		{
			if(option.getText().contentEquals("PHP"))
			{
				option.click();
			}
		}
		
		}

}
