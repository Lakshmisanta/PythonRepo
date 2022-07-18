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
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import utilities.DateUtils;
import utilities.StringUtils;
import utilities.PersonDetails;

import utilities.cucumberLogs;
import utilities.globalvariables;

public class InterestsPage extends commonMethods {


	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;
	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button'][contains(text(),'Add interest')]")
	WebElement btn_addInterest;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_InterestDetails;

	@FindBy(xpath = "//input[@id='Input_CurrentInterest2']")
	WebElement	txt_Interest;

	@FindBy(xpath = "//*[@id='popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement lnk_discard;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement lnk_ContinueEditing;

	SoftAssert softAssert = new SoftAssert();

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

	@FindBy(xpath = "//div[@id='b1-popupReviewChanges']//button[@class='btn OSFillParent']")
	public WebElement btn_cancelReviewChanges;

	String interests;

	public InterestsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void edit_details() {

		explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		clickElement(btn_EditDetails, "Edit Details button");
	}

	public boolean is_InterestDetails_Landing_Displayed() {
		if (explicitWait(btn_EditDetails,"elementToBeClickable", 30)) {
			cucumberLogs.info("Interests landing details page displayed");
			return true;
		}
		return false;
	}

	public boolean is_InterestDetails_Displayed() {

		if (frm_InterestDetails.isDisplayed()) {
			cucumberLogs.info("Edit Interests page displayed");
			return true;
		}
		return false;
	}

	public void enterInterests(String interest ) {
		clearText(txt_Interest);
		enterText(txt_Interest, interest);
	}

	public void addInterests() {
		this.interests = new String(StringUtils.generateRandomChars("abcdefghijklmnopqrstuvxyz", 5));
		enterInterests(this.interests);
		clickElement(btn_addInterest, "Add interest");
	}

	public void cancelAddingInterest() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		clickElement(btn_Cancel, "Cancel button");
		moveToElement(btn_Cancel);
	}

	public void discardInterests() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(lnk_discard, "elementToBeClickable", 20);
		clickElement(lnk_discard, "Discard link");
	}

	public void continueEditingContactDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(lnk_ContinueEditing, "elementToBeClickable", 20);
		clickElement(lnk_ContinueEditing, "Continue editing link");
	}

	public void clickReviewChanges() {

		explicitWait(btn_reviewChanges, "elementToBeClickable", 10);
		scrolldownbrowser(btn_reviewChanges);
		clickElement(btn_reviewChanges, "Review Changes button");
	}

	public void cancelReviewChanges() {
		explicitWait(btn_cancelReviewChanges, "elementToBeClickable", 10);
		scrolldownbrowser(btn_cancelReviewChanges);
		clickElement(btn_cancelReviewChanges, "Cancel on Review Changes dialogue");
	}

  public void SaveReviewChanges()  {
		explicitWait(btn_SaveChanges, "elementToBeClickable", 10);
		clickElement(btn_SaveChanges, "Save Changes button");
	}


	public boolean isMainCityUpdated() {
		return true;
		//return explicitWaitForTextInElement(lbl_mainAddressDetails,this.mainaddressCity,20);
	}


}
