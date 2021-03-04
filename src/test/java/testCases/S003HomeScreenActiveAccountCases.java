package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners( {listeners.TestAllureListener.class})
@Feature("Home Screen Tests Cases")

public class S003HomeScreenActiveAccountCases extends SetupConnection {

	/*
	 * HOME SCREEN FOR AN ALREADY CREATED ACCOUNT
	 * 
	 * Check if Elements are displayed
	 * 
	 * -Menu / User icon -Hello User -Bike -Floor -Recovery -Cross Training -MYX
	 * Media -Smart MYX -Scheduled -MYX logo
	 * 
	 * -Dashboard -Featured -Recent
	 * 
	 * -TRENDING -NEW WORKOUTS -FAVORITES
	 * 
	 * -SWIPES
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Test(priority = 1, description = "Check if 'Profile Header' is visible")
	@Description("Assert: Profile Name icon is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void profileHeaderIsVisible() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("com.myxfitness.app:id/profileHeader")));

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/profileHeader").isDisplayed());

		// CLOSE MENU

		System.out.println("Profile Header: Visible");

		visualAssertion.assertAll();
	}

	@Test(priority = 2, description = "Check if Account Name is visible")
	@Description("Assert: Account Name is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void accountNameIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/tv_account_name").isDisplayed());

		// CLOSE MENU

		System.out.println("Account Name: Visible");

		visualAssertion.assertAll();
	}

	@Test(priority = 3, description = "Check if Bike Filter is visible")
	@Description("Assert: Bike Filter is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void bikeFilterIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/header_bike").isDisplayed());

		// CLOSE MENU

		System.out.println("Bike Filter is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 4, description = "Check if Floor Filter is visible")
	@Description("Assert: Floor Filter is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void floorFilterIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/header_floor").isDisplayed());

		// CLOSE MENU

		System.out.println("Floor Filter is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 5, description = "Check if Recovery Filter is visible")
	@Description("Assert: Recovery Filter is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void recoveryFilterIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/header_mindful").isDisplayed());

		// CLOSE MENU

		System.out.println("Recovery Filter is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 6, description = "Check if Cross-Training Filter is visible")
	@Description("Assert: Cross-Training filter is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void crossTrainingFilterIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/header_myxplus").isDisplayed());

		// CLOSE MENU

		System.out.println("Cross-Training Filter is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 7, description = "Check if MYX Media is visible")
	@Description("Assert: MYX Media is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void myxMediaIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/header_media").isDisplayed());

		// CLOSE MENU

		System.out.println("MYX media is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 8, description = "Check if Smart MYX is visible")
	@Description("Assert: Smart MYX is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void smartMYXIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/smart_myx").isDisplayed());

		// CLOSE MENU

		System.out.println("Smart MYX is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 9, description = "Check if calendar icon is visible")
	@Description("Assert: calendar icon is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void calendarIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/schedules").isDisplayed());

		// CLOSE MENU

		System.out.println("Calendar icon is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 9, description = "Check if MYX Logo is visible")
	@Description("Assert: MYX Logo is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void myxLogoIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/ivMyxLogo").isDisplayed());

		// CLOSE MENU

		System.out.println("MYX Logo  is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 10, description = "Open and Close Menu functionality")
	@Description("Open the menu and check if all the options are visible.")
	@Severity(SeverityLevel.NORMAL)
	public void openMenu() {

		// OPEN MENU
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		// ELEMENT IS DISPLAYED > Just one
		String displayValidation = driver.findElementById("com.myxfitness.app:id/manageProfile")
				.getText();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(displayValidation.contains("MANAGE PROFILES"));

		// CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/container").click();
		System.out.println("1- Open Menu Check all options are displayed.");

		softAssertion.assertAll();
	}

}
