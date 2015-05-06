package modern.co.uk;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseClass {
	
	public static WebDriver driver;
	@BeforeTest
	public void setUp() throws Exception {
		
		//Open www.modern.co.uk Application 
		String baseUrl = "http://www.modern.co.uk/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public static void testnew() throws InterruptedException {
		// Function call to verify item price for different quantities 
		ItemCalculation itemCalc = new ItemCalculation();
		itemCalc.itemCalculation();
		
		// Function call to check validation of Email sign up field
		Email p = new Email();
		p.Emailtest();
		
		// Function call to sort functionality on a‘Product Catalog’page
		SortOrder s = new SortOrder();
   	 	s.sortorder();
	}	 
	
	


	@AfterTest
	 public void tearDown() throws Exception {
	 //Quit the application once the tests are run	
	 driver.quit();
	 }

}
