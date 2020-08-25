package newPackage;



import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightsBooking{
	public static WebDriver driver;

	public void browserSelect(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			Assert.fail("Invalid input : select the browsers only from chrome, IE, Firefox");
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void enterUrl(String url) {
		driver.get(url);
	}

	public void clickTextBox(String element) {
		getMethod(element).click();
	}

	public void enterText(String element, String city) {
		getMethod(element).sendKeys(city);
	}


	public WebElement getMethod(String element) {
		WebElement a = null;
		a = driver.findElement(By.xpath(element));

		return a;
	}

	public void ListBox(String element, int b) {
	     Elements(element).get(b);

	}

	public List<WebElement> Elements(String element) {
		List<WebElement> c = driver.findElements(By.xpath(element));

		return c;
	}

	public void getText(String element, int b) {
		
		for (int i = 0; i < b; i++) {
			System.out.println(Elements(element).get(i).getText());
		}

	}

	public static void calendarBox(String date) {
		Date currentDate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date expectedDate = dateformat.parse(date);
			
			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);

			String expectedMonthYear = month + " " + year;

			while (true) {
				String currentMonthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div"))
						.getText();
				
				if (expectedMonthYear.equals(currentMonthYear)) {
					int day1=Integer.parseInt(day.trim());
					if(day1<10) {
						int rem=day1%10;
						driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()='" + rem + "']")).click();
						break;
					}else {

					driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()='" + day + "']")).click();
					break;
				}
				}

				else if (expectedDate.compareTo(currentDate) > 0) {
					driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")).click();
				} else {
					driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[1]")).click();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void waits() {
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		//driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//WebElement dang= wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}