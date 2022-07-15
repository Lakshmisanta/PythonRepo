package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import PageMethods.contactDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class ContactDetailsSteps extends commonMethods {

	// remove below lines with parallel-test branch is merged.
	//mydetailsPage objbasicdetailsPage. = new mydetailsPage(commonMethods.driver);
	//homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	contactDetailsPage objcontactdetailsPage;
  SoftAssert softAssert;

	@Before
	public void setUp() {
		objcontactdetailsPage = new contactDetailsPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}

	@Then("contact details landing page is displayed")
	public void contact_details_landing_page_is_displayed() {
		softAssert.assertEquals(objcontactdetailsPage.is_ContactDetails_Landing_Displayed(),true,
																"Basic details page is not displayed");
	}

	@When("I choose to edit contact details")
	public void i_choose_to_edit_contact_details() {
	  objcontactdetailsPage.edit_details();
	}

	@Then("contact details page is displayed")
	public void contact_details_page_is_displayed() {
		softAssert.assertEquals(objcontactdetailsPage.is_ContactDetails_Displayed(),true,
																"Basic details page is not displayed");
	}

	@When("I enter phone contact details as below")
	public void i_enter_phone_contact_details_as_below(io.cucumber.datatable.DataTable dataTable) {
		objcontactdetailsPage.updatePhoneEmailDetails(dataTable);
	}



	@When("I enter main address contact details as below")
	public void i_enter_main_address_contact_details_as_below(io.cucumber.datatable.DataTable dataTable) {
	  objcontactdetailsPage.updateMainAdressDetails(dataTable);
	}

	@When("I add alternative address")
	public void i_add_alternative_address() {
	   boolean clicked = objcontactdetailsPage.addAlternateAddress();
		 if( clicked ) {
			 System.out.println("Alternate address link is clicked.");
			 cucumberLogs.info("Alternate address link is clicked.");
		 }
		 else {
			 System.out.println("Alternate address link is not visible.");
			 cucumberLogs.info("Alternate address link is not visible.");
		 }

	}

	@When("I enter alternative address contact details as below")
	public void i_enter_alternative_address_contact_details_as_below(io.cucumber.datatable.DataTable dataTable) {
	    objcontactdetailsPage.updateAlternateAdressDetails(dataTable);
	}

	@When("delete alternative address")
	public void delete_alternative_address() {
	  objcontactdetailsPage.deleteAlternateAddress();
	}

	@When("I choose to cancel editing of contact details")
	public void i_choose_to_cancel_editing_of_contact_details() {
	  objcontactdetailsPage.cancelEditingContactDetails();
	}

	@When("again decide to continue editing of contact details")
	public void again_decide_to_continue_editing_of_contact_details() {
	  objcontactdetailsPage.continueEditingContactDetails();
	}

	@When("I review changes in contact details")
	public void i_review_changes_in_contact_details() {
	   objcontactdetailsPage.clickReviewChanges();
	}

	@When("I save changes in contact details as final")
	public void i_save_changes_in_contact_details_as_final() {
	    objcontactdetailsPage.SaveReviewChanges();
	}

	@Then("I should see contact details are saved")
	public void i_should_see_contact_details_are_saved() {
		softAssert.assertTrue(objcontactdetailsPage.isMainCityUpdated());
		softAssert.assertTrue(objcontactdetailsPage.isMainCountyUpdated());
		softAssert.assertTrue(objcontactdetailsPage.isMainPostcodeUpdated());

		softAssert.assertTrue(objcontactdetailsPage.isaltCityUpdated());
		softAssert.assertTrue(objcontactdetailsPage.isaltCountyUpdated());
		softAssert.assertTrue(objcontactdetailsPage.isaltPostcodeUpdated());
		softAssert.assertAll();
	}

}
