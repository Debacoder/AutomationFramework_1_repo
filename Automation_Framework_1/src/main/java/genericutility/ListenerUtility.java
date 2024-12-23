package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
/**
 * ITestListener is an Interface 
 * It has several overloaded method
 */
public class ListenerUtility extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName(); //to capture method name
		test.log(Status.FAIL, methodName+" is failed");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+methodName+jlib.getSystemTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64)); //adding screenshot to extent reports
	}
	
}
