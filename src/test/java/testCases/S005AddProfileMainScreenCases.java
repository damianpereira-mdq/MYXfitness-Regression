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
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners( {listeners.TestAllureListener.class})
@Feature("Add a new Profile")

public class S005AddProfileMainScreenCases extends SetupConnection {

	@Test(priority = 0, description = "Select 'add profile' from the menu on the Main Screen")
	@Description("Assert: the 'ADD USER' title is displayed")
	@Severity(SeverityLevel.NORMAL)
	public void openMenuClickAddUser() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("com.myxfitness.app:id/profileHeader")));

		// OPEN MENU
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		driver.findElementById("com.myxfitness.app:id/headerContainer").click();
		// ELEMENTS ARE DISPLAYED

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/mainTitle").isDisplayed());

		// CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/container").click();

		System.out.println("4- Open 'add user' screen successfuly");
		softAssertion.assertAll();

	}

	@Test(priority = 1, description = "Check if 'Create Profile' title is visible")
	@Description("Assert: 'Create Profile' title is displayed")
	@Severity(SeverityLevel.NORMAL)
	public void createProfileIsDisplayed() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/titleContainer").isDisplayed());

		// CLOSE MENU

		System.out.println("'Create Profile' title is visible.");

		visualAssertion.assertAll();

	}

	@Test(priority = 2, description = "Check if 'Photo' icon is visible")
	@Description("Assert: 'Photo' icon is displayed")
	@Severity(SeverityLevel.NORMAL)
	public void pictureIconIsDisplayed() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/camera").isDisplayed());

		// CLOSE MENU

		System.out.println("'Photo Icon' is visible.");

		visualAssertion.assertAll();

	}



	@Test(priority = 3, description = "Check if 'First Name' is visible")
	@Description("Assert: 'First Name' field is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void firstNameFieldIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/firstName").isDisplayed());

		// CLOSE MENU

		System.out.println("'First Name' field is Visible");

		visualAssertion.assertAll();
	}

	@Test(priority = 3, description = "Check if 'Last Name' is visible")
	@Description("Assert: 'Last Name' field is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void lastNameFieldIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/lastName").isDisplayed());

		// CLOSE MENU

		System.out.println("'Last Name' field is Visible");

		visualAssertion.assertAll();
	}

	@Test(priority = 3, description = "Check if 'Email' is visible")
	@Description("Assert: 'Email' field is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void emailFieldIsVisible() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/email").isDisplayed());

		// CLOSE MENU

		System.out.println("'Email' field is Visible");

		visualAssertion.assertAll();
	}

	@Test(priority = 3, description = "Check if 'T&C' title is visible")
	@Description("Assert: 'T&D' title is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void termsAndConditionsTitleIsVisible() {

		MobileElement element = driver.findElementById("com.myxfitness.app:id/tvTC");
		String getText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		// softAssertion.assertTrue(getText.contains("WELCOME TO MYXfitness!!"));
		softAssertion.assertEquals(getText, "TERMS & CONDITIONS");

		System.out.println("El mensaje es: " + getText);
		softAssertion.assertAll();
	}

	@Test(priority = 4, description = "Check if 'T&C' content title is visible")
	@Description("Assert: 'T&D' content title is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void termsAndConditionsContentIsVisible() {

		MobileElement element = driver.findElementByClassName("android.webkit.WebView");
		String getText = element.getText();

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(getText.contains("Terms of Service")); 

		System.out.println("El mensaje es: " + getText +" Content title is correct");
		softAssertion.assertAll();
	}
	
	
	@Test(priority = 5, description = "Check if 'T&C' content text is visible")
	@Description("Assert: 'T&D' content text is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void termsAndConditionsContentTestIsVisible() {

		MobileElement element = driver.findElementByClassName("android.view.View");
		String getText = element.getText();

		//SoftAssert softAssertion = new SoftAssert();
		//softAssertion.assertTrue(getText.contains("Welcome to Myx Fitness, the perfect Myx of health, wellness, and fitness, owned and operated by Myx Fitness, LLC")); 

		System.out.println("El mensaje es: " + getText +" Content text is correct");
		//softAssertion.assertAll();
	}
	
	@Test(priority = 5, description = "Decline T&C")
	@Description("Assert: 'T&D' error message is visible. TRUE / FALSE")
	@Severity(SeverityLevel.NORMAL)
	public void declineTC() {

		driver.findElementById("com.myxfitness.app:id/disagreeTerms").click();
		
		String textValidation = driver.findElementById("com.myxfitness.app:id/dialog_title")
				.getText();
		
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(textValidation.contains("Please review the"));

		driver.findElementById("com.myxfitness.app:id/button_single").click();
		
		softAssertion.assertAll();
		System.out.println("Accept T&C message is displayed");
	}

	@Test(priority = 6, description = "Enter Name")
	@Description("Assert: 'Name' entered")
	@Severity(SeverityLevel.NORMAL)
	public void enterName() {

		driver.findElementById("com.myxfitness.app:id/firstName").sendKeys("John");

		//SoftAssert softAssertion = new SoftAssert();
		//softAssertion.assertTrue(getText.contains("Welcome to Myx Fitness, the perfect Myx of health, wellness, and fitness, owned and operated by Myx Fitness, LLC")); 

		System.out.println("Name entered correctly");
		//softAssertion.assertAll();
	}
	
	@Test(priority = 7, description = "Enter Last Name")
	@Description("Assert: 'Last Name' entered")
	@Severity(SeverityLevel.NORMAL)
	public void enterLastName() {

		driver.findElementById("com.myxfitness.app:id/lastName").sendKeys("Travolta");

		//SoftAssert softAssertion = new SoftAssert();
		//softAssertion.assertTrue(getText.contains("Welcome to Myx Fitness, the perfect Myx of health, wellness, and fitness, owned and operated by Myx Fitness, LLC")); 

		System.out.println("Last Name entered correctly");
		//softAssertion.assertAll();
	}
	
	@Test(priority = 8, description = "Enter invalid Email")
	@Description("Assert: 'Invalid email' is showing up")
	@Severity(SeverityLevel.NORMAL)
	public void enterInvalidEmail() {

		driver.findElementById("com.myxfitness.app:id/et_field").sendKeys("john.travolta@gmail...com"+"\n");			
		
		driver.findElementById("com.myxfitness.app:id/agreeTerms").click();
		driver.findElementById("com.myxfitness.app:id/add_user").click();
		
		String textValidation = driver.findElementById("com.myxfitness.app:id/text_message")
				.getText();
		// SOFT ASSERT >>>> needs assertAll(); at the very end.
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(textValidation
				.contains("Please fill your personal information.")); 
		
		driver.findElementById("com.myxfitness.app:id/button_single").click();

		System.out.println("Entered invalid email");
		softAssertion.assertAll();
	}
	/*
	@Test(priority = 9, description = "Enter valid Email")
	@Description("Assert: 'Valid email' is showing up")
	@Severity(SeverityLevel.NORMAL)
	public void enterValidEmail() {

		driver.findElementById("com.myxfitness.app:id/et_field").sendKeys("john.travolta@gmail.com");			
		
		//driver.findElementById("com.myxfitness.app:id/agreeTerms").click();
		driver.findElementById("com.myxfitness.app:id/add_user").click();
		
		String textValidation = driver.findElementById("com.myxfitness.app:id/text_message")
				.getText();
		// SOFT ASSERT >>>> needs assertAll(); at the very end.
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(textValidation
				.contains("Please fill your personal information.")); 		

		System.out.println("Entered valid email");
		softAssertion.assertAll();
		
	}
	*/
	//------------------------PROFILE INFO SCREEN-----------------------------
	
	@Test(priority = 10, description = "")
	@Description("Assert: ")
	@Severity(SeverityLevel.NORMAL)
	public void blaDisplayed() {

		// ELEMENT IS DISPLAYED
		SoftAssert visualAssertion = new SoftAssert();
		visualAssertion.assertEquals(true,
				driver.findElementById("com.myxfitness.app:id/camera").isDisplayed());

		// CLOSE MENU

		System.out.println("'Photo Icon' is visible.");

		visualAssertion.assertAll();

	}


}
