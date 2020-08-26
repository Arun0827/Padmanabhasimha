package pageClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import output.WriteExcelData;

public class CoursesPage extends PageBaseClass {


	public CoursesPage(WebDriver driver,ExtentTest logger,Properties prop) {
		super(driver,logger,prop);

	}

	@FindBy(xpath = "//div[text()='Level']")
	public WebElement level;

	@FindBy(xpath = "//div[@aria-label='Beginner']//button")
	public WebElement levelType;

	@FindBy(xpath = "//div[text()='Language']")
	public WebElement language;

	@FindBy(xpath = "//div[@aria-label='English']//button")
	public WebElement languageName;

	@FindBy(xpath = "//h6[@class='filter-by']")
	public WebElement outclick;

	@FindBy(xpath = "//div[@class='card-content']")
	public List<WebElement> listOfCourses;

	@FindBy(tagName = "h1")
	public WebElement courseTitle;

	@FindBy(xpath = "//div[@class='_xliqh9g']//div[5]//div[2]//div[1]//span")
	public WebElement courseDuration;

	@FindBy(xpath = "//span[@class='_16ni8zai m-b-0 rating-text number-rating number-rating-expertise']")
	public WebElement courseRating;

	public CoursesPage clickOnLevel() {

		try {
			logger.log(Status.INFO, "clicking on level box");
			clickFunction(level);
			logger.log(Status.PASS, "Succesfully clicked on level box");
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;
	}

	public CoursesPage clickOnLevelType() {

		try {
			logger.log(Status.INFO, "clicking on levelType box");
			clickFunction(levelType);
			logger.log(Status.PASS, "Succesfully clicked on levelType box");
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;
	}

	public CoursesPage clickOnLanguage() {

		try {
			logger.log(Status.INFO, "clicking on language box");
			clickFunction(language);
			logger.log(Status.PASS, "Succesfully clicked on language box");
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;
	}

	public CoursesPage clickOnLanguageName() {

		try {
			logger.log(Status.INFO, "clicking on languageName box");
			clickFunction(languageName);
			logger.log(Status.PASS, "Succesfully clicked on languageName box");
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;
	}

	public CoursesPage outClick() {

		try {
			logger.log(Status.INFO, "clicking on webpage");
			clickFunction(outclick);
			logger.log(Status.PASS, "Succesfully clicked on webpage");

			waitTime(3);
		} catch(Exception e) {

			reportFail(e.getMessage());
		}

		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;
	}

	public CoursesPage clickForCourses() throws Exception {

		try {
			logger.log(Status.INFO, "invoking the writeexcel method");
			WriteExcelData writeExcelData = new WriteExcelData();
			writeExcelData.writeExcel1();
			logger.log(Status.INFO, "successfully invoked write excem method");

			for (int i = 0; i < 2; i++) {

				logger.log(Status.INFO, "clicking on list of courses");
				clickFunction(listOfCourses.get(i));
				logger.log(Status.PASS, "Succesfully clicked on list of courses");

				logger.log(Status.INFO, "waiting for list of courses to be clicked");
				waits(listOfCourses.get(i));

				logger.log(Status.INFO, "Handling the windows");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				String name = courseTitle.getText();
				String duration = courseDuration.getText();
				String r = courseRating.getText();
				String[] arr = r.split("\n");
				String rating = arr[0];

				System.out.println(name + "  -->  " + duration + "  -->  " + rating + " stars");

				String[] array={name,duration,rating};
				int k = i + 1;

				logger.log(Status.INFO, "passing the data to excel");
				writeExcelData.writeExcel2(array, k);
				logger.log(Status.PASS, "Succesfully passed the data to excel");

				driver.close();
				driver.switchTo().window(tabs.get(0));
				//waitTime(2);

			}
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		CoursesPage coursesPage = new CoursesPage(driver,logger,prop);
		PageFactory.initElements(driver, coursesPage);
		return coursesPage;

	}

}

