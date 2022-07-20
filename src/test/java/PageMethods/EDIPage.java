package PageMethods;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.interactions.Actions;
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

public class EDIPage extends commonMethods {


	@FindBy(xpath = "//*[@class='btn OSFillParent'][@type = 'button']")
	WebElement btn_EditDetails;

	@FindBy(xpath = "//select[@id='Dropdown1']")
	WebElement drpdown_Ethnicity;

	@FindBy(xpath = "//select[@id='Religion2']")
	WebElement drpdown_Religion;

	@FindBy(xpath = "//select[@id='SexualOrientation2']")
	WebElement drpdown_SexualOrientation;

	@FindBy(xpath = "//select[@id='SexualOrientation2']")
	WebElement drpdown_Gender;

	@FindBy(xpath = "//select[@id='GenderSameAsBirth']")
	WebElement drpdown_GenderSameAsBirth;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Cancel')]")
  WebElement btn_Cancel;

	@FindBy(xpath = "//button[contains(text(),'Review changes')]")
	WebElement btn_reviewChanges;

	@FindBy(xpath = "//*[@id='b1-Form1']")
	WebElement frm_edi;

	@FindBy(xpath = "//input[@id='Input_GenderDescription']")
	WebElement	txt_GenderDescription;

	@FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Discard')]")
  WebElement lnk_discard;

  @FindBy(xpath = "//*[@id='b1-popupDiscardChanges']//a[contains(text(),'Continue editing')]")
  WebElement lnk_ContinueEditing;

	@FindBy(xpath = "//div[@id='popupDeleteItem']//a[contains(text(),'Delete')]")
	public WebElement lnk_Delete;

	SoftAssert softAssert = new SoftAssert();

	@FindBy(xpath = "//div[@class='popup-dialog popup-dialog']")
	public WebElement dlg_DiscardChanges;

	@FindBy(xpath = "//div[@class='popup-dialog popup-dialog'][@id='popupDeleteItem']")
	public WebElement dlg_Delete;

  @FindBy(xpath = "//div[@class='drop-overlay-bottom']//button[@class='btn btn-primary']")
	WebElement btn_SaveChanges;


	@FindBy(xpath ="//div[@class='list-item']")
	public List<WebElement> skillsList;

	@FindBy(xpath ="//div[@class='public-profile-content']//div[@class='list list-group OSFillParent']")
	public List<WebElement> finalSkillsList;

	String skill;

	public EDIPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void edit_details() {

		explicitWait(btn_EditDetails, "elementToBeClickable", 20);
		clickElement(btn_EditDetails, "Edit Details button");
	}

	public boolean is_EDIDetails_Landing_Displayed() {
		if (explicitWait(btn_EditDetails,"elementToBeClickable", 30)) {
			cucumberLogs.info("EDI landing details page displayed");
			return true;
		}
		return false;
	}

	public boolean is_EDIDetails_Displayed() {

		if (frm_edi.isDisplayed()) {
			cucumberLogs.info("Edit skill page displayed");
			return true;
		}
		return false;
	}


	public void setEthnicity(String ethnicity ) {

		selectDropdown(drpdown_Ethnicity, "selectByVisiblTtext",ethnicity);
		// this.ethnicity = ethnicity ;
	}

	public void setGender(String gender ) {

		selectDropdown(drpdown_Gender, "selectByVisiblTtext",gender);
		// this.gender = gender ;
	}

	public void setReligion(String religion ) {

		selectDropdown(drpdown_Religion, "selectByVisiblTtext",religion);
		// this.religion = religion ;
	}

	public void setSexualOrientation (String orientation ) {

		selectDropdown(drpdown_SexualOrientation, "selectByVisiblTtext",orientation);
		// this.SexualOrientation = orientation ;
	}

	public void setSexRegisteredatBirth (String genderatbirth ) {

		selectDropdown(drpdown_GenderSameAsBirth, "selectByVisiblTtext",genderatbirth);
		// this.genderatbirth = genderatbirth ;
	}

	public void setGenderDescription(String description) {
		clearText(txt_GenderDescription);
		// this.description = description;
		enterText(txt_GenderDescription, description);
	}


