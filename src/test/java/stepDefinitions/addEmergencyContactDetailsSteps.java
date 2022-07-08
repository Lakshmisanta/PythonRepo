package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import PageMethods.homePageMethod;
import PageMethods.loginLogoutPage;
import PageMethods.mydetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class addEmergencyContactDetailsSteps extends commonMethods {

  mydetailsPage objmydetailsPage;
	homePageMethod objhomePageMethod;
  emergencyContactDetailsPage emergencyContactDtlPage
  SoftAssert softAssert;

	@Before
	public void setUp() {

		objmydetailsPage = new mydetailsPage(commonMethods.driver);
		objhomePageMethod = new homePageMethod(commonMethods.driver);
    emergencyContactDtlPage = new emergencyContactDetailsPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}

  @Then("I cancel to review changes")
	public void cancelToReviewChanges() {

		emergencyContactDetailsPage.cancelReviewChanges();
	}

	@Then("I choose to cancel contact details")
	public void i_choose_to_cancel_emergency_contact_details() {

		emergencyContactDetailsPage.cancelContactDetails();
	}

	@Then("again decide to continue editing contact details")
	public void again_decide_to_continue_editing_emergency_contact_details() {

		emergencyContactDetailsPage.continueEditingContactDetails();
	}

  @Then("I choose to review changes")
	public void chooseToReviewChanges() {
		emergencyContactDetailsPage.clickReviewChanges();
	}

  @Then("I am redirected to add emergency contact page")
	public void i_am_redirected_to_emergency_contact_page() {
		softAssert.assertEquals(emergencyContactDetailsPage.is_Add_EmergencyContact_Displayed(),true,
														"Add Emergency Contacts is not displayed");
	}

  @Then("emergency contact is added")
	public void emergency_contact_is_added() {
	    // Verify on
      emergencyContactDetailsPage.isEmergencyContactAdded();
	}

  @Then("decide to discard contact details")
  public void again_decide_to_discard_contact_details() {
    emergencyContactDetailsPage.DiscardContactDetails();
  }

  @Then("I save changes to add contact details")
  public void i_click_on_save_changes_review_changes() throws InterruptedException {
    emergencyContactDetailsPage.SaveReviewChanges();
  }

  @Then("I enter mandatory details")
	public void i_enter_mandatory_fields(DataTable table) throws InterruptedException {

		emergencyContactDetailsPage.enterMandatorydata(table);
	}

  @Then("I enter optional details")
	public void i_enter_optional_fields(DataTable table) throws InterruptedException {

		emergencyContactDetailsPage.enterOptionaldata(table);
	}
}
