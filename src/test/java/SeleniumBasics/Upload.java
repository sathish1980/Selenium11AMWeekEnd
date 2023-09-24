package SeleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Upload {
	WebDriver driver;
	@Test(priority=0)
	public void innerframeconcpet() throws InterruptedException, AWTException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cleartax.in/paytax/UploadForm16");
		driver.findElement(By.xpath("(//div[@class='hidden-xs']//div)[1]")).click();
		String expectedFileName ="BDD Cheatsheat.pdf";
		StringSelection str = new StringSelection("D:\\Besant\\JAVA\\"+expectedFileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		String actualFileName = driver.findElement(By.className("input-file-upload-hover-placeholder")).getText();
		Assert.assertEquals(actualFileName,expectedFileName);
	}
}
