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
	WebElement txt_SortNumber;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_BankDetails;

	@FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement btn_discard;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement btn_ContinueEditing;

	SoftAssert softAssert = new SoftAssert();
	DateUtils date = new DateUtils();

  @FindBy(xpath = "//div[@class='portal-class']")
  public WebElement dlg_basicDetailsAdded;

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

	@FindBy(xpath = "//div[@id='conPreferredLastName']")
	WebElement lbl_PreferredLastName;

	@FindBy(xpath = "//div[@id='conPreferredFirstName']")
	WebElement lbl_PreferredFirstName;

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
  public void enterSortNumber(String sortNumber) {
		clearText(txt_SortNumber);
		this.sortNumber = sortNumber ;
		enterText(txt_SortNumber, sortNumber);
	}

	public void updateBasicContactDetails(DataTable bankDetails ) {

     int totalRows = bankDetails.height();
     //Write the code to handle Data Table
     for(int i=0;i<totalRows;i++){

        switch(bankDetails.cell(i,0).toLowerCase()){
          case "account holder's name":
            enterAccountHolderName(bankDetails.cell(i,1) );
            break;
          case "account number":
            enterAccountNumber(bankDetails.cell(i,1) );
            break;
					case "sort number":
            enterSortNumber(bankDetails.cell(i,1) );
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

}
