package newPackage;



	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;

	import org.testng.annotations.Test;




	public class scroll {




	@Test
	public  void scrollbar() {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\Arun\\eclipse-workspace\\AyyagareNo1\\drivers\\chromedriver.exe");

	// Instantiate a ChromeDriver class.     

	        WebDriver driver=new ChromeDriver();  

	          

	           // Launch Website  

	        driver.navigate().to("http://www.javatpoint.com/");  

	          

	         //Maximize the browser  

	          driver.manage().window().maximize();  

	          



	// TODO Auto-generated method type name

	}

	}

