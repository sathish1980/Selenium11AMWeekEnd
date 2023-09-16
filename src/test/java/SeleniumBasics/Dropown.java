package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropown {

	public void dropdown() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://leafground.com/select.xhtml");
		browser.manage().window().maximize();
		Select drodown = new Select(browser.findElement(By.xpath("//*[@class='ui-selectonemenu']")));
		drodown.selectByIndex(2);
		Thread.sleep(2000);
		drodown.selectByVisibleText("Cypress");
		
	}
	
	public void DropdowninFacebook()
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		browser.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		Select dayDropdown =  new Select(browser.findElement(By.id("day")));
		dayDropdown.selectByIndex(11);
		Select monthDropdown =  new Select(browser.findElement(By.id("month")));
		monthDropdown.selectByValue("4");
		Select yearDropdown =  new Select(browser.findElement(By.id("year")));
		yearDropdown.selectByVisibleText("2000");	
	}
	
	public void multiselect()
	{
		WebDriver driver = new EdgeDriver();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select food = new Select(driver.findElement(By.xpath("//select[@id='second']")));
		
		if(food.isMultiple())
		{
			food.selectByIndex(3);
			food.selectByValue("donut");
			food.deselectByIndex(3);
			food.deselectAll();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropown D = new Dropown();
		D.DropdowninFacebook();
	}

}
