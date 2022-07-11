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

public class basicDetailsPage extends commonMethods {


	@FindBy(xpath = "//*[@class ='inside-ucl-large-tile__text OSFillParent']")
	public List<WebElement> link_MyDetails;

	@FindBy(xpath = "//div[@class ='osui-gallery']")
	WebElement link_Gallery;

	@FindBy(xpath = "//*[contains(text(),'Basic details')]")
	WebElement link_BasicDetails;

	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;

	@FindBy(xpath = "//*[contains(text(),'Edit')]")
	public List<WebElement> btn_Edit;

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

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_BasicDetails;

	SoftAssert softAssert = new SoftAssert();
	DateUtils date = new DateUtils();

	public basicDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void basic_details() {

			commonMethods.explicitWait(link_BasicDetails, "elementToBeClickable", 40);
			commonMethods.clickElement(link_BasicDetails, "Basic Details");
	}

	public void edit_details() {

		commonMethods.explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		commonMethods.clickElement(btn_EditDetails, "Edit Details button");
	}

	public boolean is_BasicDetails_Landing_Displayed() {

		if (btn_EditDetails.isDisplayed()) {
			cucumberLogs.info("Basic Contact landing details page displayed");
			return true;
		}
		return false;
	}

	public boolean is_BasicDetails_Displayed() {

		if (frm_BasicDetails.isDisplayed()) {
			cucumberLogs.info("Basic Contact details page displayed");
			return true;
		}
		return false;
	}

	public boolean enterUserDetails() {

		if (!(txt_Title.isEnabled() && txt_Firstname.isEnabled() && txt_Lastname.isEnabled())) {

			cucumberLogs.info("Title/Firstname/Lastname is not getting Editable");
			return true;
		} else {

			cucumberLogs.fail("Title/Firstname/Lastname is getting Editable");
			return false;

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
/*
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

	*/
}
