package SeleniumBasics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Download {
	
	WebDriver driver;
	public void downloadconcpet()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/grid.xhtml");
		driver.findElement(By.id("form:j_idt93")).click();
	}
	
	public void downloadintospecific()
	{
		Map<String, Object> ad = new HashMap<String, Object>();
		//ad.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "OutputFile" + File.separator + "downloadFiles");
		ad.put("download.default_directory",  "D:\\Besant\\JAVA\\");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", ad);
		options.addArguments("start-maximized");
		options.addArguments("--disable-Notifications");
		options.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/grid.xhtml");
		driver.findElement(By.id("form:j_idt93")).click();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Download D = new Download();
		D.downloadintospecific();
	}

}
