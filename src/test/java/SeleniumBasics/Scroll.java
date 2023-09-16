package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public void scrollimplementation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,-300)", "");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(500,0)", "");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(-500,0)", "");
		Thread.sleep(2000);
		
		//vertically bottom 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);
		
		//vertically top 
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		Thread.sleep(2000);
		
		WebElement startbutton=driver.findElement(By.id("form:j_idt119"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	
		
		
	
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scroll S = new Scroll();
		S.scrollimplementation();
	}

}
