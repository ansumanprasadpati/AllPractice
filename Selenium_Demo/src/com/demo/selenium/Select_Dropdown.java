package com.demo.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class Select_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.linkText("Select Dropdown List")).click();
		Thread.sleep(1000);
		WebElement static_dropdown=driver.findElement(By.id("select-demo"));
		Select dropdown=new Select(static_dropdown);
		dropdown.selectByValue("Tuesday");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(5);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("Sunday");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.close();
	}

}
