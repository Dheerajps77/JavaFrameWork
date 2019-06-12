package RoughWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class PieChartInSelenium {

	public static void BarGraph(WebDriver driver, Actions actions) {
		try {
			
			List<WebElement> monthSales=driver.findElements(By.xpath("//*[@fill='#6084d0']"));
			List<WebElement> monthRevenue=driver.findElements(By.xpath("//*[@fill='#eeb647']"));
					
			// locate tooltip pie chart.
			WebElement ToolTip = driver.findElement(By.xpath("//div[contains(@id,'_tooltip')]"));
			
			int countOfMonthSale=monthSales.size();
			System.out.println("total number of months sale are : --> " + countOfMonthSale);
			
			System.out.println("-X-X-X-X-X-X-X-X- Month Internet Sale -X-X-X-X-X-X-X-X-");
			for(int i=1;i<=countOfMonthSale;i++)
			{
				WebElement monthSalesNumber=driver.findElement(By.xpath("//*[@fill='#6084d0']["+i+"]"));				
				actions = new Actions(driver);
				actions.moveToElement(monthSalesNumber).build().perform();
				String monthSalesValue= ToolTip.getText();
				System.out.println(monthSalesValue);				
			}
			

			int countOfMonthRevenue=monthSales.size();
			System.out.println("total number of months sale are : --> " + countOfMonthRevenue);
			System.out.println("-X-X-X-X-X-X-X-X- Month Total Revenue -X-X-X-X-X-X-X-X-");
			for(int i=1;i<=countOfMonthRevenue;i++)
			{
				WebElement monthRevenueNumber=driver.findElement(By.xpath("//*[@fill='#eeb647']["+i+"]"));				
				actions = new Actions(driver);
				actions.moveToElement(monthRevenueNumber).build().perform();
				String monthRevenueValue= ToolTip.getText();
				System.out.println(monthRevenueValue);				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> PieChart(WebDriver driver, Actions actions) {
		
		ArrayList<String> arryList=new ArrayList<String>();
		try {

			List<WebElement> colors=driver.findElements(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')]"));
			WebElement ToolTip = driver.findElement(By.xpath("//div[contains(@id,'_tooltip')]"));

			int totalCountOfColorsInPieChart=colors.size();	
			System.out.println("Total blocks of pie chart are as : --> ");
			for(int i=1;i<=totalCountOfColorsInPieChart;i++)
			{
				WebElement colorElement=driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')]["+i+"]"));
				
				actions=new Actions(driver);
				actions.moveToElement(colorElement).build().perform();
				String colorsStringValue=ToolTip.getText();				
				arryList.add(colorsStringValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arryList;
	}
	
	public static void PieChartReader(WebDriver driver, Actions action)
	{
		try {
			
			ArrayList<String> arrayList=PieChart(driver, action);		
			Iterator<String> iterator=arrayList.iterator();
			System.out.println("-X-X-X-X-X-X-X-X- Colors present in PieChart -X-X-X-X-X-X-X-X-");
			while(iterator.hasNext())
			{
				String value=iterator.next();
				System.out.println(value);
			}
			
		} catch (Exception e) {
			
		}
	}
	
	
	public static void innerTextHTMLModification(WebElement element , WebDriver driver)
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("var ele=arguments[0]; ele.innerHTML = 'Hu';", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void PieChartModification(WebDriver driver, Actions action)
	{
		try {
			
			driver.findElement(By.xpath("//*[@id='gc-wrapper']/div[2]/article/article/div[2]/form[1]/input[1]")).click();
			WebElement runButton=driver.findElement(By.xpath("//a[@class='aiButton' and @id='run']"));			
			WebElement blueColor=driver.findElement(By.xpath("//*[@id='editor']/div[1]/div[3]/div[2]/div[6]/div[1]/div/div/div/div[5]/div[18]/pre/span/span[1]"));	
			innerTextHTMLModification(blueColor, driver);
			Thread.sleep(2000);
			runButton.click();			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='result']")));
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		String pieChartURL = "https://yuilibrary.com/yui/docs/charts/charts-pie.html";
		String barURL = "https://yuilibrary.com/yui/docs/charts/charts-dualaxes.html";
		String pieChartURL1="https://developers.google.com/chart/interactive/docs/basic_multiple_charts";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dheeraj.singh\\git\\JavaFrameWork\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(pieChartURL1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);		
		Actions actions = null;
		//BarGraph(driver, actions);
		//PieChartReader(driver, actions);
		PieChartModification(driver, actions);
	}
}
