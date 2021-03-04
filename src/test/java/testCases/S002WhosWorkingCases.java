package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Listeners( {listeners.TestAllureListener.class})
@Feature("'Who's working out today' Test cases")

public class S002WhosWorkingCases extends SetupConnection {

	@Test(priority = 0, description = "Who's working out today screen: PROFILE title is displayed")
	@Description("PROFILE title text is displayed and correct")
	public void profileTitleisDisplayed() {

		MobileElement element = driver.findElementById("com.myxfitness.app:id/mainTitle");
		String getText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		// softAssertion.assertTrue(getText.contains("WELCOME TO MYXfitness!!"));
		softAssertion.assertEquals(getText, "PROFILE");

		System.out.println("El mensaje es: " + getText);
		softAssertion.assertAll();
	}

	@Test(priority = 1, description = "'Who's working out today' title is displayed")
	@Description("Assert: Who's working out today? text is displayed and correct")
	public void whosWorkingOutTitleisDisplayed() {

		MobileElement element = driver.findElementById("com.myxfitness.app:id/loginTitle");
		String getText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		// softAssertion.assertTrue(getText.contains("WELCOME TO MYXfitness!!"));
		softAssertion.assertEquals(getText, "Who's working out today?");

		System.out.println("El mensaje es: " + getText);
		softAssertion.assertAll();
	}

	@Test(priority = 2, description = "Main profile is displayed and clickable")
	@Description("MAIN profile is displayed and correct")
	public void mainProfileisDisplayed() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true, driver
				.findElementByXPath("(//android.widget.ImageView[@content-desc=\"image\"])[1]")
				.isDisplayed());

		// CLOSE MENU

		System.out.println("'MAIN Profile' is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 3, description = "'Add User' option is displayed and clickable")
	@Description("Assert: 'Add User' option is displayed and correct")
	public void addUserisDisplayed() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/ll_add").isDisplayed());

		// CLOSE MENU

		System.out.println("'ADD USER' is visible.");

		visualAssertion.assertAll();
	}

	@Test(priority = 4, description = "Click 'add User' and go back to the 'Who's working out today' screen")
	@Description("ASSERT if 'Add User' title is displayed")
	public void clickAddUser() {

		// ELEMENT IS DISPLAYED
		driver.findElementById("com.myxfitness.app:id/ll_add").click();

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/mainTitle").isDisplayed());

		// CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/btn_header_back").click();
		System.out.println("'ADD USER' title is visible.");

	}

	@Test(priority = 5, description = "Select MAIN profile to LOGIN")
	@Description("Click on MAIN Profile option")
	public void validateOptionsAvailable() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//android.widget.ImageView[@content-desc=\"image\"])[1]")));

		driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"image\"])[1]")
				.click();
		// Thread.sleep(10000);

	}

}
