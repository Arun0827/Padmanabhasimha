package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import input.ReadExcelData;
import output.WriteExcelData;
import pageClasses.CoursesPage;
import pageClasses.LandingPage;
import utilities.ExtentReportManager;

public class CourseraTest extends BaseTestClass{

	BaseTestClass baseTestClass;
	LandingPage landingPage;
	CoursesPage coursesPage;
	WriteExcelData writeExcelData;
	public String[] data;
	public ExtentReports report = ExtentReportManager.getReportInstance();


	@BeforeMethod(alwaysRun = true, groups = {"Smoke"})
	public void openBrowser() throws Exception {
		logger = report.createTest("Invoking the Browser");

		ReadExcelData readExcelData = new ReadExcelData();
		data = readExcelData.readExceldata1();
		invokeBrowser(data[0]);

	}

	@Test(groups = {"Regression"}, alwaysRun = true)
	public void coursesTest() throws Exception{
		logger = report.createTest("Getting Course Details");

		PageBaseClass pageBase = new PageBaseClass(driver,logger,prop);
		PageFactory.initElements( driver, pageBase);
		landingPage = pageBase.OpenApplication("WebsiteURL");
		landingPage.getTitle("LandingPageTitle");
		ReadExcelData readExcelData = new ReadExcelData();
		data = readExcelData.readExceldata1();
		landingPage.searchForCourses(data[1]);
		coursesPage = landingPage.clickOnSearch();
		coursesPage.getTitle("CoursesPageTitle");
		coursesPage.clickOnLevel();
		coursesPage.clickOnLevelType();
		coursesPage.clickOnLanguage();
		coursesPage.clickOnLanguageName();
		coursesPage.outClick();
		coursesPage.clickForCourses();

	}


	@AfterMethod(alwaysRun = true,groups = {"Smoke"})
	public void closingBrowser() {
		
		logger = report.createTest("Browser Closing");
		closeBrowser();

	}

	
}
