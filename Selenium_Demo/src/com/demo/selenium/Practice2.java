package com.demo.selenium;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		System.out.println(driver.findElement(By.id("slider3")).getText());
		WebElement slider=driver.findElement(By.id("slider3"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(slider, 168,0).perform();
		String text=driver.findElement(By.id("rangeSuccess")).getText();
		Assert.assertEquals(text, "95");
	}
		
}