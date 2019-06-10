package RoughWork;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

	public static void PieChart(WebDriver driver, Actions actions) {
		try {

			List<WebElement> colors=driver.findElements(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')]"));
			WebElement ToolTip = driver.findElement(By.xpath("//div[contains(@id,'_tooltip')]"));

			int totalCountOfColorsInPieChart=colors.size();
			System.out.println("-X-X-X-X-X-X-X-X- Colors present in PieChart -X-X-X-X-X-X-X-X-");
			
			for(int i=1;i<=totalCountOfColorsInPieChart;i++)
			{
				WebElement colorElement=driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')]["+i+"]"));
				
				actions=new Actions(driver);
				actions.moveToElement(colorElement).build().perform();
				String colorsStringValue=ToolTip.getText();
				System.out.println(colorsStringValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		String pieURL = "https://yuilibrary.com/yui/docs/charts/charts-pie.html";
		String barURL = "https://yuilibrary.com/yui/docs/charts/charts-dualaxes.html";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dheeraj.singh\\git\\JavaFrameWork\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(pieURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);		
		Actions actions = null;
		 PieChart(driver, actions);
		//BarGraph(driver, actions);
	}
}
