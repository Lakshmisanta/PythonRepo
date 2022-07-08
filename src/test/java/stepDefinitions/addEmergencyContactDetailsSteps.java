package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.emergencyContactDetailsPage;
import PageMethods.homePageMethod;
import PageMethods.loginLogoutPage;
import PageMethods.mydetailsPage;
import PageMethods.commonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class addEmergencyContactDetailsSteps extends commonMethods {

  emergencyContactDetailsPage emergencyContactDtlPage;
  SoftAssert softAssert;

	@Before
	public void setUp() {

    emergencyContactDtlPage = new emergencyContactDetailsPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}

  @Then("I cancel to review changes")
	public void cancelToReviewChanges() {

		emergencyContactDtlPage.cancelReviewChanges();
	}

	@Then("I choose to cancel contact details")
	public void i_choose_to_cancel_emergency_contact_details() {

		emergencyContactDtlPage.cancelContactDetails();
	}

	@Then("again decide to continue editing contact details")
	public void again_decide_to_continue_editing_emergency_contact_details() {

		emergencyContactDtlPage.continueEditingContactDetails();
	}

  @Then("I choose to review changes")
	public void chooseToReviewChanges() {
		emergencyContactDtlPage.clickReviewChanges();
	}

  @Then("I am redirected to add emergency contact page")
	public void i_am_redirected_to_emergency_contact_page() {
		softAssert.assertEquals(emergencyContactDtlPage.is_Add_EmergencyContact_Displayed(),true,
														"Add Emergency Contacts is not displayed");
	}

  @Then("emergency contact is added")
	public void emergency_contact_is_added() {
	    // Verify on
      emergencyContactDtlPage.isEmergencyContactAdded();
	}

  @Then("decide to discard contact details")
  public void again_decide_to_discard_contact_details() {
    emergencyContactDtlPage.DiscardContactDetails();
  }

  @Then("I save changes to add contact details")
  public void i_click_on_save_changes_review_changes() throws InterruptedException {
    emergencyContactDtlPage.SaveReviewChanges();
  }

  @Then("I enter mandatory details")
	public void i_enter_mandatory_fields(DataTable table) throws InterruptedException {

		emergencyContactDtlPage.enterMandatorydata(table);
	}

  @Then("I enter optional details")
	public void i_enter_optional_fields(DataTable table) throws InterruptedException {

		emergencyContactDtlPage.enterOptionaldata(table);
	}
}
