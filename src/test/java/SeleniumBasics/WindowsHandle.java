package SeleniumBasics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsHandle {
	
	WebDriver driver;
	@Test(priority=0)
	public void innerframeconcpet() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for(String eachwindow :allWindows)
		{
			if(!eachwindow.equals(parentWindow))
			{
				driver.switchTo().window(eachwindow);
				List<WebElement> element =driver.findElements(By.id("menuform:j_idt39"));
				if(element.size()>0)
				{
					driver.findElement(By.id("menuform:j_idt39")).click();
					driver.findElement(By.xpath("//*[@id='menuform:m_overlay']")).click();
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("j_idt88:j_idt91")));
					String Title = driver.getTitle();
					Assert.assertEquals(Title,"Alert");
					
					
				}
				driver.switchTo().window(parentWindow);
				driver.quit();
			}
		}
	}

	

}
