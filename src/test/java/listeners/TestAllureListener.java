package listeners;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import testCases.SetupConnection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestAllureListener extends SetupConnection implements ITestListener {	
	
	@Attachment(value = "{0}", type = "text/plain")
	private static String saveTextLog(String message) {
		return message;
	}
	/*
	 * @Attachment(value = "Page screenshot", type = "image/png") private static
	 * File screenshot (AndroidDriver driver) throws IOException { SimpleDateFormat
	 * sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); Date date = new Date();
	 * String fileName = sdf.format(date); File SrcFile =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * FileUtils.copyFile(SrcFile, new
	 * File(System.getProperty("user.dir")+"//allure-results//"+fileName+".png"));
	 * // System.out.println("Screenshot is captured"); return SrcFile;
	 * 
	 * }
	 */

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(AndroidDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("AndroidDriver", driver);
	}
	
	@Override
	public void onTestStart(ITestResult iTestResult) {
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		if (driver != null) {
			System.out.println("Screenshot captured for test case");
			saveScreenshotPNG(driver);
			saveTextLog("Failed and screenshot taken!");
		}

	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	}

	

	@Override
	public void onFinish(ITestContext iTestContext) {
	}

}
