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

public class emergencyContactDetailsPage extends commonMethods {

  @FindBy(xpath = "//form[@id='b1-Form1']//button[@class='btn']")
  WebElement btn_Cancel;

  @FindBy(xpath = "//div[@class='popup-dialog popup-dialog']")
  public WebElement dlg_DiscardChanges;

  @FindBy(xpath = "//div[@id='b1-popupReviewChanges']")
  public WebElement dlg_ReviewChanges;

  @FindBy(xpath = "//div[@class='popup-dialog popup-dialog']")
  public WebElement dlg_SavingChanges;

  @FindBy(xpath = "//div[@class='portal-class']")
  public WebElement dlg_ContactAdded;

  @FindBy(xpath = "//div[@id='b1-popupReviewChanges']//button[@class='btn OSFillParent']")
  public WebElement btn_CancelReviewChanges;

  @FindBy(xpath = "//div[@id='b1-popupReviewChanges']//button[@class='btn btn-primary OSFillParent']")
  public WebElement btn_SaveReviewChanges;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement btn_discard;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement btn_ContinueEditing;

  @FindBy(xpath = "//*[@id='Input_PrimaryPhoneNumber_Edit']")
  WebElement txt_primaryHomeNumber ;

  @FindBy(xpath = "//*[@id='Input_SecondaryPhoneNumber_Edit']")
	WebElement txt_personalMobile;

	@FindBy(xpath = "//*[@id='Input_WorkPhoneNumber_Edit']")
	WebElement txt_workNumber;

  @FindBy(xpath = "//input[contains(@id,'Input_MainAddressLine1_Edit')]")
  	WebElement txt_Emergency_address1;

	@FindBy(xpath = "//input[contains(@id,'Input_MainAddressLine2_Edit')]")
	WebElement txt_Emergency_address2;

	@FindBy(xpath = "//input[contains(@id,'Input_MainAddressLine3_Edit')]")
	WebElement txt_Emergency_address3;

  @FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_AddEmergencyContact;

  @FindBy(xpath = "//*[@id='Input_MainCity_Edit']")
	WebElement txt_City;

  @FindBy(xpath = "//*[@id='Input_LastName_Edit']")
	WebElement txt_EmergencyLastname;

	@FindBy(xpath = "//*[@id='Dropdown_Relationship']")
	WebElement drpdwn_Relationship;

	@FindBy(xpath = "//*[@id='Dropdown_MainCounty_Edit']")
	WebElement drpdwn_County;

	@FindBy(xpath = "//*[@id='Input_MainPostCode_Edit']")
	WebElement txt_Postcode;

	@FindBy(xpath = "//*[@id='Dropdown_Title']")
	WebElement drpdwn_Title;

  @FindBy(xpath = "//*[@id='Input_FirstName_Edit']")
	WebElement txt_EmergencyFirstname;

	@FindBy(xpath = "//*[@id='Input_EmailAddress_Edit']")
	WebElement txt_Email;

  @FindBy(xpath = "//button[contains(text(),'Review changes')]")
	WebElement btn_reviewChanges;


  @FindBy(xpath = "//*[@type = 'button']/div")
	WebElement btn_SaveChanges;

  public emergencyContactDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

  public void cancelContactDetails() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		moveToElement(btn_Cancel);
		clickElement(btn_Cancel, "Cancel");
	}

  public void DiscardContactDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(btn_discard, "elementToBeClickable", 20);
		clickElement(btn_discard, "Discard");
	}

  public void continueEditingContactDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(btn_ContinueEditing, "elementToBeClickable", 20);
		clickElement(btn_ContinueEditing, "Continue editing");
	}

  //verify on pop up contact is added
  public void isEmergencyContactAdded(){
		explicitWait(dlg_ContactAdded, "visibilityOf", 30);
		explicitWaitForTextInElement(dlg_ContactAdded,"Changes applied",10);
	}

  public void cancelReviewChanges() {
		explicitWait(dlg_ReviewChanges, "visibilityOf", 20);
		clickElement(btn_CancelReviewChanges, "Cancel button on Review Changes");
	}

	public void SaveReviewChanges() {
		explicitWait(dlg_ReviewChanges, "visibilityOf", 20);
		clickElement(btn_SaveReviewChanges, "Save changes button on Review Changes");
	}


  public boolean is_Add_EmergencyContact_Displayed() {

    if (frm_AddEmergencyContact.isDisplayed()) {
      cucumberLogs.info("Add Emergency Contact details page displayed");
      return true;
    }
    return false;
  }

  public void enterMandatorydata(DataTable Mtable) throws InterruptedException {

    enterText(txt_EmergencyLastname, Mtable.cell(2, 1));
    sleepWait(1);
    selectDropdown(drpdwn_Relationship, "selectByVisiblTtext", Mtable.cell(1, 1));
    sleepWait(1);
    scrolldownbrowser(txt_Emergency_address2);
    clearText(txt_Emergency_address1);
    enterText(txt_Emergency_address1, Mtable.cell(3, 1));
    sleepWait(2);

    clearText(txt_Emergency_address2);
    enterText(txt_Emergency_address2, Mtable.cell(4, 1));
  }

  public void enterOptionaldata(DataTable table) throws InterruptedException {

		selectDropdown(drpdwn_Title, "selectByVisiblTtext", table.cell(1, 1));
		enterText(txt_EmergencyFirstname, table.cell(2, 1));
		sleepWait(1);
		enterText(txt_Email, table.cell(3, 1));
		sleepWait(1);
		enterText(txt_primaryHomeNumber, table.cell(4, 1));
		sleepWait(1);
		enterText(txt_personalMobile, table.cell(5, 1));
		enterText(txt_workNumber, table.cell(6, 1));
		enterText(txt_Emergency_address3, table.cell(7, 1));
		enterText(txt_City, table.cell(8, 1));
		sleepWait(1);
		selectDropdown(drpdwn_County, "selectByVisiblTtext",table.cell(9, 1));
		enterText(txt_Postcode, table.cell(10, 1));

	}

  public void clickReviewChanges() {

		scrolldownbrowser(btn_reviewChanges);
		explicitWait(btn_reviewChanges, "elementToBeClickable", 10);
		clickElement(btn_reviewChanges, "Review changes");
	}

  public void clickSaveChanges() throws InterruptedException {

		explicitWait(btn_SaveChanges, "elementToBeClickable", 10);
		clickElement(btn_SaveChanges, "btn_SaveChanges");
		sleepWait(15);
	}





}
