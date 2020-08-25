package newPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Courses {

	public static WebDriver driver ;
	
	@BeforeMethod(alwaysRun=true)
	public void openBrowser() {
		
		String url = "https://www.coursera.org/";
		//ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		//options.addArguments("--disable notifications");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test(priority = 1, groups = {"Smoke"})
	public void verifyPageTitle() {
		
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(),"Coursera | Build Skills with Online Courses from Top Institutions");
	}
	
	
	@Test(priority = 2, groups = {"Regression"})
	public void searchCourses() {
		
		driver.findElement(By.xpath("//div/input[@class='react-autosuggest__input']")).sendKeys("web development courses");
		driver.findElement(By.xpath("//div[@class='rc-AutoComplete horizontal-box']/button[2]/div[@class='magnifier-wrapper']")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		
		driver.close();
	}
}
