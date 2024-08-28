package com.demo.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the form page
            driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");

            // Locate the input field (Name field in this example)
            WebElement nameField = driver.findElement(By.id("name"));

            // Locate the submit button
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

            // Click the submit button to trigger the validation tooltip
            submitButton.click();

            // Use JavaScript to get the validation message of the input field
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", nameField);

            // Assert that the validation message is "Please fill out this field."
            if (validationMessage.equals("Please fill out this field.")) {
                System.out.println("Validation tooltip is shown as expected: " + validationMessage);
            } else {
                System.out.println("Unexpected validation message: " + validationMessage);
            }
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}