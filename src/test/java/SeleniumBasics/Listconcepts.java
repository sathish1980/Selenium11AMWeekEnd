package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Listconcepts {
	
	@Test
	public void Testcase1()
	{
		String tobeSelectedCountry = "USA";
		String selectedCountry = ListConcepts(tobeSelectedCountry);
		Assert.assertEquals(tobeSelectedCountry, selectedCountry+"1");
	}
	public String ListConcepts(String expectedCountry)
	{		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		driver.findElement(By.xpath("//div[@id='j_idt87:country']//*[contains(@class,'ui-selectonemenu-trigger')]")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//*[@id='j_idt87:country_items']//li)[last()]")));
		
		List<WebElement> allCountries = driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		for(WebElement eachcountries: allCountries)
		{
			String actualCountry = eachcountries.getText();
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachcountries.click();
				break;
			}
		}
		
		String visibleCountry = driver.findElement(By.xpath("//*[@id='j_idt87:country_label']")).getText();
		return visibleCountry;
	}

	

}
