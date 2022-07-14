package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import PageMethods.homePageMethod;
import PageMethods.loginLogoutPage;
import PageMethods.bankDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class BankDetailsSteps extends commonMethods {

	// remove below lines with parallel-test branch is merged.
	//mydetailsPage objbasicdetailsPage. = new mydetailsPage(commonMethods.driver);
	//homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	bankDetailsPage objbankdetailsPage;
	homePageMethod objhomePageMethod ;
  SoftAssert softAssert;

	@Before
	public void setUp() {
		objbankdetailsPage = new bankDetailsPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}

	@Then("bank details landing page is displayed")
	public void bank_details_landing_page_is_displayed() {
		softAssert.assertEquals(objbankdetailsPage.is_BankDetails_Landing_Displayed(),true,
														"Basic details page is not displayed");
	}

	@When("I choose to edit bank details")
	public void i_choose_to_edit_bank_details() {
		objbankdetailsPage.edit_details();
	}

	@Then("bank details page is displayed")
	public void bank_details_page_is_displayed() {
		softAssert.assertEquals(objbankdetailsPage.is_BankDetails_Displayed(),true,
														"Basic details page is not displayed");
	}

	@When("I enter bank details as")
	public void i_enter_bank_contact_details(io.cucumber.datatable.DataTable dataTable) {
			// Write code here that turns the phrase above into concrete actions
			// For automatic transformation, change DataTable to one of
			// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
			// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
			// Double, Byte, Short, Long, BigInteger or BigDecimal.
			//
			// For other transformations you can register a DataTableType.
			objbankdetailsPage.updateBankDetails(dataTable);
	}

	@When("I choose to cancel editing of bank contact details")
	public void i_choose_to_cancel_editing_of_bank_contact_details() {
		objbankdetailsPage.cancelBankDetails();
	}

	@When("I again choose to edit bank details")
	public void i_again_choose_to_edit_bank_details() {
    objbankdetailsPage.edit_details();
	}

	@Then("bank name and branch is disabled")
	public void bank_name_and_branch_name_is_disabled() {
		softAssert.assertFalse(objbankdetailsPage.isBankNameEnabled());
		softAssert.assertFalse(objbankdetailsPage.isBranchEnabled());
		softAssert.assertAll();
	}
	@When("decide to discard entered bank details")
	public void decide_to_discard_entered_bank_details() {
		objbankdetailsPage.discardBankDetails();
	}

	@When("continue editing entered bank details")
	public void continue_editing_entered_bank_details() {
		objbankdetailsPage.continueEditingContactDetails();
	}

	@When("I review changes in bank details")
	public void i_review_changes_in_bank_details() {
	  objbankdetailsPage.clickReviewChanges();
	}

	@When("I cancel reviewed changes in bank details")
	public void i_cancel_reviewed_changes_in_bank_details() {
	  objbankdetailsPage.cancelReviewChanges();
	}

	@When("again I review changes in bank details")
	public void again_i_review_changes_in_bank_details() {
	  objbankdetailsPage.clickReviewChanges();
	}

	@When("I save changes in bank details as final")
	public void i_save_changes_in_bank_details_as_final() {
	  objbankdetailsPage.SaveReviewChanges();
	}

	@Then("I should see bank details are saved")
	public void i_should_see_bank_details_are_saved() {
		softAssert.assertTrue(objbankdetailsPage.isAccountHolderNameUpdated());
		softAssert.assertTrue(objbankdetailsPage.isAccountNumberUpdated());
		softAssert.assertTrue(objbankdetailsPage.isSortCodeUpdated());
		softAssert.assertAll();
	}

}
