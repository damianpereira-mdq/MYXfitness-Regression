package testCases;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;

public class SetupConnection {

	static AndroidDriver<MobileElement> driver;
	// WebDriverWait wait = new WebDriverWait(driver, 120);
	
	@BeforeSuite
	public void startConnection () {

		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "MYX215A");
			cap.setCapability("udid", "INB04749A");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "8.1.0");

			URL url = new URL("http://0.0.0.0:4723/wd/hub/");
			driver = new AndroidDriver<MobileElement>(url, cap);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			System.out.println("Connection successfuly started!");

		} catch (Exception exp) {

			System.out.println("Cause is: " + exp.getCause());
			System.out.println("Message is: " + exp.getMessage());
			exp.printStackTrace();

		}

	}

	@AfterSuite
	public void TearDown() {
		
		//driver.quit();
		System.out.println("This is AfterSuite section.");
	}

}
