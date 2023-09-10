package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxAndRadiobutton {
	
	public void checkBox(String[] expectedCourses)
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://leafground.com/checkbox.xhtml");
		browser.manage().window().maximize();
		browser.findElement(By.xpath("//*[starts-with(@class,'ui-chkbox-box')]//parent::div[@id='j_idt87:j_idt89']")).click();
		
		List<WebElement> allCourses = browser.findElements(By.xpath("//*[@id='j_idt87:basic']//tr//td"));
		for(int i=1;i<allCourses.size();i++)
		{
			String actualCourse = browser.findElement(By.xpath("//*[@id='j_idt87:basic']//tr//td["+i+"]//label")).getText();
			for(String expectedCourse : expectedCourses)
			{
			if(expectedCourse.equalsIgnoreCase(actualCourse))
			{
				browser.findElement(By.xpath("//*[@id='j_idt87:basic']//tr//td["+i+"]//div[contains(@class,'ui-corner-all')]")).click();
				//break;
			}
			}
		}
		
		browser.findElement(By.xpath("//*[@class='ui-toggleswitch-slider']")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui-growl-title']")));
		String actualToast = browser.findElement(By.xpath("//*[@class='ui-growl-title']")).getText();
		System.out.println(actualToast);
		wait.until(ExpectedConditions.invisibilityOf(browser.findElement(By.xpath("//*[@class='ui-growl-title']"))));
		
		browser.findElement(By.xpath("//*[@class='ui-toggleswitch-slider']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui-growl-title']")));
		String actualToast1 = browser.findElement(By.xpath("//*[@class='ui-growl-title']")).getText();
		System.out.println(actualToast1);
		
	}

	
	public void radiobutton()
	{
		int count=0;
		WebDriver browser = new EdgeDriver();
		browser.get("https://leafground.com/radio.xhtml");
		browser.manage().window().maximize();
		List<WebElement> allBrowser = browser.findElements(By.xpath("//*[@id='j_idt87:console2']//td//div[contains(@class,'ui-radiobutton-box')]"));
		for(WebElement eachWebelement:allBrowser)
		{
			count=count+1;
			String className =eachWebelement.getAttribute("class");
			if(className.contains("ui-state-active"))
			{
				System.out.println("The default selection is At "+ count+ " position");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckboxAndRadiobutton c = new CheckboxAndRadiobutton();
		String[] expectedCourse ={"Python","C-sharp"};
		c.checkBox(expectedCourse);
		c.radiobutton();
	}

}
