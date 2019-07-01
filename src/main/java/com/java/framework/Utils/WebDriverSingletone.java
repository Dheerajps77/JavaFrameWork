package com.java.framework.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingletone {

	WebDriver driver;
	static WebDriverSingletone objWebDriverSingletone = null;

	public WebDriverSingletone() {
		
		driver=new ChromeDriver();

	}

	public static WebDriverSingletone getDriverSingletone() {
		try {

			if (objWebDriverSingletone == null) {
				objWebDriverSingletone = new WebDriverSingletone();
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}		
		return objWebDriverSingletone;
	}
	
	
	public WebDriver getDriver()
	{
		return driver;
	}
}
