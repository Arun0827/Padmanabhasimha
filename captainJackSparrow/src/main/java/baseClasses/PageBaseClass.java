package baseClasses;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageClasses.LandingPage;
import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass {


	public PageBaseClass(WebDriver driver,ExtentTest logger,Properties prop) {
		this.driver = driver;
		this.logger = logger;
		this.prop = prop;

	}

	public LandingPage OpenApplication(String websiteURL) {

		logger.log(Status.INFO, "Opening the WebSite");
		driver.get(prop.getProperty(websiteURL));
		logger.log(Status.PASS, "Successfully Opened the Coursera Website");
		LandingPage landingPage = new LandingPage(driver,logger,prop);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	public void clickFunction(WebElement element) {


		element.click();
	}

	public void waits(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitTime(int time) {

		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), prop.getProperty(expectedTitle));
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
			ScreenShot();

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}*/

	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		ScreenShot();
		//Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);

	}



	public void ScreenShot() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getdate() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getdate() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
