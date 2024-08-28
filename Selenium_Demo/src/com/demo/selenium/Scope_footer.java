package com.demo.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope_footer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		WebElement fDriver=driver.findElement(By.id("footer"));
		WebElement cDriver=fDriver.findElement(By.xpath("//footer[@id='footer']/div/div/div/div[1]/div[1]/div[1]/ul"));
		System.out.println(cDriver.findElements(By.tagName("a")).size());
		
		for(int i=0;i<cDriver.findElements(By.tagName("a")).size();i++)
		{
			String openInNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			cDriver.findElements(By.tagName("a")).get(i).sendKeys(openInNewTab);
		}
			Set <String> win=driver.getWindowHandles();
			Iterator <String> it=win.iterator();
			while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
		
	}

}
