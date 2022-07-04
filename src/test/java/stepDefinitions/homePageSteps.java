package stepDefinitions;

import java.io.IOException;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import PageMethods.commonMethods;
import PageMethods.homePageMethod;
import PageMethods.loginLogoutPage;
import PageMethods.myTimeOffPage;
import io.cucumber.java.en.*;

public class homePageSteps {

	WebDriver driver;
	homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);
	myTimeOffPage timeoffpage = new myTimeOffPage(commonMethods.driver);
	SoftAssert softAssert = new SoftAssert();



	@Given("I navigate to Inside UCL app")
	public void i_navigate_to_inside_ucl_app() throws InterruptedException {

		commonMethods.navigate_to_URL();
	}

	@When("I login to application")
	public void i_login_to_application() throws IOException, InterruptedException {

		objhomePageMethod.loginToApp();
	}


	@And("I click on Mydetails Tile")
	public void i_click_on_mydetails_tile() throws InterruptedException {

		objhomePageMethod.my_details();

	}

	@Then("I should see Mydetails page")
	public void i_should_see_mydetails_page() throws InterruptedException {

		objhomePageMethod.my_details_Page();
	}

	@When("I click on MyTimeOff Tile")
	public void i_click_on_my_time_off_tile() {

		objhomePageMethod.my_time_Off();
	}

	@Then("I should see MyTimeOff page")
	public void i_should_see_my_time_off_page() throws InterruptedException {

		softAssert.assertEquals(timeoffpage.isMyTimeOffDisplayed(),true);
		softAssert.assertAll();
	}

}
