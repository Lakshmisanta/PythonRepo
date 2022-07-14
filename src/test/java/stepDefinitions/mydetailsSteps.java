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


public class mydetailsSteps extends commonMethods {

	// remove below lines with parallel-test branch is merged.
	//mydetailsPage objmydetailsPage = new mydetailsPage(commonMethods.driver);
	//homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	mydetailsPage objmydetailsPage;
	homePageMethod objhomePageMethod ;
  SoftAssert softAssert;

	@Before
	public void setUp() {
		objmydetailsPage = new mydetailsPage(commonMethods.driver);
		objhomePageMethod = new homePageMethod(commonMethods.driver);
		softAssert = new SoftAssert();

	}

	@After
	public void tearDown(){

	}

	@Given("I am logged onto UCL as a registered user")
	public void login_application_url() throws InterruptedException {

		objhomePageMethod.loginToApp();
	}

	@Then("I navigate to mydetails page")
	public void navigate_to_mydetails_page() throws InterruptedException {

		objmydetailsPage.my_details();
	}

	@Given("I navigate to basic details")
	public void i_click_on_basic_details() {

		objmydetailsPage.basic_details();
	}


	@And("DOB NI number Nationality should not get edited")
	public void DOB_NI_number_nationality_should_not_get_edited() {

		objmydetailsPage.enterSubDetails();
	}


	@When("I should enter optional basic details")
	public void i_should_enter_optional_basic_details() {

		objmydetailsPage.enterOptionalDetails();
	}

	@Then("review changes button is Enabled")
	public void review_changes_button_is_enabled() {
		objmydetailsPage.reviewChanges();
	}

	@Then("I click on Cancel then continue editing")
	public void i_click_on_cancel_then_continue_editing() {

		objmydetailsPage.cancel_Details();
	}


	@Given("I click on Contact details")
	public void i_click_on_contact_details() {

		objmydetailsPage.contact_details();
	}

	@When("^I should enter mandatory (.*) and (.*)$")
	public void i_should_enter_mandatory_address1_and_address2(String address1, String address2) {

		objmydetailsPage.enterAddress(address1, address2);

	}

	@Then("I enter optional contact details")
	public void i_enter_optional_contact_details() {

		objmydetailsPage.enterOptionalContactDetails();
	}

	@Then("^Click on Add alternative and add (.*)$")
	public void click_on_add_alternative_and_add_address3(String address3) throws InterruptedException {

		objmydetailsPage.addAlternativeAddress(address3);

	}

	@And("Delete alternative address")
	public void delete_alternative_address() {
		objmydetailsPage.deleteAlternateAddress();
	}

	@Given("I navigate to emergency contact details")
	public void i_am_navigating_to_emergency_contact_details() {

		objmydetailsPage.Emergency_details();
	}

	@Then("I should see emergency contact details")
	public void i_should_see_emergency_contact_details() {

		objmydetailsPage.Verify_Emergency_page();
	}

	@When("I click add emergency contact")
	public void i_click_add_emergency_contact() {

		objmydetailsPage.addEmergencyContact();
	}

	@Then("I am redirected to emergency contact landing page")
	public void i_am_redirected_to_emergency_contact_landing_page() {
		softAssert.assertEquals(objmydetailsPage.is_EmergencyContact_Landing_Displayed(),true,
														"Emergency Contacts landing is not displayed");
	}


	@Then("I click on review changes and verify changes")
	public void i_click_on_review_changes_and_verify_changes() throws InterruptedException {
		objmydetailsPage.clickReviewAndVerify();
	}


	@When("I click Edit emergency details")
	public void i_click_edit_emergency_details() {
		objmydetailsPage.clickEditEmergencydetails();
	}

	@When("I edit an existing emergency contact")
  public void i_edit_an_existing_emergency_contact() {
		objmydetailsPage.clickEditEmergencydetails();
  }

	@Then("I should Edit Mandatory fields")
	public void i_should_edit_mandatory_fields() throws InterruptedException {
		objmydetailsPage.editMandatoryField();
	}

	@Then("I should Edit optional fields")
	public void i_should_edit_optional_fields() throws InterruptedException {
		objmydetailsPage.editOptionalField();
	}

	@Given("I am navigating to EDI")
	public void i_am_navigating_to_edi() {
		objmydetailsPage.EDI();
	}

