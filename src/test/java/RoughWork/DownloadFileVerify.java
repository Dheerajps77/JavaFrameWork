package RoughWork;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.java.framework.Utils.EnvironmentPropertiesReader;

public class DownloadFileVerify {
	
	static EnvironmentPropertiesReader en=EnvironmentPropertiesReader.getInstance();;
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		
		String downloadedFilePath="C:\\Users\\dheeraj.singh\\Downloads";
		String url=en.getProperty("SpreadSheetURL");
		String browserPath=System.getProperty("user.dir")+en.getProperty("ChromeDriverPath");
		String downloadedFileName=en.getProperty("DownloadedFileName");
		
		VerifyDownloadFile(browserPath, url, downloadedFilePath, downloadedFileName);
	}
	
	public static void VerifyDownloadFile(String browserPath, String url, String downloadedFilePath, String downloadedFileName)
	{
		WebElement animatedColorsBtn;				
		try
		{									
			System.setProperty("webdriver.chrome.driver", browserPath);
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			
			animatedColorsBtn=driver.findElement(By.xpath("//a[text()='animatedcolors.xlsm']"));			
			wait=new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(animatedColorsBtn)).click();
			
			
			boolean b=GetLatestDownloadedFile(downloadedFilePath, downloadedFileName);
			
			if(b)
			{
				System.out.println("Downloaded file has been verified");
			}
			else
			{
				System.out.println("Not verified");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String format(long timeValue) {
		
	    DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	    Date time=new Date(timeValue);
	    String dateTimeConvertToString=dateFormatter.format(time);
	    return dateTimeConvertToString;
	  }
	
	public static boolean GetLatestDownloadedFile(String downloadedFilePath, String downloadedFileName)
	{
		boolean flag=false;
		File file;
		try
		{
			file=new File(downloadedFilePath);
			String downloadedFile="";
			String storeDownloadedFile="";
			File[] files=file.listFiles();
			int totalFilePresentAtDownload=files.length;
			for(int i=0;i<totalFilePresentAtDownload;i++)
			{
				downloadedFile=files[i].getName().toString().trim();
				String downloadedFileDateTime=format(files[i].lastModified());
				System.out.println(downloadedFile + " | " + downloadedFileDateTime);
				if(downloadedFile.equalsIgnoreCase(downloadedFileName))
				{
					flag=true;
					storeDownloadedFile=downloadedFile;
				}
			}
			if(flag)
			{
				System.out.println("Download file has been verified -> "+storeDownloadedFile);
			}
			else
			{
				System.out.println("Download file has not been verified");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
