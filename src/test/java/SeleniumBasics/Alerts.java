package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Alerts {
	
	WebDriver driver;
	@Test
	public void alertimplementation() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		//Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().accept();
		String getTextofAlert = driver.findElement(By.xpath("(//*[@class='card'])[1]//*[@id='simple_result']")).getText();
		Assert.assertEquals("You have successfully clicked an alert", getTextofAlert);
	
	driver.findElement(By.id("j_idt88:j_idt93")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().dismiss();
	String getTextofCancelAlert = driver.findElement(By.xpath("//*[@id='result']")).getText();
	Assert.assertEquals("User Clicked : Cancel", getTextofCancelAlert);

	driver.findElement(By.id("j_idt88:j_idt104")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().sendKeys("sathish");
	String textInalert = driver.switchTo().alert().getText();
	System.out.println(textInalert);
	driver.switchTo().alert().accept();
	
	driver.findElement(By.id("j_idt88:j_idt104")).click();
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	alert.sendKeys("Besant");
	String textInalert2 = alert.getText();
	System.out.println(textInalert2);
	alert.accept();
	
	
	Thread.sleep(1000);
	driver.findElement(By.id("j_idt88:j_idt95")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt98")));
	
	driver.findElement(By.id("j_idt88:j_idt98")).click();
	
	}

}
