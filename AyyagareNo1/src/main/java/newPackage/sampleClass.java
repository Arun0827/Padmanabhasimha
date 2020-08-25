package newPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampleClass {
	
public static WebDriver driver;
	
	@BeforeTest
	public void createDriver() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Arun\\eclipse-workspace\\AyyagareNo1\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
		
	}
	
	@Test
	public void mainMethod() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Web Development");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Level']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Beginner']//button")).click();
		driver.findElement(By.xpath("//div[text()='Language']")).click();
		driver.findElement(By.xpath("//div[@aria-label='English']//button")).click();
		Thread.sleep(2000);
		List<WebElement> nameElements=driver.findElements(By.xpath("//div[@class='card-content']"));
		for(int i=0;i<2;i++) {
			
			Thread.sleep(5000);
			//List<WebElement> nameElements=driver.findElements(By.xpath("//h2[@class='color-primary-text card-title headline-1-text']"));
			nameElements.get(i).click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			String name=driver.findElement(By.tagName("h1")).getText();
			String time=driver.findElement(By.xpath("//div[@class='_xliqh9g']//div[5]//div[2]//div[1]//span")).getText();
			String s=driver.findElement(By.xpath("//span[@class='_16ni8zai m-b-0 rating-text number-rating number-rating-expertise']")).getText();
			String[] arr=s.split("\n");
			String rating=arr[0];
			System.out.println(name + "  -->  " + time + "  -->  " + rating + " stars");
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));
			//Thread.sleep(7000);
		}
		
	}
	
	@AfterTest
	public void closeDriver() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}


}
















/*

public static WebDriver driver;

@BeforeTest
public void createDriver() throws Exception {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Arun\\eclipse-workspace\\AyyagareNo1\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.coursera.org/");
	
}

@Test
public void mainMethod() throws Exception {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Web Development");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Level']")));
	driver.findElement(By.xpath("//div[text()='Level']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Beginner']//button")).click();
	driver.findElement(By.xpath("//div[text()='Language']")).click();
	driver.findElement(By.xpath("//div[@aria-label='English']//button")).click();
	driver.findElement(By.xpath("//h6[@class='filter-by']")).click();
	Thread.sleep(6000);
	List<WebElement> nameElements=driver.findElements(By.xpath("//div[@class='card-content']"));

	for(int i=0;i<2;i++) {
		//List<WebElement> nameElements=driver.findElements(By.xpath("//h2[@class='color-primary-text card-title headline-1-text']"));

		nameElements.get(i).click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(6000);
		String name=driver.findElement(By.tagName("h1")).getText();
		//Thread.sleep(2000);
		String time=driver.findElement(By.xpath("//div[@class='_xliqh9g']//div[5]//div[2]//div[1]//span")).getText();
	//	Thread.sleep(2000);
		String s=driver.findElement(By.xpath("//span[@class='_16ni8zai m-b-0 rating-text number-rating number-rating-expertise']")).getText();
		String[] arr=s.split("\n");
		String rating=arr[0];
		System.out.println(name + "  -->  " + time + "  -->  " + rating);
		//Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
	}
	
}

@AfterMethod
public void closeDriver() throws Exception {
	//Thread.sleep(5000);
	driver.quit();
}
*/