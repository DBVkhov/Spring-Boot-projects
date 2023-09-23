package com.lm2a;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigationTest {

	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	void navigator() {
		
		driver.navigate().to("http://www.google.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement elm = driver.findElement(By.id("W0wltc"));
		elm.click();
		
		WebElement elemento = driver.findElement(By.linkText("Gmail"));
		
		elemento.click();
		
		driver.navigate().back();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String titulo1 = driver.getTitle();
		
		System.out.println("Titulo1: "+titulo1);
		
		driver.navigate().forward();
		
		String titulo2 = driver.getTitle();
		
		System.out.println("Titulo2: "+titulo2);
		
		//driver.close();
		
	}
	
	
	@AfterEach
	public void tearDown() {
		//driver.quit();
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
