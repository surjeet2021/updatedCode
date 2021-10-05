package ExtentReportWithScreenShot.Screenshot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	ExtentReports extent;
	WebDriver driver;
	ExtentTest test;

	@BeforeClass //

	public void init() {
		
		String dateName=new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		ExtentSparkReporter reporter = new ExtentSparkReporter("extent"+dateName+".html");	
		reporter.config().setDocumentTitle("Project name : Demo for Screenshot");
		reporter.config().setReportName("Screen shot");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("Company Name", "Scripting Logic");
		extent.setSystemInfo("Project Name", "HRM");

	}


	@Test

	public void mytest() {

		test =extent.createTest("Test1:-Checking QA title");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.info("Browser is demoqa opened");
		driver.manage().window().maximize();		
		test.info("Browser is maximize");

		driver.get("https://demoqa.com");
		test.info("URL is opened");
//		Assert.assertEquals(driver.getTitle(), "Tutorials website","This is not tutorial website");

		try {
			Assert.assertEquals(driver.getTitle(), "Tutorials website","This is not tutorial website");
			test.pass("We are on demoqa");			
		}
		catch(AssertionError e) {
			test.fail(e.getMessage());
			test.addScreenCaptureFromPath(Screenshot.takescreenshot(driver));
		}

				extent.flush();
				driver.quit();

	}




	@Test

	public void mytest1() {

		test =extent.createTest("Test2:-Checking facebook title");		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.info("Browser is Fcebook opened");
		driver.manage().window().maximize();		
		test.info("Browser is maximize");

		driver.get("https://www.google.com/");
		test.info("URL is opened");	

		try {
			
			Assert.assertEquals(driver.getTitle(), "Google");
			test.pass("We are on google.com");
			test.addScreenCaptureFromPath(Screenshot.takescreenshot(driver));
		}
		catch(AssertionError e) {
			test.fail(e.getMessage());
			test.addScreenCaptureFromPath(Screenshot.takescreenshot(driver));
		}
		
		extent.flush();
		driver.quit();
	
	}

//	@AfterMethod
//
//	public void teardown(ITestResult result) {
//		
//		if(result.getStatus()==ITestResult.FAILURE) {			
//			test.addScreenCaptureFromPath(Screenshot.takescreenshot(driver));
////			test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.takescreenshot(driver)).build());
//			}
//		
//
//		extent.flush();
//		driver.quit();
//
//	}

}
