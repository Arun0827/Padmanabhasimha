package pageClasses;



import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass{

	public LandingPage(WebDriver driver,ExtentTest logger,Properties prop) {
		super(driver,logger,prop);
	}

	@FindBy(xpath = "//button[@type='button']/preceding-sibling::div/input[@type='text']")
	public WebElement searchBox;

	@FindBy(xpath = "//div[@class='rc-AutoComplete horizontal-box']/button[2]/div[@class='magnifier-wrapper']")
	public WebElement search;

	public LandingPage searchForCourses(String courseName) {

		try {
			logger.log(Status.INFO, "Entering course details");
			searchBox.sendKeys(courseName);
			logger.log(Status.PASS, "Successfully entered course details");
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		LandingPage landingPage = new LandingPage(driver,logger,prop);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	public CoursesPage clickOnSearch() {

		try {
			logger.log(Status.INFO, "clicking enter key");
			searchBox.sendKeys(Keys.ENTER);
			waitTime(6);
			logger.log(Status.PASS, "Successfully clicked on entered");
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;
	}

}
