package newPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class kingKoduku {
	
	public static WebDriver driver ;
	@Test
	public void openBrowser() {

		String URL = "https://www.udemy.com/";
		//ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		//options.addArguments("--disable notifications");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
		//driver.findElement(By.xpath("//*[@id='u366-scroll-port--10']/div[2]/div/button/span")).click();

		driver.findElement(By.xpath("//div[@class='billboard--content-box--JtXUJ']/form/div/input")).sendKeys("web development course");
		
		driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[3]/div[1]/div/div[2]/form/div/button")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='filter-form']/div/div[2]/div/div/div/div/div/fieldset/label[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div/div[3]/label/svg")).click();
		
		
		driver.findElement(By.xpath("//*[@id='filter-form']/div/div[3]/div/div/div/div/div/fieldset/label[1]/svg")).click();
		
		List <WebElement> element1 = driver.findElements(By.xpath("//div[@class='udlite-focus-visible-target udlite-heading-md course-card--course-title--2f7tE']"));
		
		List <WebElement> element2 = driver.findElements(By.xpath("//span[@class='udlite-heading-sm star-rating--rating-number--3lVe8']"));
		
		List <WebElement> element3 = driver.findElements(By.xpath("//span[@class='course-card--row--1OMjg'][1]"));
		
		for(int i=0; i < 1; i++) {
			
			System.out.println(element1.get(i).getText());
		}
		for(int i=0; i < 1; i++) {
			
			System.out.println(element2.get(i).getText());
		}
		for(int i=0; i < 1; i++) {
			
			System.out.println(element3.get(i).getText());
		}


}
}