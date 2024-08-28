package com.demo.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class chatGPT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://chatgpt.com/");
		driver.findElement(By.xpath("//textarea[contains(@placeholder,'ChatGPT')]")).sendKeys("Hello");
		driver.findElement(By.xpath("//div[@class='flex items-end gap-1.5 md:gap-2']/button[1]")).click();

	}

}
