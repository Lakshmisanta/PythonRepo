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
import utilities.StringUtils;

import utilities.cucumberLogs;
import utilities.globalvariables;

public class contactDetailsPage extends commonMethods {


	@FindBy(xpath = "//*[@class ='inside-ucl-large-tile__text OSFillParent']")
	public List<WebElement> link_MyDetails;

	@FindBy(xpath = "//div[@class ='osui-gallery']")
	WebElement link_Gallery;

	@FindBy(xpath = "//*[contains(text(),'Bank details')]")
	WebElement link_BankDetails;

	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;

	@FindBy(xpath = "//form//div[contains(@id,'conPhoneItemEdit')][2]//input")
	WebElement txt_PrimaryHomeNumber;

	@FindBy(xpath = "//form//div[contains(@id,'conPhoneItemEdit')][3]//input")
	WebElement txt_PersonalMobile;

	@FindBy(xpath = "//*[@id = 'Input_PersonalEmailAddress_Edit']")
	WebElement txt_EmailAddress;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine1_Input')])[1]")
	WebElement txt_MainAddressAddressLine1;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine1_Input')])[2]")
	WebElement txt_AlternateAddressAddressLine1;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine2_Input')])[1]")
	WebElement txt_MainAddressAddressLine2;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine2_Input')])[2]")
	WebElement txt_AlternateAddressAddressLine2;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine3_Input')])[1]")
	WebElement txt_MainAddressAddressLine3;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'AddressLine3_Input')])[2]")
	WebElement txt_AlternateAddressAddressLine3;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'TownCity_Input')])[1]")
	WebElement txt_MainAddressCity;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'TownCity_Input')])[2]")
	WebElement txt_AlternateAddressCity;

	@FindBy(xpath = "(//select[@class='dropdown-display dropdown'])[1]")
	WebElement drpdwn_MainAddressCounty;

	@FindBy(xpath = "(//select[@class='dropdown-display dropdown'])[2]")
	WebElement drpdwn_AlternateAddressCounty;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'Postcode_Input')])[1]")
	WebElement txt_MainAddressPostcode;

	@FindBy(xpath = "(//form//descendant::div[contains(@id,'Postcode_Input')])[2]")
	WebElement txt_AlternateAddressPostcode;

	@FindBy(xpath = "//*[@id = 'Input_Branch']")
	WebElement txt_branch;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_ContactDetails;

	@FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement lnk_discard;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement lnk_ContinueEditing;

	SoftAssert softAssert = new SoftAssert();
	DateUtils date = new DateUtils();

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

  public String mainaddressLine1, mainaddressLine2,
							   mainaddressLine3, mainaddressCounty, mainaddressCity,
							   mainaddressPostcode, altaddressLine1, altaddressLine2,
							   altaddressLine3, altaddresCounty, altaddressCity, altaddressPostcode;

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

	public boolean is_ContactDetails_Displayed() {

		if (frm_ContactDetails.isDisplayed()) {
			cucumberLogs.info("Contact details page displayed");
			return true;
		}
		return false;
	}

	public void enterMainAddressLine1(String addressline ) {

		clearText(txt_MainAddressAddressLine1);
		this.mainaddressLine1 = addressline ;
		enterText(txt_MainAddressAddressLine1, addressline);
	}

	public void enterMainAddressLine2(String addressline ) {

		clearText(txt_MainAddressAddressLine1);
		this.mainaddressLine2 = addressline ;
		enterText(txt_MainAddressAddressLine1, addressline);
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
		enterText(txt_AlternateAddressAddressLine2, city);
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
		this.altaddresCounty = county ;
	}

	public void enterAlternateAddressCity(String city ) {

		clearText(txt_AlternateAddressAddressLine2);
		this.altaddressCity = city ;
		enterText(txt_AlternateAddressAddressLine2, city);
	}

	public void enterAlternateAddressPostcode(String postcode ) {

		clearText(txt_AlternateAddressPostcode);
		this.altaddressPostcode = postcode;
		enterText(txt_AlternateAddressPostcode, postcode);
	}

	public void updateAlternateAdressDetails(DataTable addressDetails ) {

		 int totalRows = addressDetails.height();
		 //Write the code to handle Data Table
		 for(int i=0;i<totalRows;i++){

				switch(addressDetails.cell(i,0).toLowerCase()){
					case "Address Line1":
						enterAlternateAddressLine1(addressDetails.cell(i,1) );
						break;
					case "Address Line2":
						enterAlternateAddressLine2(addressDetails.cell(i,1) );
						break;
					case "Address Line3":
						enterAlternateAddressLine3(addressDetails.cell(i,1) );
						break;
					case "county":
						enterAlternateAddressCounty(addressDetails.cell(i,1) );
						break;
					case "postcocde":
						enterAlternateAddressPostcode(addressDetails.cell(i,1) );
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
          case "Address Line1":
					  enterMainAddressLine1(addressDetails.cell(i,1) );
            break;
					case "Address Line2":
					  enterMainAddressLine2(addressDetails.cell(i,1) );
            break;
					case "Address Line3":
					  enterMainAddressLine3(addressDetails.cell(i,1) );
            break;
          case "county":
					  enterMainAddressCounty(addressDetails.cell(i,1) );
            break;
					case "postcocde":
	          enterMainAddressPostcode(addressDetails.cell(i,1) );
					case "city":
            enterMainAddressCity(addressDetails.cell(i,1) );
            break;
          default:
             break;
        }
      }
  }

	public void cancelContactDetails() {
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


}
