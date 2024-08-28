package com.rsa.practice;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreams_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver_win64/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List <WebElement>vegNames=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> collectedNames=vegNames.stream().map(vN->vN.getText()).collect(Collectors.toList());
		List<String>sortedName=collectedNames.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(sortedName.equals(collectedNames));
		List<String> price;
		//any particular name
		do {
		List <WebElement>veggies=driver.findElements(By.xpath("//tr/td[1]"));
		price=veggies.stream().filter(v->v.getText().contains("Rice"))
		.map(v->getPriceOfVeg(v)).collect(Collectors.toList());
		price.forEach(p->System.out.println(p));
		
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static String getPriceOfVeg(WebElement v) {
		// TODO Auto-generated method stub
		String priceVal=v.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceVal;
	}

}
