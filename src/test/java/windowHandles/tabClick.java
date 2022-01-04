package windowHandles;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(windowHandleListner.class)
public class tabClick extends BaseLaunch{
	SoftAssert a= new SoftAssert(); // soft Assertion
	
	@BeforeMethod
	
	public void setup()
	{
		initialization();
	}
	@AfterMethod
	public void tearDown()
	{    		
		driver.quit();			
	}

	
	@Test(priority=1)
	
	public void greenkartHome()
	{
		System.out.println(driver.findElement(By.cssSelector("div.greenLogo")).getText());
		String logo= driver.findElement(By.cssSelector("div.greenLogo")).getText();
			a.assertEquals(logo,"GREENKART");		
	}
	
 @Test(priority=2)

	public void documentpage() throws InterruptedException
	{
		driver.findElement(By.cssSelector(".blinkingText")).click();
		windowSwitching();  // window tab switching 
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		String emailid=driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	    System.out.println(emailid);
		driver.switchTo().window(parentid);
	    driver.findElement(By.cssSelector("input[type='search']")).sendKeys(emailid);
	   
		
	}
	
	@Test(priority=3)
	
	public void javaAlert() throws InterruptedException
	{
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#name")).sendKeys("kushal");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String alertText1= driver.switchTo().alert().getText();
		String expectedMsg=("Hello kushal, share this practice page and share your knowledge");
		a.assertEquals(alertText1, expectedMsg); //soft assertion
	// to handle java script popup
		driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector("input#name")).sendKeys("Rajaram");
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String actualText=driver.switchTo().alert().getText();
		String expectedText= ("Hello Rajaram, Are you sure you want to confirm?");
		
		a.assertEquals(actualText, expectedText); //soft assertion
		driver.switchTo().alert().accept();
		 a.assertAll();
      
		
	}
		
}

