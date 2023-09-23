package com.lm2a;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalTest {
	
	private WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/lm2a/TRAINING-IT/Selenium+Cypress/webdrivers/chromedriver_mac64_114/chromedriver");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--headless");
		
		
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void test0() {
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		
		assertEquals(title, "Google");
	}
	
	
	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
