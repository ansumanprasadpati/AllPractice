package com.rsa.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String P_id=it.next();
		String C_id=it.next();
		driver.switchTo().window(C_id).close();
		Thread.sleep(3);
	String cWindow_Text=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
	System.out.println(cWindow_Text);
		driver.switchTo().window(P_id);
	String pWindow_Text=driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		System.out.println(pWindow_Text);
		//driver.quit();
	}

}
