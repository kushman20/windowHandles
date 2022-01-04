package windowHandles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLaunch {

	public static WebDriver driver;
	String parentid;

	public static void initialization()
	{
		//Bonigracia webdriver manager , no need to add the binary file  
		WebDriverManager.chromedriver().setup();
	
		//System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	public void windowSwitching()
	{
		 
		Set<String> windowh= driver.getWindowHandles();// parentid, child id
		   Iterator<String> it= windowh.iterator();
		   
		   parentid= it.next();
		   String  childid= it.next();
		  driver.switchTo().window(childid);
	}
	
	public void failedScreenshot(String tmethodName)
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("D:\\testScreenshot\\"+"tabClick_"+tmethodName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
