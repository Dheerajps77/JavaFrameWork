package RoughWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollIntoViewDemo {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("http://anish-selenium.blogspot.com/p/scrollintoview-using-javascriptexecutor.html");
		
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,400)");
		
		WebElement button=driver.findElement(By.xpath("//input[@id='b1']"));		
		WebElement textboxUnderView=driver.findElement(By.xpath("//input[@id='input1']"));
		WebElement viewBox=driver.findElement(By.xpath("//div[@id='div1']"));
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", button);
		jsExecutor.executeScript("window.scrollBy(0,-200)");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", viewBox);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", textboxUnderView);
	}

}
