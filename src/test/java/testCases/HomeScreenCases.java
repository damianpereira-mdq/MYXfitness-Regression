package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Regression Test")
@Feature("Home Screen Tests")

public class HomeScreenCases extends SetupConnection {
	

	@Test(priority = 0, description = "Open and Close Menu functionality")
	@Description("Open the menu and check if all the options are visible.")
	@Severity(SeverityLevel.NORMAL)
	public void openMenu() {
		
		//OPEN MENU		
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		//ELEMENT IS DISPLAYED
		String displayValidation = driver.findElementById("com.myxfitness.app:id/manageProfile").getText();
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertTrue(displayValidation.contains("MANAGE PROFILES"));		
		
		//CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/container").click();
		System.out.println("1- Open Menu Check all options are displayed.");
		
		softAssertion.assertAll();
	}
	
	@Test(priority = 1, description = "Open menu and check profile 1 and 2 are displayed")
	@Description("Open the menu and check if the main and secondary profile are visible")
	@Severity(SeverityLevel.NORMAL)
	public void openMenuCheckProfiles() {
		
		//OPEN MENU		
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		//ELEMENTS ARE DISPLAYED		
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(true, driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]").isDisplayed());
		
		SoftAssert softAssertion2= new SoftAssert();
		softAssertion2.assertEquals(true, driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]").isDisplayed());
		
		//CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/container").click();
		System.out.println("2- Profiles 1 and 2 are displayed.");
		softAssertion.assertAll();		
		
	}
	
	//SWITCH BETWEEN PROFILES 1 and 2
	
	@Test(priority = 2, description = "Open menu and check profile 1 and 2 are displayed")
	@Description("Open the menu and switch from the main to the secondary profile")
	@Severity(SeverityLevel.NORMAL)
	public void openMenuSwitchProfiles() throws Exception {
		
		//OPEN MENU		
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		//SELECT PROFILE 2	
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]").click();
		Thread.sleep(3000);
		
		//OPEN MENU		
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		//SELECT PROFILE 1 
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]").click();
		SoftAssert softAssertion2= new SoftAssert();
		softAssertion2.assertEquals(true, driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]").isDisplayed());
		
		//CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/container").click();
		System.out.println("3- Open the menu and switch from the main to the secondary profile");
		softAssertion2.assertAll();		
		
	}
	
	
	//CONTINUE FROM HERE
	
	
	
	@Test(priority = 3, description = "Open menu and check profile 1 and 2 are displayed")
	@Description("Open the menu and check if the main and secondary profile are visible")
	@Severity(SeverityLevel.NORMAL)
	public void openMenuCheckAddUser() throws InterruptedException {
		
		//OPEN MENU		
		driver.findElementById("com.myxfitness.app:id/profileHeader").click();

		//ELEMENTS ARE DISPLAYED
		
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(true, driver.findElementById("com.myxfitness.app:id/manageProfile").isDisplayed());
		
		
		
		driver.findElementById("com.myxfitness.app:id/settings").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/stats").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/settings").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/account_label").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/tutorials").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/assesment").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/help").isDisplayed();
		driver.findElementById("com.myxfitness.app:id/logout").isDisplayed();

		
		
		
		//CLOSE MENU
		driver.findElementById("com.myxfitness.app:id/container").click();
		System.out.println("4- Open Menu Check all options are displayed.");
		softAssertion.assertAll();
		Thread.sleep(3000);
	}
	
	

}
