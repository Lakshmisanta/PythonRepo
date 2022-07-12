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
	WebElement txt_FirstName;

	@FindBy(xpath = "//*[@id = 'Input_LastName_Edit']")
	WebElement txt_LastName;

	@FindBy(xpath = "//*[@id = 'Input_DateOfBirth_Edit']")
	WebElement txt_DOB;

	@FindBy(xpath = "//*[@id = 'Input_NINumber_Edit']")
	WebElement txt_NI_Number;

	@FindBy(xpath = "//*[@id = 'Input_Nationality_Edit']")
	WebElement txt_Nationality;

	@FindBy(xpath = "//*[@id = 'Input_FirstNamePreferred_Edit']")
	WebElement txt_PreferredFirstName;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id = 'Input_LastNamePreferred_Edit']")
	WebElement txt_PreferredLastName;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_BasicDetails;

	@FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement btn_discard;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement btn_ContinueEditing;

	SoftAssert softAssert = new SoftAssert();
	DateUtils date = new DateUtils();

  @FindBy(xpath = "//div[@class='portal-class']")
  public WebElement dlg_ContactAdded;

	@FindBy(xpath = "//div[@class='popup-dialog popup-dialog']")
	public WebElement dlg_DiscardChanges;

	@FindBy(xpath = "//div[@id='b1-popupReviewChanges']")
	public WebElement dlg_ReviewChanges;

	@FindBy(xpath = "//div[@class='popup-dialog popup-dialog']")
	public WebElement dlg_SavingChanges;

  @FindBy(xpath = "//button[contains(text(),'Review changes')]")
	WebElement btn_reviewChanges;

  @FindBy(xpath = "//div[@id='b1-popupReviewChanges']//button[@class='btn btn-primary OSFillParent']")
	WebElement btn_SaveChanges;

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

		if (explicitWait(btn_EditDetails,"elementToBeClickable", 30)) {
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

	public void enterPreferredLastName(String name){
		clearText(txt_PreferredLastName);
		enterText(txt_PreferredLastName, name);
	}

	public void enterPreferredFirstName(String name){
		clearText(txt_PreferredFirstName);
		enterText(txt_PreferredFirstName, name);
	}

	public boolean enterSubDetails() {

		if (!(txt_DOB.isEnabled() && txt_NI_Number.isEnabled() && txt_Nationality.isEnabled())) {
			cucumberLogs.info("DOB/Number/Nationality is not getting Editable");
			return true;
		}
		else {
			cucumberLogs.fail("DOB/Number/Nationality is getting Editable");
			return false;
		}
	}

	public boolean enterUserDetails() {

		if (!(txt_Title.isEnabled() && txt_FirstName.isEnabled() && txt_LastName.isEnabled())) {

			cucumberLogs.info("Title/Firstname/Lastname is not getting Editable");
			return true;
		}
		else {
			cucumberLogs.fail("Title/Firstname/Lastname is getting Editable");
			return false;
		}
	}

	public String getTextBoxValue(String elementName){

		String value = new String("");
		switch(elementName.toLowerCase()){
       case "preferred first name":
			   value = txt_PreferredFirstName.getAttribute("value");
			   break;
			 case "preferred last name":
			   value = txt_PreferredLastName.getAttribute("value");
			   break;
		}
		return value;
	}

	public boolean isReviewChangesEnabled() {

		if (btn_reviewChanges.isEnabled()) {
			cucumberLogs.info("Review Changes is enabled as optional details are entered");
			return true;
		}
		else {
			cucumberLogs.info("Review Changes is not enabled as optional details are not entered");
			return false;
		}
	}

	public void updateBasicContactDetails(DataTable contactDetails ) {

     int totalRows = contactDetails.height();
     //Write the code to handle Data Table
     for(int i=0;i<totalRows;i++){

        switch(contactDetails.cell(i,0).toLowerCase()){
          case "preferred first name":
            enterPreferredFirstName(contactDetails.cell(i,1));
            break;
          case "preferred last name":
            enterPreferredLastName(contactDetails.cell(i,1));
            break;
          default:
             break;
        }
      }
  }

	public void cancelBasicContactDetails() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		moveToElement(btn_Cancel);
		clickElement(btn_Cancel, "Cancel button");
	}

	public void DiscardContactDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(btn_discard, "elementToBeClickable", 20);
		clickElement(btn_discard, "Discard link");
	}

	public void continueEditingContactDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(btn_ContinueEditing, "elementToBeClickable", 20);
		clickElement(btn_ContinueEditing, "Continue editing link");
	}

	public void clickReviewChanges() {

		scrolldownbrowser(btn_reviewChanges);
		explicitWait(btn_reviewChanges, "elementToBeClickable", 10);
		clickElement(btn_reviewChanges, "Review Changes button");
	}

  public void SaveReviewChanges()  {

		explicitWait(btn_SaveChanges, "elementToBeClickable", 10);
		clickElement(btn_SaveChanges, "Save Changes button");
	}

}
