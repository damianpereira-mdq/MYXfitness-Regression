package testCases;



import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("Regression Test")
@Feature("Who's working out Test cases")

public class WhosWorkingCases extends SetupConnection {
	
	

	@Test
	public void validateOptionsAvailable () throws InterruptedException {
		
		driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"image\"])[1]").click();
		//Thread.sleep(10000);
		
	}
	

}
