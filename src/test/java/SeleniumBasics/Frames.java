package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
	
	WebDriver driver;
	
	//@Test
	public void frameconcpet() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[contains(@style,'fe875d')]")).click();
		List<WebElement> totalFrame = driver.findElements(By.tagName("iframe"));
		for (int i=0;i<totalFrame.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> elementExist = driver.findElements(By.xpath("//*[contains(@style,'fe875d')]"));
			
			if(elementExist.size()>0)
			{
				driver.findElement(By.xpath("//*[contains(@style,'fe875d')]")).click();
				driver.switchTo().defaultContent();
			}
			driver.switchTo().defaultContent();
			
		}
	}
	
	@Test(priority=0)
	public void innerframeconcpet() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[contains(@style,'fe875d')]")).click();
		List<WebElement> totalFrame = driver.findElements(By.tagName("iframe"));
		for (int i=0;i<totalFrame.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> innertotalFrame = driver.findElements(By.tagName("iframe"));
			if (innertotalFrame.size()>0)
			{
			driver.switchTo().frame("frame2");
			List<WebElement> elementExist = driver.findElements(By.xpath("//*[contains(@style,'8e70ee')]"));
			
			if(elementExist.size()>0)
			{
				driver.findElement(By.xpath("//*[contains(@style,'8e70ee')]")).click();
				driver.switchTo().defaultContent();
			}
			}
			driver.switchTo().defaultContent();
			
		}
	}

}
