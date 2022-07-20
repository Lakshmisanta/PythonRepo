package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import PageMethods.EDIPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class EdiSteps extends commonMethods {

	// remove below lines with parallel-test branch is merged.
	//mydetailsPage objbasicdetailsPage. = new mydetailsPage(commonMethods.driver);
	//homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	EDIPage objediPage;
  SoftAssert softAssert;

	@Before
	public void setUp() {
		objediPage = new EDIPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}


	@Then("edi landing page is displayed")
	public void edi_landing_page_is_displayed() {
		 	softAssert.assertEquals(objediPage.is_EDIDetails_Landing_Displayed(),true,
		 															"EDI details page is not displayed");
	}
	// @When("I choose to edit skills")
	// public void i_choose_to_edit_skills() {
	//     // Write code here that turns the phrase above into concrete actions
	//   objskillsPage.edit_details();
	// }

	@When("I choose to edit EDI details")
	public void i_choose_to_edit_edit_details() {
		objediPage.edit_details();
	}

	@Then("edit EDI page is displayed")
	public void edit_edi_page_is_displayed() {
		softAssert.assertEquals(objediPage.is_EDIDetails_Displayed(),true,
																"Skill details page is not displayed");
	}

	@When("I enter edi details as below")
	public void i_edi_details_as_below(io.cucumber.datatable.DataTable dataTable) {
	    objediPage.updateEDIDetails(dataTable);
	}

	@When("I choose to cancel entered of edi details")
  public void i_choose_to_cancel_entered_of_edi_details() {
	 	objediPage.cancelAddedEdiDetails();
	}

	@When("I choose to cancel editing of edi details")
  public void i_choose_to_cancel_editing_of_edi_details() {
	 	objediPage.cancelAddedEdiDetails();
	}

	@When("decide to discard entered edi details")
	public void decide_to_discard_entered_edi_details() {
		objediPage.discardAddedEdiDetails();
	}

	@Then("I am redirected to edi landing page")
	public void i_am_redirected_to_edi_landing_page() {
		softAssert.assertEquals(objediPage.is_EDIDetails_Landing_Displayed(),true,
																"EDI details page is not displayed");
	}

	@When("I review changes in edi details")
	public void i_review_changes_in_edi_details() {
	  objediPage.clickReviewChanges();
	}

	@When("again I review changes in edi details")
	public void again_i_review_changes_in_edi_details() {
	    objediPage.clickReviewChanges();
	}

	@When("I cancel reviewed changes in edi details")
	public void i_cancel_reviewed_changes_in_edi_details() {
	    objediPage.cancelReviewChanges();
	}

	@When("I save changes in edi details as final")
	public void i_save_changes_in_edi_details_as_final() {
	    objediPage.SaveReviewChanges();
	}

	@Then("I should see edi details are saved")
	public void i_should_see_edi_details_are_saved() {
		softAssert.assertTrue(objediPage.isEthnicOriginUpdated());
		softAssert.assertTrue(objediPage.isGenderUpdated());
		softAssert.assertAll();
	}

	@When("again decide to continue editing of edi details")
	public void again_decide_to_continue_editing_of_edi_details() {
		objediPage.continueEditingEDIDetails();
	}


}
