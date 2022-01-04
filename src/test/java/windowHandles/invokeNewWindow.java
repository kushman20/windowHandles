package windowHandles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.log4testng.Logger;


public class invokeNewWindow {

	public static void main(String[] args) throws InterruptedException {
		Logger log= Logger.getLogger(invokeNewWindow.class);
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.info("launch Url");
		//the below line of code will invoke new tab and now we need to set focus to new window
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.switchTo().newWindow(WindowType.TAB); // or can switch to new tab commented
	
		//below will create a set of id to handle both tab
		  Set<String> gwh= driver.getWindowHandles();
		 Iterator<String> ite = gwh.iterator();
	 
		String parentid= ite.next(); // parent index 0
		String childid= ite.next();// child index 1
		//String third= ite.next(); //third tab
		
		driver.switchTo().window(childid); // focus set to child tab
		driver.get("https://rahulshettyacademy.com/#/documents-request"); // url launched in child tab
		System.out.println(driver.getTitle()); // console print
		driver.switchTo().window(parentid);// focus set to parent tab
		System.out.println(driver.getTitle());// console print
		Thread.sleep(1000);
		
		WebElement search=driver.findElement(By.cssSelector("[type='search']"));
		search.sendKeys("Brocolli");
		
		// take screenshot of that search box
		//***********************************
		
/*		File source= search.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File("D:\\testScreenshot\\textbox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		 driver.quit();// close all tab
		
	}
}
