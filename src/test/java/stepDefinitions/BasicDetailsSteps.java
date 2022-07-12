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


	@Then("title first name last name are disabled")
	public void title_firstname_lastname_are_disabled() {
			softAssert.assertTrue(objbasicdetailsPage.enterUserDetails());
	}

	@And("date of birth ni number nationality are disabled")
	public void DOB_NI_number_nationality_should_not_get_edited() {

		softAssert.assertTrue(objbasicdetailsPage.enterSubDetails());
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


	@When("no details entered")
	public void no_details_entered() {
    // See if preferred first and last name are empty
		softAssert.assertEquals(objbasicdetailsPage.getTextBoxValue("Preferred First Name"),new String(""));
		softAssert.assertEquals(objbasicdetailsPage.getTextBoxValue("Preferred Last Name"),new String(""));
		softAssert.assertAll();
	}

	@Then("I can not review changes")
	public void i_can_not_review_changes() {
		softAssert.assertFalse(objbasicdetailsPage.isReviewChangesEnabled());
	}

	@When("I enter optional basic contact details")
	public void i_enter_optional_basic_details(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
		objbasicdetailsPage.updateBasicContactDetails(dataTable);
	}

	@When("I choose to cancel editing of basic contact details")
	public void i_choose_to_cancel_editing_basic_contact_details() {

		objbasicdetailsPage.cancelBasicContactDetails();
	}
	@When("decide to discard entered basic contact details")
	public void decide_to_discard_entered_basic_contact_details() {
	  objbasicdetailsPage.DiscardContactDetails();
	}

	@When("again decide to continue editing of basic contact details")
	public void again_decide_to_continue_editing_of_basic_contact_details() {
		objbasicdetailsPage.continueEditingContactDetails();
	}
	@When("I review changes in basic details")
	public void i_review_changes_in_basic_details() {
	  objbasicdetailsPage.clickReviewChanges();
	}
	@When("I save changes as final")
	public void i_save_changes_as_final() {
	  objbasicdetailsPage.SaveReviewChanges();
	}
	@Then("I should see details are saved")
	public void i_should_see_details_are_saved() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
	}
}
