package PageMethods;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import utilities.DateUtils;
import utilities.cucumberLogs;
import utilities.globalvariables;

public class mydetailsPage extends commonMethods {

	@FindBy(xpath = "//input[@type='email']")
	WebElement txt_Username;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_Next;

	@FindBy(name = "passwd")
	WebElement txt_Password;

	@FindBy(xpath = "//*[@class ='inside-ucl-large-tile__text OSFillParent']")
	public List<WebElement> link_MyDetails;

	@FindBy(xpath = "//div[@class ='osui-gallery']")
	WebElement link_Gallery;

	@FindBy(xpath = "//div[@class='side-menu']")
	public WebElement menu_mydetailsMenu;

	@FindBy(xpath = "//*[contains(text(),'Basic details')][@class='OSFillParent']")
	WebElement link_BasicDetails;

	@FindBy(xpath = "//*[@type = 'button']")
	WebElement btn_EditDetails;

	@FindBy(xpath = "//*[contains(text(),'Edit')]")
	public List<WebElement> btn_Edit;

	@FindBy(xpath = "//*[contains(@id, 'QualificationType')]/div/div")
	WebElement getQualificationType;

	@FindBy(xpath = "//*[contains(@id, 'QualificationType')]/div/span")
	WebElement getQualificationTypeAfterdelete;

	@FindBy(xpath = "//*[contains(text(),'Delete')]")
	WebElement delete;

	@FindBy(xpath = "//*[contains(text(),'Delete')]")
	public List<WebElement> Delete;

	@FindBy(xpath = "//input[@id = 'Input_Title_Edit']")
	WebElement txt_Title;

	@FindBy(xpath = "//*[@id = 'Input_FirstName_Edit']")
	WebElement txt_Firstname;

	@FindBy(xpath = "//*[@id = 'Input_LastName_Edit']")
	WebElement txt_Lastname;

	@FindBy(xpath = "//*[@id = 'Input_DateOfBirth_Edit']")
	WebElement txt_DOB;

	@FindBy(xpath = "//*[@id = 'Input_NINumber_Edit']")
	WebElement txt_NI_Number;

	@FindBy(xpath = "//*[@id = 'Input_Nationality_Edit']")
	WebElement txt_Nationality;

	@FindBy(xpath = "//*[@id = 'Input_FirstNamePreferred_Edit']")
	WebElement txt_PreferredName;

	@FindBy(xpath = "//*[@id = 'Input_LastNamePreferred_Edit']")
	WebElement txt_PreferredLastname;

