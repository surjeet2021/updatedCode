package ExtentReportWithScreenShot.Screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {


	public static String takescreenshot(WebDriver driver) {

		TakesScreenshot ts= (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		String destination =System.getProperty("user.dir")+"/FailedTestsScreenshots/"+dateName+".png";
		String destination ="**//AutomationScreenShot//FailedTestsScreenshots//test_"+dateName+".png";
		
		
		File finalDestination = new File(destination);

		try {
			FileHandler.copy(source,finalDestination);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return destination;
	}

}
