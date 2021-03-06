package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners( {listeners.TestAllureListener.class})
@Feature("Manage Profiles")

public class S004ManageProfilesCases extends SetupConnection {

	// FROM Home Screen

	@Test(priority = 1, description = "Open Manage Profiles")
	@Description("Open the option 'Manage Profiles' and check if all the options are visible")
	@Severity(SeverityLevel.NORMAL)
	public void openManageProfiles() {

		// OPEN MENU
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();
		driver.findElementById("com.myxfitness.app:id/manageProfile").click();

		// Thread.sleep(5000);

		// CHECK IF ELEMENTS ARE DISPLAYED
		driver.findElementById("com.myxfitness.app:id/firstName").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/lastName").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/email").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/gender").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/height").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/birthday").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/weight").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/fitness_level").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/times_week").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/time_session").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/average_stress").isDisplayed();

		// BACK TO MAIN SCREEN
		driver.findElementById("com.myxfitness.app:id/btn_header_back").click();
		System.out.println("1- 'Manage Profiles' all options are displayed.");
	}

	@Test(priority = 2, description = "Edit Manage Profiles")
	@Description("Edit content of the main profile under'Manage Profiles'")
	@Severity(SeverityLevel.NORMAL)
	public void editManageProfiles() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("com.myxfitness.app:id/profileHeader")));

		// OPEN MENU
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();
		// OPEN MANAGE PROFILES
		driver.findElementById("com.myxfitness.app:id/manageProfile").click();

		// NAME AND LAST NAME
		driver.findElementById("com.myxfitness.app:id/firstName").sendKeys("Santiago");
		driver.findElementById("com.myxfitness.app:id/lastName").sendKeys("Rubianes");

		// GENDER
		driver.findElementById("com.myxfitness.app:id/gender").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
				.click();

		// HEIGHT
		driver.findElementById("com.myxfitness.app:id/height").click();
		driver.findElementById("com.myxfitness.app:id/feet").clear();
		driver.findElementById("com.myxfitness.app:id/feet").sendKeys("99");
		driver.findElementById("com.myxfitness.app:id/inches").clear();
		driver.findElementById("com.myxfitness.app:id/inches").sendKeys("55");

		// ASSERT HEIGHT ERROR MESSAGE
		String textValidation = driver.findElementById("com.myxfitness.app:id/lbl_error_message")
				.getText();
		// SOFT ASSERT >>>> needs assertAll(); at the very end.
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(textValidation.contains("Please enter a valid height"));

		// WEIGHT PROPER NUMBERS
		driver.findElementById("com.myxfitness.app:id/feet").clear();
		driver.findElementById("com.myxfitness.app:id/inches").clear();
		driver.findElementById("com.myxfitness.app:id/feet").sendKeys("5");
		driver.findElementById("com.myxfitness.app:id/inches").sendKeys("8");
		driver.findElementById("com.myxfitness.app:id/btn_ok").click();

		// BIRTHDAY
		driver.findElementById("com.myxfitness.app:id/birthday").click();
		// MONTH
		driver.findElementById("com.myxfitness.app:id/month").click();
		// MONTH SWIPE
		TouchAction touchAction = new TouchAction(driver);
		PointOption pointStart = PointOption.point(768, 684);
		PointOption pointEnd = PointOption.point(760, 826);
		WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(500));
		touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
				.click();

		// DAY
		driver.findElementById("com.myxfitness.app:id/day").click();
		// DAY SWIPE
		TouchAction touchActionDay = new TouchAction(driver);
		PointOption pointStartDay = PointOption.point(968, 564);
		PointOption pointEndDay = PointOption.point(933, 964);
		WaitOptions waitOptionDay = WaitOptions.waitOptions(Duration.ofMillis(500));
		touchActionDay.press(pointStartDay).waitAction(waitOptionDay).moveTo(pointEndDay).release()
				.perform();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
				.click();

		// YEAR
		driver.findElementById("com.myxfitness.app:id/year").click();
		// YEAR SWIPE
		TouchAction touchActionYear = new TouchAction(driver);
		PointOption pointStartYear = PointOption.point(1187, 580);
		PointOption pointEndYear = PointOption.point(1152, 887);
		WaitOptions waitOptionYear = WaitOptions.waitOptions(Duration.ofMillis(500));
		touchActionYear.press(pointStartYear).waitAction(waitOptionYear).moveTo(pointEndYear)
				.release().perform();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
				.click();

		// BIRTHDAY OK
		driver.findElementById("com.myxfitness.app:id/btn_ok").click();

		// WEIGHT
		driver.findElementById("com.myxfitness.app:id/weight").click();
		driver.findElementById("com.myxfitness.app:id/weight").clear();
		driver.findElementById("com.myxfitness.app:id/weight").sendKeys("500");

		// ASSERT WEIGHT ERROR MESSAGE
		String textValidation2 = driver.findElementById("com.myxfitness.app:id/lbl_error_message")
				.getText();
		assertTrue(textValidation2.contains("Please enter a valid weight"));

		driver.findElementById("com.myxfitness.app:id/weight").clear();
		driver.findElementById("com.myxfitness.app:id/weight").sendKeys("129");

		driver.findElementById("com.myxfitness.app:id/btn_ok_weight").click();

		// FITNESS LEVEL
		driver.findElementById("com.myxfitness.app:id/fitness_level").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
				.click();

		// TIMES WEEK
		driver.findElementById("com.myxfitness.app:id/times_week").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[6]")
				.click();

		// TIMES SESSION
		driver.findElementById("com.myxfitness.app:id/time_session").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
				.click();

		// STRESS
		driver.findElementById("com.myxfitness.app:id/average_stress").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
				.click();

		driver.findElementById("com.myxfitness.app:id/action").click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElementById("com.myxfitness.app:id/btn_header_back").click();

		// ASSERT ALL> SOFT ASSERT

		System.out.println("2- 'Manage Profiles' profile edited succesfully");
		softAssertion.assertAll();
	}

	@Test(priority = 3, description = "Edit Manage Profiles back to default information.")
	@Description("Edit content of the main profile under 'Manage Profiles' back to original user")
	@Severity(SeverityLevel.NORMAL)
	public void editManageProfilesBack() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("com.myxfitness.app:id/profileHeader")));

		// OPEN MENU
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		// OPEN MANAGE PROFILES
		driver.findElementById("com.myxfitness.app:id/manageProfile").click();

		// NAME AND LAST NAME
		driver.findElementById("com.myxfitness.app:id/firstName").sendKeys("Damian");
		driver.findElementById("com.myxfitness.app:id/lastName").sendKeys("Pereira");

		// GENDER
		driver.findElementById("com.myxfitness.app:id/gender").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
				.click();

		// WEIGHT PROPER NUMBERS
		driver.findElementById("com.myxfitness.app:id/height").click();
		driver.findElementById("com.myxfitness.app:id/feet").clear();
		driver.findElementById("com.myxfitness.app:id/inches").clear();
		driver.findElementById("com.myxfitness.app:id/feet").sendKeys("6");
		driver.findElementById("com.myxfitness.app:id/inches").sendKeys("3");
		driver.findElementById("com.myxfitness.app:id/btn_ok").click();

		// BIRTHDAY
		driver.findElementById("com.myxfitness.app:id/birthday").click();
		// MONTH
		driver.findElementById("com.myxfitness.app:id/month").click();
		// MONTH SWIPE
		TouchAction touchAction = new TouchAction(driver);
		PointOption pointStart = PointOption.point(768, 684);
		PointOption pointEnd = PointOption.point(760, 826);
		WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(500));
		touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]")
				.click();

		// DAY
		driver.findElementById("com.myxfitness.app:id/day").click();
		// DAY SWIPE
		TouchAction touchActionDay = new TouchAction(driver);
		PointOption pointStartDay = PointOption.point(968, 564);
		PointOption pointEndDay = PointOption.point(933, 964);
		WaitOptions waitOptionDay = WaitOptions.waitOptions(Duration.ofMillis(500));
		touchActionDay.press(pointStartDay).waitAction(waitOptionDay).moveTo(pointEndDay).release()
				.perform();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
				.click();

		// YEAR
		driver.findElementById("com.myxfitness.app:id/year").click();
		// YEAR SWIPE
		TouchAction touchActionYear = new TouchAction(driver);
		PointOption pointStartYear = PointOption.point(1187, 887);
		PointOption pointEndYear = PointOption.point(1152, 580);
		WaitOptions waitOptionYear = WaitOptions.waitOptions(Duration.ofMillis(500));
		touchActionYear.press(pointStartYear).waitAction(waitOptionYear).moveTo(pointEndYear)
				.release().perform();

		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
				.click();

		// BIRTHDAY OK
		driver.findElementById("com.myxfitness.app:id/btn_ok").click();

		driver.findElementById("com.myxfitness.app:id/weight").click();
		driver.findElementById("com.myxfitness.app:id/weight").clear();
		driver.findElementById("com.myxfitness.app:id/weight").sendKeys("198");

		driver.findElementById("com.myxfitness.app:id/btn_ok_weight").click();

		// FITNESS LEVEL
		driver.findElementById("com.myxfitness.app:id/fitness_level").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
				.click();

		// TIMES WEEK
		driver.findElementById("com.myxfitness.app:id/times_week").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
				.click();

		// TIMES SESSION
		driver.findElementById("com.myxfitness.app:id/time_session").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
				.click();

		// STRESS
		driver.findElementById("com.myxfitness.app:id/average_stress").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
				.click();

		driver.findElementById("com.myxfitness.app:id/action").click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElementById("com.myxfitness.app:id/btn_header_back").click();
		System.out.println("3- 'Manage Profiles' profile edited back succesfully");

	}

	@Test(priority = 4, description = "Take a profile picture")
	@Description("Open the option 'Manage Profiles' and take a picture")
	@Severity(SeverityLevel.NORMAL)
	public void changeMainProfilePicture() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("com.myxfitness.app:id/profileHeader")));

		// OPEN MENU
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();
		driver.findElementById("com.myxfitness.app:id/manageProfile").click();

		driver.findElementById("com.myxfitness.app:id/btn_edit_photo").click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.myxfitness.app:id/cameraContent")));

		driver.findElementById("com.myxfitness.app:id/take_photo").click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.myxfitness.app:id/use_photo")));

		driver.findElementById("com.myxfitness.app:id/use_photo").click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElementById("com.myxfitness.app:id/action").click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// BACK TO MAIN SCREEN
		driver.findElementById("com.myxfitness.app:id/btn_header_back").click();
		System.out.println("1- 'Manage Profiles' all options are displayed.");
	}

}
