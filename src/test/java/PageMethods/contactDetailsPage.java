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

import utilities.cucumberLogs;
import utilities.globalvariables;

public class contactDetailsPage extends commonMethods {


	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;

	@FindBy(xpath = "//form//div[contains(@id,'conPhoneItemEdit')][2]//input")
	WebElement txt_PrimaryHomeNumber;

	@FindBy(xpath = "//form//div[contains(@id,'conPhoneItemEdit')][3]//input")
	WebElement txt_PersonalMobile;

	@FindBy(xpath = "//*[@id = 'Input_PersonalEmailAddress_Edit']")
	WebElement txt_EmailAddress;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine1_Input')])[1]//input")
	WebElement txt_MainAddressAddressLine1;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine1_Input')])[2]//input")
	WebElement txt_AlternateAddressAddressLine1;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine2_Input')])[1]//input")
	WebElement txt_MainAddressAddressLine2;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine2_Input')])[2]//input")
	WebElement txt_AlternateAddressAddressLine2;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine3_Input')])[1]//input")
	WebElement txt_MainAddressAddressLine3;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine3_Input')])[2]//input")
	WebElement txt_AlternateAddressAddressLine3;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'TownCity_Input')])[1]//input")
	WebElement txt_MainAddressCity;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'TownCity_Input')])[2]//input")
	WebElement txt_AlternateAddressCity;

	@FindBy(xpath = "(//select[@class='dropdown-display dropdown'])[1]")
	WebElement drpdwn_MainAddressCounty;

	@FindBy(xpath = "(//select[@class='dropdown-display dropdown'])[2]")
	WebElement drpdwn_AlternateAddressCounty;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'Postcode_Input')])[1]//input")
	WebElement txt_MainAddressPostcode;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'Postcode_Input')])[2]//input")
	WebElement txt_AlternateAddressPostcode;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_ContactDetails;

	@FindBy(xpath = "//*[@id='conAddAltAddress_Edit']/a")
	WebElement lnk_addalternatedetails;

	@FindBy(xpath = "//*[@id='conDeleteAltAddress_Edit']/a")
	WebElement lnk_deletealternatedetails;

	@FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Discard')]")
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

	@FindBy(xpath = "//div[@id='PhoneList']")
	WebElement lbl_phonelist;

	@FindBy(xpath = "//div[@id='AddressList']/div[contains(@id,'conAddressItem')][1]")
	WebElement lbl_mainAddressDetails;

	@FindBy(xpath = "//div[@id='AddressList']/div[contains(@id,'conAddressItem')][2]")
	WebElement lbl_alternateAddressDetails;

  public String mainaddressLine1, mainaddressLine2,
							   mainaddressLine3, mainaddressCounty, mainaddressCity,
							   mainaddressPostcode, altaddressLine1, altaddressLine2,
							   altaddressLine3, altaddressCounty, altaddressCity, altaddressPostcode,
								 emailAddress,primaryHomeNumber, personalMobile;

	public contactDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void edit_details() {

		explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		clickElement(btn_EditDetails, "Edit Details button");
	}

	public boolean is_ContactDetails_Landing_Displayed() {
		if (explicitWait(btn_EditDetails,"elementToBeClickable", 30)) {
			cucumberLogs.info("Contact Details landing details page displayed");
			return true;
		}
		return false;
	}

  public boolean addAlternateAddress() {

		try {
			if ( lnk_addalternatedetails.isDisplayed() ){
				lnk_addalternatedetails.click();
			}
		}
		catch (Exception e) {
			return false ;
    }
		return true;
	}

	public boolean deleteAlternateAddress() {

		try {
			if ( lnk_deletealternatedetails.isDisplayed() ){
				scrolldownbrowser(lnk_deletealternatedetails);
				lnk_deletealternatedetails.click();
			}
		}
		catch (Exception e) {
			return false ;
		}
		return true;

	}

	public boolean is_ContactDetails_Displayed() {

		if (frm_ContactDetails.isDisplayed()) {
			cucumberLogs.info("Contact details page displayed");
			return true;
		}
		return false;
	}

	public void enterPrimaryHomeNumber(String number ) {

		clearText(txt_PrimaryHomeNumber);
		this.primaryHomeNumber = number ;
		enterText(txt_PrimaryHomeNumber, number);
	}

	public void enterPersonalMobile(String number ) {

		clearText(txt_PersonalMobile);
		this.personalMobile = number ;
		enterText(txt_PersonalMobile, number);
	}

	public void enterPersonalEmailAddress(String email ) {

		clearText(txt_EmailAddress);
		this.emailAddress = email ;
		enterText(txt_EmailAddress, email);
	}

	public void enterMainAddressLine1(String addressline ) {

		clearText(txt_MainAddressAddressLine1);
		this.mainaddressLine1 = addressline ;
		enterText(txt_MainAddressAddressLine1, addressline);
	}

	public void enterMainAddressLine2(String addressline ) {

		clearText(txt_MainAddressAddressLine2);
		this.mainaddressLine2 = addressline ;
		enterText(txt_MainAddressAddressLine2, addressline);
	}

	public void enterMainAddressLine3(String addressline ) {

		clearText(txt_MainAddressAddressLine3);
		this.mainaddressLine3 = addressline ;
		enterText(txt_MainAddressAddressLine3, addressline);
	}

	public void enterMainAddressCounty(String county ) {

		selectDropdown(drpdwn_MainAddressCounty, "selectByVisiblTtext",county);
		this.mainaddressCounty = county ;
	}

	public void enterMainAddressCity(String city ) {

		clearText(txt_MainAddressCity);
		this.mainaddressCity = city ;
		enterText(txt_MainAddressCity, city);
	}

	public void enterMainAddressPostcode(String postcode ) {

		clearText(txt_MainAddressPostcode);
		this.mainaddressPostcode = postcode ;
		enterText(txt_MainAddressPostcode, postcode);
	}

  public void enterAlternateAddressLine1(String addressline ) {

		clearText(txt_AlternateAddressAddressLine1);
		this.altaddressLine1 = addressline ;
		enterText(txt_AlternateAddressAddressLine1, addressline);
	}

	public void enterAlternateAddressLine2(String addressline ) {

		clearText(txt_AlternateAddressAddressLine2);
		this.altaddressLine2 = addressline ;
		enterText(txt_AlternateAddressAddressLine2, addressline);
	}

	public void enterAlternateAddressLine3(String addressline ) {

		clearText(txt_AlternateAddressAddressLine3);
		this.altaddressLine3 = addressline ;
		enterText(txt_AlternateAddressAddressLine3, addressline);
	}

	public void enterAlternateAddressCounty(String county ) {

		selectDropdown(drpdwn_AlternateAddressCounty, "selectByVisiblTtext",county);
		this.altaddressCounty = county ;
	}

	public void enterAlternateAddressCity(String city ) {

		clearText(txt_AlternateAddressCity);
		this.altaddressCity = city ;
		enterText(txt_AlternateAddressCity, city);
	}

	public void enterAlternateAddressPostcode(String postcode ) {

		clearText(txt_AlternateAddressPostcode);
		this.altaddressPostcode = postcode;
		System.out.println("alternate postocde "+ this.altaddressPostcode);
		enterText(txt_AlternateAddressPostcode, postcode);
	}

	public void updatePhoneEmailDetails(DataTable phonemailDetails ) {

		 int totalRows = phonemailDetails.height();
		 //Write the code to handle Data Table
		 for(int i=0;i<totalRows;i++){

				switch(phonemailDetails.cell(i,0).toLowerCase()){
					case "primary home number":
						enterPrimaryHomeNumber(phonemailDetails.cell(i,1) );
						break;
					case "personal mobile":
						enterPersonalMobile(phonemailDetails.cell(i,1) );
						break;
					case "personal email address":
						enterPersonalEmailAddress(phonemailDetails.cell(i,1) );
						break;
					default:
						break;
				}
			}
	}

	public void updateAlternateAdressDetails(DataTable addressDetails ) {

		 int totalRows = addressDetails.height();
		 //Write the code to handle Data Table
		 for(int i=0;i<totalRows;i++){

				switch(addressDetails.cell(i,0).toLowerCase()){
					case "address line1":
						enterAlternateAddressLine1(addressDetails.cell(i,1) );
						break;
					case "address line2":
						enterAlternateAddressLine2(addressDetails.cell(i,1) );
						break;
					case "address line3":
						enterAlternateAddressLine3(addressDetails.cell(i,1) );
						break;
					case "county":
						enterAlternateAddressCounty(addressDetails.cell(i,1) );
						break;
					case "postcode":
						enterAlternateAddressPostcode(addressDetails.cell(i,1) );
						break;
					case "city":
						enterAlternateAddressCity(addressDetails.cell(i,1) );
						break;
					default:
						 break;
				}
			}
	}

	public void updateMainAdressDetails(DataTable addressDetails ) {

     int totalRows = addressDetails.height();
     //Write the code to handle Data Table
     for(int i=0;i<totalRows;i++){

        switch(addressDetails.cell(i,0).toLowerCase()){
          case "address line1":
					  enterMainAddressLine1(addressDetails.cell(i,1) );
            break;
					case "address line2":
					  enterMainAddressLine2(addressDetails.cell(i,1) );
            break;
					case "address line3":
					  enterMainAddressLine3(addressDetails.cell(i,1) );
            break;
          case "county":
					  enterMainAddressCounty(addressDetails.cell(i,1) );
            break;
					case "postcode":
	          enterMainAddressPostcode(addressDetails.cell(i,1) );
						break;
					case "city":
            enterMainAddressCity(addressDetails.cell(i,1) );
            break;
          default:
             break;
        }
      }
  }

	public void cancelEditingContactDetails() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		moveToElement(btn_Cancel);
		clickElement(btn_Cancel, "Cancel button");
	}

	public void discardBankDetails() {

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
		return explicitWaitForTextInElement(lbl_mainAddressDetails,this.mainaddressCity,20);
	}
	public boolean isMainPostcodeUpdated() {
		return explicitWaitForTextInElement(lbl_mainAddressDetails,this.mainaddressPostcode,20);
	}
	public boolean isMainCountyUpdated() {
		return explicitWaitForTextInElement(lbl_mainAddressDetails,this.mainaddressCounty,20);
	}

	public boolean isaltCityUpdated() {
		return explicitWaitForTextInElement(lbl_alternateAddressDetails,this.altaddressCity,20);
	}
	public boolean isaltPostcodeUpdated() {
		return explicitWaitForTextInElement(lbl_alternateAddressDetails,this.altaddressPostcode,20);
	}
	public boolean isaltCountyUpdated() {
		return explicitWaitForTextInElement(lbl_alternateAddressDetails,this.altaddressCounty,20);
	}
	public boolean isPersonalMobileUpdated() {
		return explicitWaitForTextInElement(lbl_phonelist,this.personalMobile,20);
	}


}
