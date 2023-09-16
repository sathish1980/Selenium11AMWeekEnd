package SeleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
	
	public void keyboard() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouse.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(2000);
		mouse.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
		
	}
	
	public void robotClass() throws AWTException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot R = new Robot();
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
		R.keyPress(KeyEvent.VK_ENTER);
		R.keyRelease(KeyEvent.VK_ENTER);
		R.keyPress(KeyEvent.VK_TAB);
		R.keyRelease(KeyEvent.VK_TAB);
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_V);
		R.keyRelease(KeyEvent.VK_CONTROL);
		R.keyRelease(KeyEvent.VK_V);
		
		
		
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		KeyboardActions K = new KeyboardActions();
		K.robotClass();
	}

}
