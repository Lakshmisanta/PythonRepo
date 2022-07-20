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

	@When("I enter edit details as below")
	public void i_edi_details_as_below(io.cucumber.datatable.DataTable dataTable) {
	    objediPage.updateEDIDetails(dataTable);
	}


	// @When("I add my professional skills")
	// public void i_add_my_professional_skills() {
	// 	objskillsPage.addSkill();
	// }

	@When("I choose to cancel entered of edi details")
  public void i_choose_to_cancel_editing_of_edi_details() {
	 	objediPage.cancelAddedEdiDetails();
	}

	// // @Then("I am on interest details landing page")
	// // public void i_am_on_interest_details_landing_page() {
	// //
	// // }
	//
	@When("decide to discard entered edi details")
	public void decide_to_discard_entered_edi_details() {
		objediPage.discardAddedEdiDetails();
	}

	@Then("I am redirected to edi landing page")
	public void i_am_redirected_to_edi_landing_page() {
		softAssert.assertEquals(objediPage.is_EDIDetails_Landing_Displayed(),true,
																"EDI details page is not displayed");
	}

	// //
	// // @When("again decide to continue editing of interests")
	// // public void again_decide_to_continue_editing_of_interests() {
	// // 	objinterestsPage.continueEditingContactDetails();
	// // }
	//
	// @When("again decide to continue editing of skills")
	// public void again_decide_to_continue_editing_of_skills() {
	// 	objskillsPage.continueEditingSkills();
	// }
	//
	// @When("I delete recently added skill")
	// public void i_delete_recently_added_skill() {
	// 	softAssert.assertTrue(objskillsPage.deleteLatestSkill());
	// 	objskillsPage.confirmDeleteSkill();
	// 	softAssert.assertAll();
	// }
	//
	// @Then("skill should not be displayed in list")
	// public void skill_should_not_be_displayed_in_list() {
	// 	softAssert.assertTrue(objskillsPage.isDeletedSkillDisplayed());
	// }
	//
	// @When("I save changes in skill as final")
	// public void i_save_changes_in_skill_as_final() {
	// 	objskillsPage.SaveChanges();
	// }
	//
	// @Then("I should see skill is added")
	// public void i_should_see_skill_is_added() {
	// 		softAssert.assertTrue(objskillsPage.isAddedSkillDisplayed());
	// }


}
