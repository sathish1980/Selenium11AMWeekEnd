package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public void mouseactions() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//*[text()='Electronics']"))).perform();
		Thread.sleep(1000);
		mouse.moveToElement(driver.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().perform();
	}
	
	public void facebookmouseactions() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}
	
	public void dragandDropBy() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement startbutton=driver.findElement(By.id("form:j_idt119"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]")), -50,10).perform();
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]")), -50,0).perform();
		
	}
	
	

	public void dragandDrop() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("form:drag_content"))).dragAndDrop(driver.findElement(By.id("form:drag_content")), driver.findElement(By.id("form:drop_header"))).perform();
	}

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.dragandDropBy();
	}

}
