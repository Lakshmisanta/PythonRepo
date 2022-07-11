package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import PageMethods.homePageMethod;
import PageMethods.loginLogoutPage;
import PageMethods.basicDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class BasicDetailsSteps extends commonMethods {

	// remove below lines with parallel-test branch is merged.
	//mydetailsPage objbasicdetailsPage. = new mydetailsPage(commonMethods.driver);
	//homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	basicDetailsPage objbasicdetailsPage;
	homePageMethod objhomePageMethod ;
  SoftAssert softAssert;

	@Before
	public void setUp() {
		objbasicdetailsPage = new basicDetailsPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}

	/*@When("I click on Edit details")
	public void i_click_on_edit_details() {

		objbasicdetailsPage.edit_details();
	}*/

	@Then("Title Firstname Lastname are disabled")
	public void title_firstname_lastname_are_disabled() {
			softAssert.assertEquals(objbasicdetailsPage.enterUserDetails(),true);
	}

	@And("DOB NI number Nationality are disabled")
	public void DOB_NI_number_nationality_should_not_get_edited() {

		softAssert.assertEquals(objbasicdetailsPage.enterSubDetails(),true);
	}

	@When("No details entered then review changes is disabled")
	public void no_details_entered_then_review_changes_button_is_disabled() {

		//objbasicdetailsPage.reviewChanges();
	}

	@When("I should enter optional basic details")
	public void i_should_enter_optional_basic_details() {

		objbasicdetailsPage.enterOptionalDetails();
	}

	@Then("review changes button is Enabled")
	public void review_changes_button_is_enabled() {
		//objbasicdetailsPage.reviewChanges();
	}

	@Then("I click on Cancel then continue editing")
	public void i_click_on_cancel_then_continue_editing() {

		//objbasicdetailsPage.cancel_Details();
	}

	@Then("I click on Cancel")
	public void i_click_on_cancel() {

	//	objbasicdetailsPage.cancelDetails();
	}

	@Then("basic details landing page is displayed")
	public void basic_details_landing_page_is_displayed() {
		softAssert.assertEquals(objbasicdetailsPage.is_BasicDetails_Landing_Displayed(),true,
														"Basic details page is not displayed");

	}

	@When("I choose to edit basic details")
	public void i_choose_to_edit_basic_details() {
	  objbasicdetailsPage.edit_details();
	}

	@Then("basic details page is displayed")
	public void basic_details_page_is_displayed() {
		softAssert.assertEquals(objbasicdetailsPage.is_BasicDetails_Displayed(),true,
														"Basic details page is not displayed");
	}

}