	@When("I click Edit EDI")
	public void i_click_edit_edi() {
		objmydetailsPage.Edit_EDI();
	}

	@Then("I edit EDI fields")
	public void i_edit_edi_fields() throws InterruptedException {

		objmydetailsPage.Edit_EDI_details();

	}

	@Given("I click on Education and qualification")
	public void i_click_on_education_and_qualification() {
		objmydetailsPage.educationAndQualification();
	}

	@When("I click on Add Qualification")
	public void i_click_on_add_qualification() {
		objmydetailsPage.AddQualification();
	}

	@Then("I should complete mandatory and optional details")
	public void i_should_complete_mandatory_and_optional_details(DataTable table) throws InterruptedException {
		objmydetailsPage.enterQualificationdetails(table);
	}

	@Then("I should add the subject")
	public void i_should_add_the_subject() throws InterruptedException {
		objmydetailsPage.AddSubject();
	}

	@Then("I should delete the subject and verify subject deleted")
	public void i_should_delete_the_subject_and_verify_subject_deleted() {
		objmydetailsPage.DeleteSubject();
	}

	@When("I click on Edit qualification details")
	public void i_click_on_edit_qualification_details() throws InterruptedException {

		objmydetailsPage.Edit();
	}

	@Then("I should Edit mandatory and optional details")
	public void i_should_edit_mandatory_and_optional_details(DataTable table) throws InterruptedException {
		objmydetailsPage.editQualificationDetails(table);
	}

	@Then("I should delete qualification")
	public void i_should_delete_qualification() {
		objmydetailsPage.DeleteQualification();
	}

	@Given("I click on Disability")
	public void i_click_on_disability() {

		objmydetailsPage.Disability();
	}

	@When("I click on Add disability record")
	public void i_click_on_add_disability_record() {

		objmydetailsPage.AddDisability();

	}

	@And("^I select (.*) as disability$")
	public void i_select_disabilty_type_as_disability(String disabilityType) throws InterruptedException {

		objmydetailsPage.selectDisabilityType(disabilityType);
	}

	@Then("^Verify Reason field is disabled or enabled according to (.*)$")
	public void verify_reason_field_is_disabled_or_enabled_according_to_disablity_type(String disabilityType)
			throws IOException {

		objmydetailsPage.VerifyDisabilityReason(disabilityType);
	}

	@Then("Select reason if disabilityType is yes")
	public void select_reason_if_disabilityType_is_yes() throws IOException {

		objmydetailsPage.Disability_Reason();
	}

	@Then("Add StartDate and EndDate for disability")
	public void add_startdate_and_enddate_for_disability() throws IOException {

		objmydetailsPage.Disability_dates();
	}

	@When("I click on Edit disability record")
	public void i_click_on_edit_disability_record() throws InterruptedException {
		objmydetailsPage.Edit();
	}

	@When("^I  edit (.*) as disability$")
	public void i_edit_no_as_disability(String disabilityType) throws InterruptedException {

		objmydetailsPage.selectDisabilityType(disabilityType);
	}

	@Given("I click on Employment history")
	public void i_click_on_employment_history() {

		objmydetailsPage.employment_history();
	}

	@When("I click on View employment details")
	public void i_click_on_view_employment_details() {
		objmydetailsPage.view_employment_details();
	}

	@Then("Verify employment details fields")
	public void verify_employment_details_fields() {
		objmydetailsPage.Verify_employmentFields();
	}

	@Given("I click on Work locations")
	public void i_click_on_work_locations() {
		objmydetailsPage.work_locations();
	}

	@When("I click on Edit location details")
	public void i_click_on_edit_location_details() throws InterruptedException {
		objmydetailsPage.Edit();
	}

	@When("I should Edit location details")
	public void i_should_edit_location_details() {
		objmydetailsPage.edit_work_locations();
	}

	@Given("I navigate to bank details")
	public void i_click_on_bank_details() {
		objmydetailsPage.bank_details();
	}

	@Given("I click on skills")
	public void i_click_on_skills() {
		objmydetailsPage.skills();
	}

	@When("I click on Edit Skills")
	public void i_click_on_edit_skills() throws InterruptedException {
		objmydetailsPage.Edit();
	}

	@When("I should add Skills")
	public void i_should_add_skills() {
		objmydetailsPage.addSkills();
	}

	@When("I should delete skills")
	public void i_should_delete_skills() {
		objmydetailsPage.deleteSkills();
	}

}
