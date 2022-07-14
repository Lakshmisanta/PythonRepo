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

public class bankDetailsPage extends commonMethods {


	@FindBy(xpath = "//*[@class ='inside-ucl-large-tile__text OSFillParent']")
	public List<WebElement> link_MyDetails;

	@FindBy(xpath = "//div[@class ='osui-gallery']")
	WebElement link_Gallery;

	@FindBy(xpath = "//*[contains(text(),'Bank details')]")
	WebElement link_BankDetails;

	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;

	@FindBy(xpath = "//input[@id = 'Input_AccountHolderName']")
	WebElement txt_AccountHolderName;

	@FindBy(xpath = "//*[@id = 'Input_AccountNumber']")
	WebElement txt_AccountNumber;

	@FindBy(xpath = "//*[@id = 'Input_SortCode']")
	WebElement txt_SortCode;

	@FindBy(xpath = "//*[@id = 'Input_BankName']")
	WebElement txt_bankName;

	@FindBy(xpath = "//*[@id = 'Input_Branch']")
	WebElement txt_branch;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_BankDetails;

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

	@FindBy(xpath = "//div[@id='conAccountHolderName']")
	WebElement lbl_AccountHolderName;

	@FindBy(xpath = "//div[@id='conAccountNumber']")
	WebElement lbl_AccountNumber;

	@FindBy(xpath = "//div[@id='conSortCode']")
	WebElement lbl_SortCode;

  public String accountHolderName, accountNumber, sortNumber;

	public bankDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void edit_details() {

		commonMethods.explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		commonMethods.clickElement(btn_EditDetails, "Edit Details button");
	}

	public boolean is_BankDetails_Landing_Displayed() {
		if (explicitWait(btn_EditDetails,"elementToBeClickable", 30)) {
			cucumberLogs.info("Bank Details landing details page displayed");
			return true;
		}
		return false;
	}

	public boolean is_BankDetails_Displayed() {

		if (frm_BankDetails.isDisplayed()) {
			cucumberLogs.info("Bank details page displayed");
			return true;
		}
		return false;
	}

  public void enterAccountHolderName(String name ) {
		clearText(txt_AccountHolderName);
		this.accountHolderName = name ;
		enterText(txt_AccountHolderName, name);
	}

	public void enterAccountNumber(String accountNumber) {
		clearText(txt_AccountNumber);
		this.accountNumber = accountNumber ;
		enterText(txt_AccountNumber, accountNumber);
	}

  public void enterSortCode(String sortNumber) {
		clearText(txt_SortCode);
		this.sortNumber = sortNumber ;
		enterText(txt_SortCode, sortNumber);
	}

	public void updateBankDetails(DataTable bankDetails ) {

     int totalRows = bankDetails.height();
     //Write the code to handle Data Table
     for(int i=0;i<totalRows;i++){

        switch(bankDetails.cell(i,0).toLowerCase()){
          case "account holders name":
            enterAccountHolderName(bankDetails.cell(i,1) );
            break;
          case "account number":
            enterAccountNumber(bankDetails.cell(i,1) );
            break;
					case "sort code":
            enterSortCode(bankDetails.cell(i,1) );
            break;
          default:
             break;
        }
      }
  }

	public void cancelBankDetails() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		moveToElement(btn_Cancel);
		clickElement(btn_Cancel, "Cancel button");
	}

	public boolean isBankNameEnabled() {

		if ( txt_bankName.isEnabled() ) {
			cucumberLogs.info("Bank Name is not editable");
			return true;
		}
		else {
			cucumberLogs.fail("Bank Name is editable");
			return false;
		}
	}

	public boolean isBranchEnabled() {

		if ( txt_bankName.isEnabled() ) {
			cucumberLogs.info("Branch is not editable");
			return true;
		}
		else {
			cucumberLogs.fail("Branch is editable");
			return false;
		}
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

	public boolean isAccountHolderNameUpdated() {
		return explicitWaitForTextInElement(lbl_AccountHolderName,this.accountHolderName,20);
	}

	public boolean isAccountNumberUpdated() {
		return explicitWaitForTextInElement(lbl_AccountNumber,this.accountNumber,20);
	}

	public boolean isSortCodeUpdated() {
		return explicitWaitForTextInElement(lbl_SortCode,this.sortNumber,20);
	}

}
