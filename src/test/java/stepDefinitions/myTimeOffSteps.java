package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import PageMethods.commonMethods;
import PageMethods.homePageMethod;
import PageMethods.loginLogoutPage;
import PageMethods.myTimeOffPage;
import PageMethods.mydetailsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class myTimeOffSteps {

	WebDriver driver;
	myTimeOffPage objmyTimeOffPage = new myTimeOffPage(commonMethods.driver);
	homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	@Then("Navigate to myTimeOff page")
	public void navigate_to_myTimeOff_page() {

		objhomePageMethod.my_time_Off();
	}

	@And("Get pending annual leaves")
	public void get_pending_annual_leaves() throws IOException, InterruptedException {

	}

	@And("Get the leaves taken")
	public void get_the_leaves_taken() throws IOException, InterruptedException {

	}
}
