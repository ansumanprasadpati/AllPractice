package com.rsa.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asmnt_WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement tableDriver=driver.findElement(By.className("table-display"));
		int numberOfCloumns=tableDriver.findElements(By.tagName("th")).size();
		int numberOfRows=tableDriver.findElements(By.tagName("tr")).size();
		System.out.println(numberOfCloumns);
		System.out.println(numberOfRows);
		List<WebElement> data=tableDriver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(data.get(0).getText());
		System.out.println(data.get(1).getText());
		System.out.println(data.get(2).getText());
	}

}
