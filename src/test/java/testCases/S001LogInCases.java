package testCases;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners( {listeners.TestAllureListener.class})
@Feature("Login Tests Cases")
public class S001LogInCases extends SetupConnection {

	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

	protected String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890+-!/*_";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}


	@Test(priority = -2, description = "First screen 'Welcome to MYX' is displayed")
	@Description("Assert: WELCOME TO MYXfitness! text is displayed and correct")
	public void welcomeisDisplayed() {

		MobileElement element = driver.findElementById("com.myxfitness.app:id/tv_welcome");
		String getText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		// softAssertion.assertTrue(getText.contains("WELCOME TO MYXfitness!!"));
		softAssertion.assertEquals(getText, "WELCOME TO MYXfitness!dsedsf");

		System.out.println("El mensaje es: " + getText);
		softAssertion.assertAll();
	}

	@Test(priority = -1, description = "First screen 'The road...' is displayed")
	@Description("Assert: 'The road to success is paved with patience and persistence.' text is displayed and correct")
	public void theRoadisDisplayed() {

		MobileElement element = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]");
		String getText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(getText.contains("The road to success is paved"));

		System.out.println("El mensaje es: " + getText);
		softAssertion.assertAll();

	}

	@Test(priority = 0, description = "Invalid login scenario with a wrong email.")
	@Description("Invalid email login test")
	@Severity(SeverityLevel.NORMAL)
	public void invalidEmail() {

		driver.findElementById("com.myxfitness.app:id/btn_continue").click();
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		driver.findElementById("com.myxfitness.app:id/et_email").sendKeys("dpereira@sweatworks..net");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("Myx2021!");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		// ASSERT
		MobileElement element = driver.findElementById("com.myxfitness.app:id/text_message");
		String elText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(elText,
				"It seems that either your user name or password is incorrect.");

		// CLOSE POPUP MESSAGE
		driver.findElementById("com.myxfitness.app:id/button_single").click();

		System.out.println(
				"This is the invalidEmail test. Email: test.qa." + timeStamp + "@gmail.com");
		softAssertion.assertAll();
	}

	@Test(priority = 1, description = "Invalid login scenario with a wrong password.")
	@Description("Assert: error message is shown as expected 'It seems that either your user name or password is incorrect.' RESULT: TRUE/FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void invalidPassword() {

		driver.findElementById("com.myxfitness.app:id/et_email")
				.sendKeys("dpereira@sweatworks.net");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("Myx2021!!!");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		// ASSERT HEIGHT ERROR MESSAGE
		String textValidation = driver.findElementById("com.myxfitness.app:id/text_message")
				.getText();
		// SOFT ASSERT >>>> needs assertAll(); at the very end.
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(textValidation
				.contains("It seems that either your user name or password is incorrect.")); 

		// Assert.assertEquals(elText, "It seems that either your user name or password
		// is incorrect.");

		System.out.println("This is the invalidPassword test. Email: test.qa." + getRandomString()
				+ "@gmail.com");

		// CLOSE POPUP MESSAGE
		driver.findElementById("com.myxfitness.app:id/button_single").click();

		softAssertion.assertAll();

	}

	@Test(priority = 2, description = "Invalid login scenario with an empty email and password.")
	@Description("Empty password and email")
	@Severity(SeverityLevel.NORMAL)
	public void noEmailAndPassword() {

		driver.findElementById("com.myxfitness.app:id/et_email").sendKeys("");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		// ASSERT
		MobileElement element = driver.findElementById("com.myxfitness.app:id/text_message");
		String elText = element.getText();
		System.out.println("El mensaje es: " + elText);

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(elText, "Please introduce your email and password");

		System.out.println("This is the invalidPassword test. Email: test.qa." + getRandomString()
				+ "@gmail.com");

		// CLOSE POPUP MESSAGE
		driver.findElementById("com.myxfitness.app:id/button_single").click();
		softAssertion.assertAll();
	}

	@Test(priority = 3, description = "Customer wants to reset the password, but entered no email.")
	@Description("Reset password with no email entered")
	@Severity(SeverityLevel.NORMAL)
	public void passwordRecoveryEmpty() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_forgot_password").click();
		driver.findElementById("com.myxfitness.app:id/et_field").sendKeys("");
		driver.findElementById("com.myxfitness.app:id/forgotPasswordButton").click();

		// ASSERT
		MobileElement textValidation = driver.findElementById("com.myxfitness.app:id/tv_message");
		String validation = textValidation.getText();

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(validation, "Doesn't appear to be a valid email");

		driver.findElementById("com.myxfitness.app:id/cancelButton").click();

		System.out.println("This is a reset password test without email.");
		softAssertion.assertAll();

	}

	@Test(priority = 4, description = "Customer wants to reset the password, but entered an invalid email.")
	@Description("Reset password with unregistered email entered")
	@Severity(SeverityLevel.NORMAL)
	public void passwordRecoveryWrongEmail() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_forgot_password").click();
		driver.findElementById("com.myxfitness.app:id/et_field")
				.sendKeys("santiagovolve@teperdonamos.com");
		driver.findElementById("com.myxfitness.app:id/forgotPasswordButton").click();

		// ASSERT
		MobileElement textValidation = driver.findElementById("com.myxfitness.app:id/text_message");
		String validation = textValidation.getText();

		Assert.assertEquals(validation, "Please enter a valid email.");

		driver.findElementById("com.myxfitness.app:id/button_single").click();
		driver.findElementById("com.myxfitness.app:id/cancelButton").click();

		System.out.println("This is a reset password test with a wrong email.");

	}

	// FINAL VALID PASSWORD RESET
	@Test(priority = 5, description = "Customer wants to reset the password, but entered no email.")
	@Description("Reset password with no email entered")
	@Severity(SeverityLevel.NORMAL)
	public void passwordRecoveryzValid() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_forgot_password").click();
		driver.findElementById("com.myxfitness.app:id/et_field")
				.sendKeys("dpereira@sweatworks.net");
		driver.findElementById("com.myxfitness.app:id/forgotPasswordButton").click();

		// ASSERT
		String textValidation = driver.findElementById("com.myxfitness.app:id/text_message")
				.getText();
		assertTrue(textValidation.contains("The email with verification code was sent"));

		driver.findElementById("com.myxfitness.app:id/button_single").click();

		System.out.println("This is valid reset password test with a valid email.");

	}

	@Test(priority = 6, description = "Customer selects the option 'I don't have an account'.")
	@Description("Click on 'Idon't have an account' option")
	@Severity(SeverityLevel.NORMAL)
	public void iDontHaveAccount() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_sign_up").click();

		// ASSERT
		String textValidation = driver.findElementById("com.myxfitness.app:id/tv_welcome")
				.getText();
		assertTrue(textValidation.contains("WELCOME TO MYXfitness!"));

		driver.findElementById("com.myxfitness.app:id/btn_continue").click();
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		System.out.println("I don't have an account selected");

	}

	// FINAL VALID LOGIN
	@Test(priority = 7, description = "Valid login scenario with a valid email and password.")
	@Description("Valid password and email")
	@Severity(SeverityLevel.BLOCKER)
	public void validEmailAndPassword() throws Exception {

		driver.findElementById("com.myxfitness.app:id/et_email")
				.sendKeys("dpereira@sweatworks.net");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("Myx2021!");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		MobileElement element = driver.findElementById("com.myxfitness.app:id/loginTitle");
		String valid = element.getText();
		System.out.println("El mensaje es: " + valid);

		Assert.assertEquals(valid, "Who's working out today?");

		System.out.println("This is the valid email and password test.");

	}

}
