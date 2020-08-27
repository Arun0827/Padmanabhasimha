package testCases;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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


	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void openBrowser(String browser) throws Exception {
		logger = report.createTest("Invoking the Browser");

		//ReadExcelData readExcelData = new ReadExcelData();
		//data = readExcelData.readExceldata1();
		invokeBrowser(browser);

	}
	
	@Test(groups = {"Smoke"}, alwaysRun = true)
	public void validatePageTitles() throws Exception {
		
		logger = report.createTest("validation of Page Titles");
		
		PageBaseClass pageBase = new PageBaseClass(driver,logger,prop);
		PageFactory.initElements( driver, pageBase);
		landingPage = pageBase.OpenApplication("WebsiteURL");
		Assert.assertEquals(landingPage.getTitle(), "Coursera | Build Skills with Online Courses from Top Institutions");
		
	}

	@Test(priority = 1,groups = {"Regression"}, alwaysRun = true)
	public void coursesTest() throws Exception{
		logger = report.createTest("Getting Course Details");

		PageBaseClass pageBase = new PageBaseClass(driver,logger,prop);
		PageFactory.initElements( driver, pageBase);
		landingPage = pageBase.OpenApplication("WebsiteURL");
		
		ReadExcelData readExcelData = new ReadExcelData();
		data = readExcelData.readExceldata1();
		landingPage.searchForCourses(data[1]);

		coursesPage = landingPage.clickOnSearch();
		
		coursesPage.clickOnLevel();
		coursesPage.clickOnLevelType();
		coursesPage.clickOnLanguage();
		coursesPage.clickOnLanguageName();
		coursesPage.outClick();
		coursesPage.clickForCourses();

	}


	@AfterMethod(alwaysRun = true)
	public void closingBrowser() {
		
		logger = report.createTest("Browser Closing");
		closeBrowser();

	}

	
}