	@FindBy(xpath = "//*[@type = 'button']")
	WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='Input_MainPostCode_Edit']")
	WebElement txt_Postcode;

	@FindBy(xpath = "//button[contains(text(),'Review changes')]")
	WebElement btn_reviewChanges;

	@FindBy(xpath = "//a[contains(text(),'Discard')]")
	public List<WebElement> btn_Discard;

	@FindBy(xpath = "//a[contains(text(),'Continue editing')]")
	WebElement btn_ContinueEditing;

	@FindBy(xpath = "//*[contains(text(),'Contact details')]")
	WebElement link_ContactDetails;

	@FindBy(xpath = "//*[contains(text(),'Equality, diversity and inclusion (EDI)')]")
	WebElement link_EDI;

	@FindBy(xpath = "//input[contains(@id,'AddressLine1_Input')]")
	WebElement txt_address1;

	@FindBy(xpath = "//input[contains(@id,'AddressLine2_Input')]")
	WebElement txt_address2;

	@FindBy(xpath = "//input[contains(@id,'AddressLine3_Input')]")
	WebElement txt_address3;

	@FindBy(xpath = "//*[@id='Input_PersonalEmailAddress_Edit']")
	WebElement txt_personalmail;

	@FindBy(xpath = "//*[@id='conAddAltAddress_Edit']")
	WebElement btn_alternativeAddress;

	@FindBy(xpath = "//*[contains(text(),'Add alternative address  ')]")
	WebElement btn_alternateAddress;

	@FindBy(xpath = "//input[contains(@id,'AddressLine1_Input')]")
	public List<WebElement> txt_altAddress1;

	@FindBy(xpath = "//input[contains(@id,'AddressLine2_Input')]")
	public List<WebElement> txt_altAddress2;

	@FindBy(xpath = "//input[contains(@id,'AddressLine3_Input')]")
	public List<WebElement> txt_altAddress3;

	@FindBy(xpath = "//*[@id='conDeleteAltAddress_Edit']")
	WebElement btn_deleteAltAddress;

	@FindBy(xpath = "//*[contains(text(),'Emergency contact details')]")
	WebElement link_EmergencyDetails;

	@FindBy(xpath = "//*[@id='b1-conReadyOnlyTitle']")
	WebElement EmergencyContacts;

	@FindBy(xpath = "//*[@class='btn OSFillParent']")
	WebElement btn_AddEmergencyAddress;

	@FindBy(xpath = "//*[@id='Dropdown_MainCounty_Edit']")
	WebElement drpdwn_Country;

	@FindBy(xpath = "//*[@id='Input_SecondaryPhoneNumber_Edit']")
	WebElement txt_mobileNo;

	@FindBy(xpath = "//*[@type = 'button']/div")
	WebElement btn_SaveChanges;

	@FindBy(xpath = "//*[@id='conLastName_Review']/span")
	WebElement txt_reviewLastNm;

	@FindBy(xpath = "//*[contains(text(),'Edit emergency contact details')]")
	WebElement btn_EditEmergencyAddress;

	@FindBy(xpath = "//*[@id = 'conFirstName_Review']/label/span")
	WebElement txt_ReviewFirstname;

	@FindBy(xpath = "//*[@id = 'conLastName_Review']/span")
	WebElement txt_ReviewLastname;

	@FindBy(xpath = "//*[@id = 'conRelationship_Review']/span")
	WebElement txt_ReviewRelationship;

	@FindBy(xpath = "//*[@id='Dropdown1']")
	WebElement drpdwn_Ethnicity;

	@FindBy(xpath = "//*[@id='Religion2']")
	WebElement drpdwn_Religion;

	@FindBy(xpath = "//*[@id='GenderSameAsBirth']")
	WebElement drpdwn_gender;

	@FindBy(xpath = "//*[@id='Gender']")
	WebElement drpdwn_Sex;

	@FindBy(xpath = "//*[@id='GenderSameAsBirth']")
	WebElement txt_gender;

	@FindBy(xpath = "//*[contains(text(),'Disability')]")
	WebElement link_Disability;

	@FindBy(xpath = "//*[@type = 'button']")
	WebElement btn_AddDisability;

	@FindBy(xpath = "//*[@id='b4-DropdownSearch']")
	WebElement drpdwn_qualificationType;

	@FindBy(xpath = "//*[@CLASS='vscomp-value']")
	WebElement drpdwn_QualificationType;

	@FindBy(xpath = "//*[@id='Dropdown_Relationship']")
	WebElement drpdwn_Relationship;

	@FindBy(xpath = "//*[@CLASS='vscomp-search-input']")
	public List<WebElement> txt_searchQualificationType;

	@FindBy(xpath = "//*[@data-tooltip='Award']")
	public List<WebElement> Select_searchQualificationType;

	@FindBy(xpath = "//*[@id='QualificationLetters2']/div/div")
	WebElement drpdwn_QualificationLetters;

	@FindBy(xpath = "//*[@class='vscomp-options']/div[1]")
	public List<WebElement> select_QualificationLetters;

	@FindBy(xpath = "//*[@CLASS='list list-group qualification-subjects-list OSFillParent']")
	WebElement drpdwn_AddSubject;

	@FindBy(xpath = "//*[contains(@id,'-b1-DropdownSearch')]")
	WebElement txt_searchSubject;

	@FindBy(xpath = "//*[contains(@id,'vscomp-dropbox-container-')]/div/div[2]/div/div/div[1]")
	public List<WebElement> Select_searchSubject;

	@FindBy(xpath = "//*[@id='Input_title']")
	WebElement txt_qualificationTitle;

	@FindBy(xpath = "//*[@id='Input_CompletionDate5']")
	WebElement txt_Completiondate;

	@FindBy(xpath = "//*[@id='b5-Datepicker']/span/input[2]")
	WebElement Completiondate;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/span[24]")
	WebElement Date;

	@FindBy(xpath = "//*[@class='inside-ucl-label OSInline']")
	WebElement headClick;

	@FindBy(xpath = "//*[@id='b6-DropdownSearch']")
	WebElement drpdwn_Qualificationletters;

	@FindBy(xpath = "//*[@id='Input_awarding_body']")
	WebElement txt_Awarding;

	@FindBy(xpath = "//*[@id='b7-AddSubject']")
	WebElement btn_AddSubject;

	@FindBy(xpath = "//*[@class='icon-plus fa fa-flag fa-2x']")
	WebElement AddSubject;

	@FindBy(xpath = "//*[@class='list list-group qualification-subjects-list OSFillParent']/div")
	public List<WebElement> drpdwn_subject;

	@FindBy(xpath = "//*[contains(@class,'icon-trash-')]")
	WebElement btn_delete;

	@FindBy(xpath = "//*[contains(text(),'Education and qualifications')]")
	WebElement link_EducationAndQualification;

	@FindBy(xpath = "//*[@type = 'button']")
	WebElement btn_Add;

	@FindBy(xpath = "//*[@id='DisabilityStatus']")
	WebElement drpdwn_disabilty;

	@FindBy(xpath = "//*[@id='DisabilityReasonDropdown']")
	WebElement txt_disabilityReason;

	@FindBy(xpath = "//*[@id='DisabilityReasonDropdown']/div[1]")
	WebElement disabilityReason;

	@FindBy(xpath = "//span[contains(text(),'Prefer Not to Answer')]")
	WebElement select_disabilityReason;

	@FindBy(xpath = "//*[@id='b4-Icon']")
	WebElement startDateCalender;

	@FindBy(xpath = "//*[@id='b6-Icon']")
	WebElement EndDateCalender;

	@FindBy(xpath = "//*[@class='flatpickr-prev-month']")
	public List<WebElement> prevArrow;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/span[24]")
	WebElement startDate;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/div/span[22]")
	WebElement EndDate;

	@FindBy(xpath = "//*[contains(text(),'Employment history')]")
	WebElement EmploymentHistory;

	@FindBy(xpath = "//*[contains(text(),'View employment details')]")
	WebElement viewEmploymentDetails;

	@FindBy(xpath = "//*[@id= 'JobTitle2']/div/span")
	WebElement jobTitle;

	@FindBy(xpath = "//*[@id= 'Position2']/div/span")
	WebElement position;

	@FindBy(xpath = "//*[@id= 'AssignmentNumber2']/div/span")
	WebElement AssignmentNo;

	@FindBy(xpath = "//*[@id= 'LineManager2']/div/span")
	WebElement LineManager;

	@FindBy(xpath = "//*[@id= 'Grade2']/div/span")
	WebElement Grade;

	@FindBy(xpath = "//*[@id= 'Department2']/div/span")
	WebElement Department;

	@FindBy(xpath = "//*[@id= 'Location2']/div/span")
	WebElement Location;

	@FindBy(xpath = "//*[@id= 'WorkHours2']/div/span")
	WebElement workinghours;

	@FindBy(xpath = "//*[@id= 'AssignmentStatus2']/div/span")
	WebElement AssignmentStatus;

	@FindBy(xpath = "//*[@id= 'AssignmentCategory2']/div/span")
	WebElement AssignmentCategory;

	@FindBy(xpath = "//*[@id= 'LatestHireDate2']/div/span")
	WebElement LatestHireDate;

	@FindBy(xpath = "//*[@id= 'BusinessGroup2']/div/span")
	WebElement BusinessGroup;

	@FindBy(xpath = "//*[@id= 'PeopleGroup2']/div/span")
	WebElement PeopleGroup;

	@FindBy(xpath = "//*[@id= 'Payroll2']/div/span")
	WebElement Payroll;

	@FindBy(xpath = "//*[@id= 'Frequency2']/div/span")
	WebElement Frequency;

	@FindBy(xpath = "//*[contains(text(),'Work locations')]")
	WebElement workLocations;

	@FindBy(xpath = "//*[@id= 'AddressLine1']")
	WebElement OffCampus_AddressLine1;

	@FindBy(xpath = "//*[@id= 'AddressLine2']")
	WebElement OffCampus_AddressLine2;

	@FindBy(xpath = "//*[contains(text(),'Bank details')]")
	WebElement Bankdetails;

	@FindBy(xpath = "//*[@id= 'Input_AccountHolderName']")
	WebElement txt_AccountHolderName;

	@FindBy(xpath = "//*[@id= 'Input_AccountNumber']")
	WebElement AccountNumber;

	@FindBy(xpath = "//*[contains(text(),'Skills')]")
	WebElement skills;

	@FindBy(xpath = "//*[@id= 'Input_CurrentSkill']")
	WebElement txt_skills;

	@FindBy(xpath = "//*[@id= 'AddSkillContainer2']/button")
	WebElement btn_addSkills;

	@FindBy(xpath = "//*[@id= 'Input_AccountNumber']")
	WebElement btn_deleteSkills;

	SoftAssert softAssert = new SoftAssert();
	DateUtils date = new DateUtils();

	public mydetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void my_details() throws InterruptedException {

		explicitWait(link_Gallery, "visibilityOf", 100);
		clickElement(link_MyDetails.get(0), "My Details link");
		//Wait for side menu to appear after clicking on my details block
		explicitWait(menu_mydetailsMenu, "visibilityOf", 30);
	}

	public void basic_details() {

		explicitWait(link_BasicDetails, "elementToBeClickable", 20);
		clickElement(link_BasicDetails, "Basic Details");
	}

	public void edit_details() {

		commonMethods.explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		commonMethods.clickElement(btn_EditDetails, "btn_EditDetails");
		commonMethods.explicitWait(btn_EditDetails, "visibilityOf", 20);
	}

	public void enterUserDetails() {

		if (!(txt_Title.isEnabled() && txt_Firstname.isEnabled() && txt_Lastname.isEnabled())) {
			cucumberLogs.info("Title/Firstname/Lastname is not getting Editable");

		} else {

			cucumberLogs.fail("Title/Firstname/Lastname is getting Editable");

		}

	}

	public void enterSubDetails() {

		if (!(txt_DOB.isEnabled() && txt_NI_Number.isEnabled() && txt_Nationality.isEnabled())) {
			cucumberLogs.info("DOB/Number/Nationality is not getting Editable");

		} else {

			cucumberLogs.fail("DOB/Number/Nationality is getting Editable");

		}

	}

	public void enterOptionalDetails() {

		explicitWait(btn_EditDetails, "visibilityOf", 20);
		clearText(txt_PreferredName);
		enterText(txt_PreferredName, "txt_PreferredName");
		explicitWait(txt_PreferredLastname, "visibilityOf", 20);
		clearText(txt_PreferredLastname);
		enterText(txt_PreferredLastname, "txt_PreferredLastname");
	}

	public void reviewChanges() {

		if (btn_reviewChanges.isEnabled()) {

			cucumberLogs.info("Review Changes is enabled as optional details are entered");
		} else {
			cucumberLogs.info("Review Changes is not enabled as optional details are not entered");
		}
	}

	public void cancelDetails() {

		moveToElement(btn_Cancel);
		clickElement(btn_Cancel, "btn_Cancel");
		if (btn_Discard.size() > 0) {
			explicitWait(btn_Discard.get(0), "elementToBeClickable", 20);
			clickElement(btn_Discard.get(0), "btn_Discard");
		}
		if (Delete.size() > 0) {
			explicitWait(Delete.get(2), "elementToBeClickable", 20);
			clickElement(Delete.get(2), "btn_Discard");
			clickElement(btn_Cancel, "btn_Cancel");
		}
	}

	public void cancel_Details() {

		moveToElement(btn_Cancel);
		clickElement(btn_Cancel, "btn_Cancel");
		explicitWait(btn_ContinueEditing, "elementToBeClickable", 20);
		clickElement(btn_ContinueEditing, "btn_Discard");
	}

	public void contact_details() {

		explicitWait(link_ContactDetails, "elementToBeClickable", 30);
		clickElement(link_ContactDetails, "link_ContactDetails");

	}

	public void enterOptionalContactDetails() {

		explicitWait(txt_personalmail, "elementToBeClickable", 20);
		clearText(txt_personalmail);
		enterText(txt_personalmail, "txt_personalmail");

	}

	public void enterAddress(String address1, String address2) {

		explicitWait(txt_address1, "elementToBeClickable", 20);
		clearText(txt_address1);
		enterText(txt_address1, address1);
		clearText(txt_address2);
		explicitWait(txt_address2, "elementToBeClickable", 20);
		enterText(txt_address2, address2);
	}

	public void addAlternativeAddress(String address3) throws InterruptedException {

		moveToElement(btn_alternativeAddress);
		clickElement1(btn_alternateAddress, "btn_alternateAddress");
		sleepWait(30);
		explicitWait(txt_altAddress3.get(1), "elementToBeClickable", 20);
		clearText(txt_altAddress3.get(1));
		enterText(txt_altAddress3.get(1), address3);

	}

	public void deleteAlternateAddress() {

		explicitWait(btn_deleteAltAddress, "elementToBeClickable", 40);
		clickElement(btn_deleteAltAddress, "btn_deleteAltAddress");
	}

	public void Emergency_details() {

		explicitWait(link_EmergencyDetails, "elementToBeClickable", 40);
		clickElement(link_EmergencyDetails, "link_EmergencyDetails");
	}

	public void Verify_Emergency_page() {

		if (EmergencyContacts.isDisplayed()) {
			cucumberLogs.info("Add Emergency Address details page displayed");
		}
	}

	public void addEmergencyContact() {

		explicitWait(btn_AddEmergencyAddress, "elementToBeClickable", 20);
		clickElement(btn_AddEmergencyAddress, "btn_AddEmergencyAddress");

	}


	public void clickEditEmergencydetails() {
		explicitWait(btn_EditEmergencyAddress, "elementToBeClickable", 30);
		clickElement(btn_EditEmergencyAddress, "Edit Emergency Contact");
	}

	public void editMandatoryField() throws InterruptedException {

		sleepWait(10);
		clearText(txt_Lastname);
		enterText(txt_Lastname, "Rome");
		sleepWait(10);
		selectDropdownByIndex(drpdwn_Relationship, 3);
		sleepWait(10);
		clearText(txt_address1);
		enterText(txt_address1, "Mumbai");
		sleepWait(10);
	}

	public void editOptionalField() throws InterruptedException {

		clearText(txt_Firstname);
		enterText(txt_Firstname, "Roy");
		sleepWait(10);
		selectDropdownByIndex(drpdwn_Country, 2);
		sleepWait(10);
		clearText(txt_Postcode);
		enterText(txt_Postcode, "5676123");
		sleepWait(10);
	}

	public boolean is_EmergencyContact_Landing_Displayed() {

		if (btn_AddEmergencyAddress.isDisplayed()) {
			cucumberLogs.info("Emergency Contact landing details page displayed");
			return true;
		}
		return false;
	}

	public void clickReviewAndVerify() throws InterruptedException {

		explicitWait(btn_EditEmergencyAddress, "elementToBeClickable", 10);
		clickElement(btn_EditEmergencyAddress, "btn_EditEmergencyAddress");

		String FN = getTextFromElement(txt_Firstname);
		String LN = getTextFromElement(txt_Lastname);
		String Relationship = getTextFromElement(drpdwn_Relationship);

		clearText(txt_Firstname);
		enterText(txt_Firstname, "Sam");
		sleepWait(10);
		clearText(txt_Lastname);
		enterText(txt_Lastname, "Jones");
		sleepWait(10);
		selectDropdownByIndex(drpdwn_Relationship, 6);
		sleepWait(20);

		// explicitWait(btn_reviewChanges, "elementToBeClickable", 15);
		clickElement1(btn_reviewChanges, "btn_reviewChanges");

		sleepWait(10);
		String FN1 = getTextFromElement(txt_Firstname);
		String LN1 = getTextFromElement(txt_Firstname);
		String Relationship1 = getTextFromElement(txt_Firstname);

		if (!FN.equalsIgnoreCase(FN1) && !LN.equalsIgnoreCase(LN1) && !Relationship.equalsIgnoreCase(Relationship1)) {
			cucumberLogs.info("Edited data gets updated successfully");
		} else {

			cucumberLogs.fail("Edited data is not getting updated");

		}

	}

	public void EDI() {
		explicitWait(link_EDI, "elementToBeClickable", 20);
		clickElement(link_EDI, "link_EDI");
	}

	public void Edit_EDI() {
		explicitWait(btn_EditDetails, "elementToBeClickable", 10);
		clickElement(btn_EditDetails, "btn_EditDetails");
	}

	public void Edit() throws InterruptedException {
		sleepWait(10);
		explicitWait(btn_Edit.get(0), "elementToBeClickable", 10);
		clickElement(btn_Edit.get(0), "btn_Edit");

	}

	public void Edit_EDI_details() throws InterruptedException {

		sleepWait(10);
		selectDropdown(drpdwn_Ethnicity, "selectByVisiblTtext", "Not known");
		sleepWait(10);
		selectDropdown(drpdwn_Religion, "selectByVisiblTtext", "Christian");
		sleepWait(10);
		selectDropdown(drpdwn_Sex, "selectByVisiblTtext", "Male");
		sleepWait(10);
		selectDropdown(drpdwn_gender, "selectByVisiblTtext", "No");
	}

	public void educationAndQualification() {
		explicitWait(link_EducationAndQualification, "elementToBeClickable", 10);
		clickElement(link_EducationAndQualification, "link_EducationAndQualification");
	}

	public void AddQualification() {
		explicitWait(btn_Add, "elementToBeClickable", 10);
		clickElement(btn_Add, "btn_Add");
	}

	public void enterQualificationdetails(DataTable table) throws InterruptedException {

		sleepWait(10);
		clickElement(drpdwn_QualificationType, "drpdwn_QualificationType_");
		enterText(txt_searchQualificationType.get(0), "Award");
		sleepWait(5);
		clickElement1(Select_searchQualificationType.get(0), "Select_searchQualificationType");

		clearText(txt_qualificationTitle);
		enterText(txt_qualificationTitle, table.cell(1, 1));
		sleepWait(5);

		clickElement(drpdwn_QualificationType, "drpdwn_QualificationType_");
		enterText(txt_searchQualificationType.get(0), "Award");
		clickElement1(Select_searchQualificationType.get(0), "Select_searchQualificationType");
		sleepWait(5);

		clearText(txt_Awarding);
		enterText(txt_Awarding, table.cell(2, 1));
		sleepWait(5);

		clickElement(drpdwn_QualificationLetters, "drpdwn_QualificationLetters");
		clickElement1(select_QualificationLetters.get(1), "select_QualificationLetters");
		sleepWait(5);

		try {
			clickElement(txt_Completiondate, "txt_Completiondate");
		} catch (ElementNotInteractableException e) {
			clickElement1(Completiondate, "Completiondate");
		}
		explicitWait(prevArrow.get(0), "elementToBeClickable", 5);
		clickElement(prevArrow.get(0), "prevArrow");
		clickElement(Date, "Date");
		sleepWait(5);
		clickElement(headClick, "headClick");
	}

	public void editQualificationDetails(DataTable table) throws InterruptedException {

		String QualificationType = getTextFromElement(getQualificationType);

		clearText(txt_qualificationTitle);
		enterText(txt_qualificationTitle, table.cell(1, 1));
		sleepWait(5);

		/*
		 * if (QualificationType.equalsIgnoreCase("Award")) {
		 * clickElement(drpdwn_QualificationType, "drpdwn_QualificationType_");
		 * enterText(txt_searchQualificationType.get(0), "Doctorate");
		 * clickElement1(Select_searchQualificationType.get(0),
		 * "Select_searchQualificationType"); sleepWait(5); }
		 */

		clearText(txt_Awarding);
		enterText(txt_Awarding, table.cell(2, 1));
		sleepWait(5);

		clickElement(drpdwn_QualificationLetters, "drpdwn_QualificationLetters");
		clickElement1(select_QualificationLetters.get(1), "select_QualificationLetters");
		sleepWait(5);
		/*
		 * try { clickElement(txt_Completiondate, "txt_Completiondate"); } catch
		 * (ElementNotInteractableException e) { clickElement1(Completiondate,
		 * "Completiondate"); } explicitWait(prevArrow.get(0), "elementToBeClickable",
		 * 5); clickElement(prevArrow.get(0), "prevArrow"); clickElement(Date, "Date");
		 * sleepWait(5);
		 */
		clickElement(headClick, "headClick");
	}

	public void AddSubject() throws InterruptedException {
		clickElement(AddSubject, "AddSubject");
		explicitWait(txt_searchSubject, "elementToBeClickable", 5);
		clickElement(txt_searchSubject, "txt_searchSubject");
		// explicitWait(Select_searchSubject, "elementToBeClickable", 5);
		clickElement(Select_searchSubject.get(2), "Select_searchSubject");
		sleepWait(10);
	}

	public void DeleteSubject() {

		clickElement(btn_delete, "btn_delete");

		if (drpdwn_subject.size() == 0) {
			cucumberLogs.info("subject gets deleted successfully");
		} else {
			cucumberLogs.fail("subject Not get deleted");
		}
	}

	public void DeleteQualification() {

		int qualificationSize = btn_Edit.size();
		explicitWait(btn_Edit.get(0), "elementToBeClickable", 5);
		clickElement(btn_Edit.get(0), "btn_Edit");
		clickElement(delete, "delete");
		clickElement(delete, "delete");
		int qualificationSizeAfterDelete = btn_Edit.size();

		if (qualificationSize > qualificationSizeAfterDelete) {
			cucumberLogs.info("Qualification gets deleted successfully");
		} else {
			cucumberLogs.fail("Qualification Not get deleted");
		}
	}

	public void Disability() {

		explicitWait(link_Disability, "elementToBeClickable", 10);
		clickElement(link_Disability, "link_Disability");
	}

	public void AddDisability() {
		explicitWait(btn_Add, "elementToBeClickable", 10);
		clickElement(btn_Add, "btn_Add");
	}

	public void selectDisabilityType(String disabilityType) throws InterruptedException {

		selectDropdown(drpdwn_disabilty, "selectByVisiblTtext", disabilityType);
		sleepWait(20);
	}

	public void VerifyDisabilityReason(String disabilityType) throws IOException {

		// String disabilityType = getTextFromElement(drpdwn_disabilty);
		if (disabilityType.equalsIgnoreCase("No") || disabilityType.equalsIgnoreCase("Prefer Not to Answer")) {
			String value = getValueFromElement(disabilityReason, "class");
			if (value.contains("disabled")) {
				cucumberLogs.pass("Disability Reason is not enabled ");
			} else {
				cucumberLogs.fail("Disability Reason is enabled ");
			}
		}

		if (disabilityType.equalsIgnoreCase("Yes")) {
			String value = getValueFromElement(disabilityReason, "class");
			if (value.contains("disabled")) {
				cucumberLogs.fail("Disability Reason is not enabled ");
			} else {
				cucumberLogs.info("Disability Reason is enabled ");
			}
		}
	}

	public void Disability_Reason() throws IOException {

		String value = getValueFromElement(disabilityReason, "class");
		if (!value.contains("disabled")) {
			clickElement(txt_disabilityReason, "txt_disabilityReason");
			explicitWait(txt_disabilityReason, "elementToBeClickable", 10);
			clickElement1(select_disabilityReason, "select_disabilityReason");
			clickElement1(select_disabilityReason, "select_disabilityReason");
		}
	}

	public void Disability_dates() {
		clickElement(startDateCalender, "startDateCalender");
		for (int i = 0; i < 6; i++) {
			clickElement(prevArrow.get(0), "prevArrow");
		}
		clickElement1(startDate, "startDate");

		clickElement(EndDateCalender, "EndDateCalender");
		for (int i = 0; i < 3; i++) {
			clickElement(prevArrow.get(1), "prevArrow");
		}
		clickElement1(EndDate, "EndDate");
	}

	public void employment_history() {
		explicitWait(EmploymentHistory, "elementToBeClickable", 10);
		clickElement1(EmploymentHistory, "EmploymentHistory");
	}

	public void view_employment_details() {
		explicitWait(viewEmploymentDetails, "elementToBeClickable", 10);
		clickElement1(viewEmploymentDetails, "viewEmploymentDetails");
	}

	public void Verify_employmentFields() {

		getTextFromElement(AssignmentNo, "AssignmentNo");
		getTextFromElement(LineManager, "LineManager");
		getTextFromElement(Location, "Location");
		getTextFromElement(AssignmentStatus, "AssignmentStatus");
		getTextFromElement(Grade, "Grade");
		getTextFromElement(Department, "Department");
		getTextFromElement(workinghours, "workinghours");
		getTextFromElement(jobTitle, "jobTitle");
		getTextFromElement(position, "position");
		getTextFromElement(AssignmentCategory, "AssignmentCategory");
		getTextFromElement(BusinessGroup, "BusinessGroup");
		getTextFromElement(PeopleGroup, "PeopleGroup");
		getTextFromElement(Payroll, "Payroll");
		getTextFromElement(Frequency, "Frequency");
		getTextFromElement(LatestHireDate, "LatestHireDate");
	}

	public void work_locations() {
		explicitWait(workLocations, "elementToBeClickable", 10);
		clickElement1(workLocations, "workLocations");
	}

	public void edit_work_locations() {

		clearText(OffCampus_AddressLine1);
		enterText(OffCampus_AddressLine2, "optional Address" + Integer.toString(((new Random().nextInt(10)) + 1)));
		clearText(OffCampus_AddressLine2);
		enterText(OffCampus_AddressLine2, "optional Address" + Integer.toString(((new Random().nextInt(10)) + 1)));
		// sleepWait(5);
	}

	public void Bank_details() {
		explicitWait(Bankdetails, "elementToBeClickable", 10);
		clickElement1(Bankdetails, "Bankdetails");
	}

	public void edit_Bank_details() {

		clearText(txt_AccountHolderName);
		enterText(txt_AccountHolderName, "ABC" + Integer.toString(((new Random().nextInt(10)) + 1)));
		clearText(AccountNumber);
		enterText(AccountNumber, "88882345" + Integer.toString(((new Random().nextInt(10)) + 1)));
		// sleepWait(5);
	}

	public void skills() {
		explicitWait(skills, "elementToBeClickable", 10);
		clickElement1(skills, "skills");
	}

	public void addSkills() {

		clickElement1(txt_skills, "txt_skills");
		enterText(txt_skills, "Java");
		clickElement1(btn_addSkills, "btn_addSkills");
		clickElement1(txt_skills, "txt_skills");
		enterText(txt_skills, "Python");
		clickElement1(btn_addSkills, "btn_addSkills");
		clickElement1(txt_skills, "txt_skills");
		enterText(txt_skills, "C#");
		clickElement1(btn_addSkills, "btn_addSkills");

	}

	public void deleteSkills() {

		clickElement1(btn_delete, "btn_delete");
	}
}
