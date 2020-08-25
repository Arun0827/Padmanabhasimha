package newPackage;


	


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class FirstSeleniumTest {

	@Test
	public void firstTest() {
		
		
		String URL = "https://www.facebook.com/";
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Arun\\eclipse-workspace\\AyyagareNo1\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.id("email")).sendKeys("arun14885@gmail.com");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.name("pass")).sendKeys("password");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.id("u_0_b")).click();
	driver.close();
}
}


