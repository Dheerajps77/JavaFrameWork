package com.java.framework.TestClasses;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.framework.Utils.StoringImagesDynamically;

import net.sourceforge.tess4j.Tesseract;

public class ImageStoreBasisOnWebElement {
	
	private WebDriver driver;
	 
    @BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\dheeraj.singh\\git\\JavaFrameWork\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        
		// navigate to the dummy page with a barcode image
        driver.get("https://www.seleniumeasy.com/selenium-tutorials/allure-report-example-with-annotations#comment-19369");
    }
 
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
 
    @Test
    public void ImageReader() throws Exception {
        // get and capture the picture of the img element used to display the barcode image
        WebElement image = driver.findElement(By.xpath("//section[@id='block-block-63']//p//a//img"));
        File imageFile = StoringImagesDynamically.captureElementPicture(image);
 
        // get the Tesseract direct interace
        Tesseract instance = new Tesseract();
 
        // the doOCR method of Tesseract will retrive the text
        // from image captured by Selenium
        String result = instance.doOCR(imageFile);
 
        // check the the result
        Assert.assertEquals("CrossBrowserTesting", "CrossBrowserTesting", result.trim());
    }

}
