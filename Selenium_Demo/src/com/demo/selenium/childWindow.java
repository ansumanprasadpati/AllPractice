package com.demo.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class childWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		driver.findElement(By.linkText("Follow us On Linkedin")).click();
		Set<String> win=driver.getWindowHandles();
		Set<String> c_Window=driver.getWindowHandles();
		Iterator<String> it=c_Window.iterator();
		String parent_Window=it.next();
		String child_Window=it.next();
		Thread.sleep(3);
		driver.switchTo().window(child_Window);
		driver.manage().window().maximize();
		Thread.sleep(2);
		driver.findElement(By.xpath(("button[@aria-label='Dismiss'])[3]"))).click();
		
		
	}

}
