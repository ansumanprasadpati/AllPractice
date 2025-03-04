package com.rsa.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input[id*='Trip_1']")).click();
		driver.findElement(By.cssSelector("input[id*='Trip_0']")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
		driver.findElement(By.cssSelector("input[id*='originStation1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='IXM']"))
				.click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		while (i < 2) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		while (j < 3) {
			driver.findElement(By.id("hrefIncChd")).click();
			j++;
		}

		driver.findElement(By.xpath("//input[@value='Search']")).click();
		driver.close();
	}

}
