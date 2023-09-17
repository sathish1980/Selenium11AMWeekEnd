package SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
	
	WebDriver driver;
	@Test
		public void frameconcpet() throws InterruptedException, IOException
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://leafground.com/frame.xhtml");
			//Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[contains(@style,'fe875d')]")).click();
			screenshot("intial");
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
			screenshot("final");
		}
		

	public void screenshot(String name) throws IOException
	{
	
		TakesScreenshot scrn = (TakesScreenshot)driver;
		// scrn.getScreenshotAs(OutputType.FILE);
		File destination = scrn.getScreenshotAs(OutputType.FILE);
		 File newfile = new File(System.getProperty("user.dir")+"//Screenshot//"+name+".png");
		
		//FileUtils.copyFile((File)scrn, newfile);
		FileUtils.copyFile(destination, newfile);
	}
}
