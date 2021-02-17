package testCases;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Regression Test")
@Feature("Login Tests")

public class LogInCases extends SetupConnection {

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

	@BeforeTest
	public void goToLoginScreen() {
		
		System.out.println("This is @BeforeTest!");
	}

	@Test(description = "Invalid login scenario with a wrong email.")
	@Description("Invalid email login test")
	@Severity(SeverityLevel.NORMAL)
	public void invalidEmail() {
		
		driver.findElementById("com.myxfitness.app:id/btn_continue").click();
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		driver.findElementById("com.myxfitness.app:id/et_email").sendKeys("dpereira@sweatworks..net");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("Myx2021!");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		// ASSERT
		MobileElement element = (MobileElement) driver.findElementById("com.myxfitness.app:id/text_message");
		String elText = element.getText();
		System.out.println("El mensaje es: " + elText);
		Assert.assertEquals(elText, "It seems that either your user name or password is incorrect.");

		// CLOSE POPUP MESSAGE
		driver.findElementById("com.myxfitness.app:id/button_single").click();

		System.out.println("This is the invalidEmail test. Email: test.qa." + getRandomString() + "@gmail.com");

	}

	@Test(description = "Invalid login scenario with a wrong password.")
	@Description("Invalid password login test")
	@Severity(SeverityLevel.NORMAL)
	public void invalidPassword() {

		driver.findElementById("com.myxfitness.app:id/et_email").sendKeys("dpereira@sweatworks.net");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("Myx2021!!!");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		// ASSERT
		MobileElement element = (MobileElement) driver.findElementById("com.myxfitness.app:id/text_message");
		String elText = element.getText();
		System.out.println("El mensaje es: " + elText);

		Assert.assertEquals(elText, "It seems that either your user name or password is incorrect.");

		System.out.println("This is the invalidPassword test. Email: test.qa." + getRandomString() + "@gmail.com");

		// CLOSE POPUP MESSAGE
		driver.findElementById("com.myxfitness.app:id/button_single").click();

	}

	@Test(description = "Invalid login scenario with an empty email and password.")
	@Description("Empty password and email")
	@Severity(SeverityLevel.NORMAL)
	public void noEmailAndPassword() {

		driver.findElementById("com.myxfitness.app:id/et_email").sendKeys("");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();

		// ASSERT
		MobileElement element = (MobileElement) driver.findElementById("com.myxfitness.app:id/text_message");
		String elText = element.getText();
		System.out.println("El mensaje es: " + elText);

		Assert.assertEquals(elText, "Please introduce your email and password");

		System.out.println("This is the invalidPassword test. Email: test.qa." + getRandomString() + "@gmail.com");

		// CLOSE POPUP MESSAGE
		driver.findElementById("com.myxfitness.app:id/button_single").click();

	}
	
	@Test(description = "Customer wants to reset the password, but entered no email.")
	@Description("Reset password with no email entered")
	@Severity(SeverityLevel.NORMAL)
	public void passwordRecoveryEmpty() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_forgot_password").click();
		driver.findElementById("com.myxfitness.app:id/et_field").sendKeys("");
		driver.findElementById("com.myxfitness.app:id/forgotPasswordButton").click();

		// ASSERT
		MobileElement textValidation = (MobileElement) driver.findElementById("com.myxfitness.app:id/tv_message");
		String validation = textValidation.getText();
		
		Assert.assertEquals(validation, "Doesn't appear to be a valid email");

		driver.findElementById("com.myxfitness.app:id/cancelButton").click();
		
		System.out.println("This is a reset password test without email.");
		

	}
	
	@Test(description = "Customer wants to reset the password, but entered an invalid email.")
	@Description("Reset password with unregistered email entered")
	@Severity(SeverityLevel.NORMAL)
	public void passwordRecoveryWrongEmail() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_forgot_password").click();
		driver.findElementById("com.myxfitness.app:id/et_field").sendKeys("santiagovolve@teperdonamos.com");
		driver.findElementById("com.myxfitness.app:id/forgotPasswordButton").click();

		// ASSERT
		MobileElement textValidation = (MobileElement) driver.findElementById("com.myxfitness.app:id/text_message");
		String validation = textValidation.getText();
		
		Assert.assertEquals(validation, "Please enter a valid email.");

		driver.findElementById("com.myxfitness.app:id/button_single").click();
		driver.findElementById("com.myxfitness.app:id/cancelButton").click();
		
		System.out.println("This is a reset password test with a wrong email.");
		

	}
	
	//FINAL VALID PASSWORD RESET
	@Test(description = "Customer wants to reset the password, but entered no email.")
	@Description("Reset password with no email entered")
	@Severity(SeverityLevel.NORMAL)
	public void passwordRecoveryzValid() throws Exception {

		driver.findElementById("com.myxfitness.app:id/tv_forgot_password").click();
		driver.findElementById("com.myxfitness.app:id/et_field").sendKeys("dpereira@sweatworks.net");
		driver.findElementById("com.myxfitness.app:id/forgotPasswordButton").click();

		// ASSERT
		String textValidation = driver.findElementById("com.myxfitness.app:id/text_message").getText();
		assertTrue(textValidation.contains("The email with verification code was sent"));
		
		driver.findElementById("com.myxfitness.app:id/button_single").click();
		
		System.out.println("This is valid reset password test with a valid email.");
		

	}
	
	
	
	//FINAL VALID LOGIN
	@Test(description = "Valid login scenario with a valid email and password.")
	@Description("Valid password and email")
	@Severity(SeverityLevel.BLOCKER)
	public void validEmailAndPassword() throws Exception {

		driver.findElementById("com.myxfitness.app:id/et_email").sendKeys("dpereira@sweatworks.net");
		driver.findElementById("com.myxfitness.app:id/loginPassword").sendKeys("Myx2021!");
		driver.findElementById("com.myxfitness.app:id/btn_login").click();		
		
		MobileElement element = (MobileElement) driver.findElementById("com.myxfitness.app:id/loginTitle");
		String valid = element.getText();
		System.out.println("El mensaje es: " + valid);

		Assert.assertEquals(valid, "Who's working out today?");

		driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"image\"])[1]").click();
		Thread.sleep(10000);
		
		System.out.println("This is the valid email and password test.");

	}

}
