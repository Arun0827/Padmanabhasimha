package newPackage;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedBus {
	public static WebDriver driver ;
	WriteExcelData writeExcelData;

	@BeforeMethod
	public void openBrowser() {

		String URL = "https://www.redbus.in/";
		//ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
		//options.addArguments("--disable notifications");
		driver = new InternetExplorerDriver();
		//driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
	}

	@Test
	public void testDropDown() {

		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upphoneCode")));

		Select dropdown = new Select(driver.findElement(By.id("upphoneCode")));

		dropdown.selectByVisibleText("502");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	


	@Test(priority = 1)
	public void testCalendar() {

		String month = "Sept 2021";
		String date ="9";

		driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();

		while (true) {
			String currentMonthYear = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"))
					.getText();

			if (currentMonthYear.equals(month)) {

				break;

			}

			else {
				driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button")).click();
			}

		}

		List <WebElement> dates = driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));

		for(WebElement element : dates) {

			if((element.getText()).equals(date)) {

				element.click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test(priority = 2)
	public void testScrolling() {

		WebElement scrollTo = driver.findElement(By.xpath("//*[@id='rh_footer']/div[3]/div/div/div[1]/div[4]/a[1]"));

		JavascriptExecutor js = (JavascriptExecutor)driver;

	    js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}


