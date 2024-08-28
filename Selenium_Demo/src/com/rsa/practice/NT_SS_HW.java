package com.rsa.practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NT_SS_HW {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String>win=driver.getWindowHandles();
		Iterator<String> it=win.iterator();
		String pWin=it.next();
		String cWin=it.next();
		driver.switchTo().window(cWin);
		driver.get("https://rahulshettyacademy.com/");
		String txt=driver.findElement(By.partialLinkText("All-Access Membership"))
					.getText();
		driver.switchTo().window(pWin);
		WebElement nameField=driver.findElement(By.name("name"));
		nameField.sendKeys(txt);
		//Partial SS
		File file=nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File( "D://partialSS.jpeg"));
		//Height & Width
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
	}

}
