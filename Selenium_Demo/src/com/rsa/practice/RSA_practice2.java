package com.rsa.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RSA_practice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);
		String act_Text=driver.findElement(By.tagName("p")).getText();
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(act_Text, "You are successfully logged in.");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);//
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password_Text=driver.findElement(By.cssSelector("form p")).getText();
		String[] pwd=password_Text.split("'");
		String actual_pwd=pwd[1].split("'")[0];
		return actual_pwd;
	}

}
