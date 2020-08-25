package newPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class Flights {
	WebDriver driver = null;

//@Parameters("browser")
@BeforeMethod
public void openBrowser(String browser) {
	
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiran Kumar\\eclipse-workspace\\maven-project\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Kiran Kumar\\eclipse-workspace\\maven-project\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();

	}
	else if(browser.equalsIgnoreCase("ie")){
		System.setProperty("webdriver.ie.driver","C:\\Users\\Kiran Kumar\\eclipse-workspace\\maven-project\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

	}
	else {
		System.out.println("select a valid browser from chrome, IE, Firefox");
	}

}

	@Test
	public void flightBooking() {

		driver.get("http://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='departure']")));
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(
				By.xpath("//div[1][@class='DayPicker-Month']/div[3]/div[3]/div[@aria-label='Fri Apr 17 2020']"))
				.click();
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='sorting-togglers']/div[5]/span")).click();
		List<WebElement> flightName = driver.findElements(By.xpath(
				"//div[@class='fli-intl-lhs pull-left']/div/div[@class='fli-list one-way']/div/div/div/div/div/div/div[2]/p[1]/span"));
		String name1 = flightName.get(0).getText();
		String name2 = flightName.get(1).getText();
		String name3 = flightName.get(2).getText();
		String name4 = flightName.get(3).getText();
		String name5 = flightName.get(4).getText();
		List<WebElement> PriceList = driver.findElements(By.xpath(
				"//div[@class='fli-intl-lhs pull-left']/div/div[@class='fli-list one-way']/div/div/div/div/div/div[3]/p/span"));
		String price1 = PriceList.get(0).getText();
		String price2 = PriceList.get(1).getText();
		String price3 = PriceList.get(2).getText();
		String price4 = PriceList.get(3).getText();
		String price5 = PriceList.get(4).getText();
		System.out.println("1. " + name1 + "   Price is " + price1);
		System.out.println("2. " + name2 + "   Price is " + price2);
		System.out.println("3. " + name3 + "   Price is " + price3);
		System.out.println("4. " + name4 + "   Price is " + price4);
		System.out.println("5. " + name5 + "   Price is " + price5);
	}

	@AfterMethod
		 public void quitBrowser()
	{
		driver.quit();
	}

}
