package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {

	WebDriver driver;
	@Test(priority=0)
	public void innerframeconcpet() throws InterruptedException
	{
		String expectedCountry = "India";
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		List<WebElement> allpages = driver.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=allpages.size();j++)
		//for(WebElement eachPage : allpages)
		{
		
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			
			driver.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			//eachPage.click();
			Thread.sleep(2000);
			
		
		
		
		// Per page 
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr"));
			for(int i=1;i<=allRows.size();i++)
			{
				String actualCountry = driver.findElement(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[2]//span[contains(@style,'vertical-align')]")).getText();
				if(expectedCountry.equalsIgnoreCase(actualCountry))
				{
					String representative = driver.findElement(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[3]//span[contains(@style,'vertical-align')]")).getText();
					System.out.println(representative);	
					String customerBadge = driver.findElement(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[5]//span[contains(@class,'customer-badge')]")).getText();
					System.out.println(customerBadge);	
			
				}
			}
		}
	}
}
