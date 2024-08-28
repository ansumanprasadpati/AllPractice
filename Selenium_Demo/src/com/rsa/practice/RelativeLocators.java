package com.rsa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//above
		WebElement field=driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(field)).getText());
		
		//below
		WebElement b=driver.findElement(By.name("name"));
		driver.findElement(with(By.xpath("//input[@value='Submit']")).below(b)).click();
		
		//left
		WebElement left=driver.findElement(By.xpath("//label[@for='inlineRadio2']"));
		driver.findElement(with(By.id("inlineRadio2")).toLeftOf(left)).click();
		
		//right
		System.out.println(driver.findElement(with(By.xpath("//label[@for='inlineRadio3']")).toRightOf(left)).isSelected());
	}

}
