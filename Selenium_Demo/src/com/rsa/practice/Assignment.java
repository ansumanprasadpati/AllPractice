package com.rsa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		String labelName=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		System.out.println(labelName);
		WebElement dd=driver.findElement(By.name("dropdown-class-example"));
		Select s=new Select(dd);
		s.selectByVisibleText(labelName);
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(labelName);
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		String Text=driver.switchTo().alert().getText();
		if (Text.contains(labelName)) {
			System.out.println("Text is avaiable");
		}
		else
			System.out.println("Text is not available");
		driver.switchTo().alert().accept();
		driver.quit();
	}

}
