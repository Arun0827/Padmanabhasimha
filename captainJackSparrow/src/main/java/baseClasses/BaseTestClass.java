package baseClasses;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportManager;

public class BaseTestClass {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public Properties prop;

	public void invokeBrowser(String browserName) {

		logger.log(Status.INFO, "Launching the browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		logger.log(Status.PASS, "Successfully launched the browser");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		if(prop == null) {

			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\objectRepository\\project.Config.properties");
				prop.load(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void closeBrowser() {
		
		logger.log(Status.INFO, "Closing the browser");
		report.flush();
		driver.quit();

	}
}