 public void updateEDIDetails(DataTable ediDetails ) {
	 int totalRows = ediDetails.height();
	 //Write the code to handle Data Table
	 for(int i=0; i < totalRows; i++){

			switch(ediDetails.cell(i,0).toLowerCase()){
				case "ethnicity":
					setEthnicity(ediDetails.cell(i,1) );
					break;
				case "religion":
					setReligion(ediDetails.cell(i,1) );
					break;
				case "sexual orientation":
					setSexualOrientation(ediDetails.cell(i,1) );
					break;
				case "sex":
					setGender(ediDetails.cell(i,1) );
					break;
				case "sex at birth":
					setReligion(ediDetails.cell(i,1) );
					break;
				case "gender description":
					setGenderDescription(ediDetails.cell(i,1) );
					break;
				default:
					break;
			}
		}

 }

	// public void addSkill() {
	// 	this.skill = new String(StringUtils.generateRandomChars("abcdefghijklmnopqrstuvxyz", 5));
 //
	// 	enterSkill(this.skill);
	// 	clickElement(btn_addSkill, "Add skill");
	// 	cucumberLogs.info(this.skill + " skill is added ");
	// 	System.out.println(this.skill + " skill is added ");
	// }

	public void cancelAddedEdiDetails() {
		explicitWait(btn_Cancel, "elementToBeClickable", 20);
		clickElement(btn_Cancel, "Cancel button");
		moveToElement(btn_Cancel);
	}

	public void discardAddedEdiDetails() {

		explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
		explicitWait(lnk_discard, "elementToBeClickable", 20);
		clickElement(lnk_discard, "Discard link");
	}

	// public WebElement searchSkill() {
	// 	int nosOfSkills = skillsList.size();
	// 	WebElement newSkill = null ;
	// 	for( int i = 0 ; i < nosOfSkills ; i++) {
	// 		try {
	// 				 cucumberLogs.info("Searching for recently added skill...");
 //
	// 				 if (explicitWaitForTextInElement(skillsList.get(i),this.skill,3) ){
	// 				 	newSkill = skillsList.get(i);
	// 				 	break;
	// 				}
	// 		}
	// 		catch(Exception e){
	// 			//do nothing but interate completely
	// 		}
	// 	}
	// 	return newSkill;
	// }
 //
	// public WebElement searchInFinalSkillsList() {
	// 	int nosOfSkills = finalSkillsList.size();
	// 	for( int i = 0 ; i < nosOfSkills ; i++) {
	// 		try {
 //
	// 			if (explicitWaitForTextInElement(finalSkillsList.get(i),this.skill,3) ){
	// 				 cucumberLogs.info("Found, latest skill added...");
	// 				 return finalSkillsList.get(i);
	// 			}
	// 		}
	// 		catch(Exception e){
	// 			//do nothing but interate completely
	// 		}
	// 	}
 //
	// 	 return null;
	// }
 //
 // public boolean deleteLatestSkill() {
	//  WebElement skill = searchSkill();
	//  if( skill != null ){
	// 	 WebElement	deleteIcon = skill.findElement(By.xpath(".//child::i"));
	// 	 scrolldownbrowser(skill);
	// 	 deleteIcon.click();
	// 	 return true;
	//  }
 //    return false;
 // }
 //
	//  public boolean isDeletedSkillDisplayed() {
	// 	 WebElement skill = searchSkill();
	// 	 if( skill == null ){
	// 		 return true;
	// 	 }
	// 	  return false;
	//  }
 //
	//  public boolean isAddedSkillDisplayed() {
	// 	 WebElement skill = searchInFinalSkillsList();
	// 	 if( skill != null ){
	// 		 return true;
	// 	 }
	// 	  return false;
	//  }
 //
	//  public void confirmDeleteSkill() {
	// 	 explicitWait(dlg_Delete, "visibilityOf", 120);
	// 	 explicitWait(lnk_Delete, "elementToBeClickable", 20);
	// 	 clickElement(lnk_Delete, "Delete link");
	//  }
 //
	// public void continueEditingSkills() {
 //
	// 	explicitWait(dlg_DiscardChanges, "visibilityOf", 120);
	// 	explicitWait(lnk_ContinueEditing, "elementToBeClickable", 20);
	// 	clickElement(lnk_ContinueEditing, "Continue editing link");
	// }
 //
 //  public void SaveChanges()  {
	// 	explicitWait(btn_SaveChanges, "elementToBeClickable", 10);
	// 	clickElement(btn_SaveChanges, "Save Changes button");
	// }


}
