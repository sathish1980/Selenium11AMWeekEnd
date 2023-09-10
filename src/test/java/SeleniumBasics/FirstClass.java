package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FirstClass {
	
	@Test
	public void Launch()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		driver.get("https://www.facebook.com/");
		/*driver.navigate().to("https://www.gmail.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();*/
		WebElement username = driver.findElement(By.cssSelector("input[data-testid='royal_email']"));
		username.sendKeys("sathish");
		//username.clear();
		driver.findElement(By.partialLinkText("gotten")).click();
		//or
		//driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("kumar.sathish");
		//driver.quit();
	}

}
