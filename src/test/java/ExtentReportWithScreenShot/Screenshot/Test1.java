package ExtentReportWithScreenShot.Screenshot;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 extends ExtentReportDemo {
	
	
	
	@Test
	
	public void logintest() {
		
		test =extent.createTest("Mytest1");		
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();

		test.info("Browser is demoqa opened");


		driver.manage().window().maximize();		
		test.info("Browser is maximize");

		driver.get("https://demoqa.com");
		test.info("URL is opened");


		try {
			Assert.assertEquals(driver.getTitle(), "Tutorials website","This is not tutorial website");
			test.pass("We are on demoqa");			
		}
		catch(AssertionError e) {
			test.fail(e.getMessage());
			test.addScreenCaptureFromPath(Screenshot.takescreenshot(driver));
		}
		
	}

}
