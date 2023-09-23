package com.lm2a;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddPageTest {
	
	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	void addTest() {
		
		driver.manage().window().maximize();
		
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		
		WebElement sum1 = driver.findElement(By.id("sum1"));
		
		sum1.sendKeys("17");
		
		WebElement sum2 = driver.findElement(By.id("sum2"));
		
		sum2.sendKeys("23");
		
		WebElement button = driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
		
		button.click();
				
		WebElement result = driver.findElement(By.id("addmessage"));
		
		String r = result.getText();
		
		assertTrue("40".equals(r));
		
	}

	
	
	
	
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/lm2a/TRAINING-IT/Selenium+Cypress/webdrivers/chromedriver_mac64_114/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
