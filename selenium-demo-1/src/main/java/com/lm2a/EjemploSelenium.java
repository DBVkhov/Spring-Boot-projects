package com.lm2a;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EjemploSelenium {


	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\wolfe\\Desktop\\edgedriver_win32 (1)\\msedgedriver.exe");
		
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		
		WebDriver driver = new EdgeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		driver.get("https://www.freerangetesters.com/cursos");
		
		System.out.println("Sitio web abierto...");
		
		String title = driver.getTitle();
		
		System.out.println("Titulo del sitio: "+title);
		
		driver.close();

	}

}
