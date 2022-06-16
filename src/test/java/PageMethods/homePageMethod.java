package PageMethods;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.DateUtils;
import utilities.globalvariables;

public class homePageMethod extends commonMethods {

	@FindBy(xpath = "//input[@type='email']")
	WebElement txt_Username;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_Next;
	
	@FindBy(xpath = "//input[@id='idSIButton9']")
	WebElement btn_yes;

	@FindBy(name = "passwd")
	WebElement txt_Password;

	@FindBy(xpath = "//*[@class ='inside-ucl-large-tile__text OSFillParent']")
	public List<WebElement> link_MyDetails;

	@FindBy(xpath = "//*[@class ='InsideUCL--Title']")
	WebElement PageTitle;

	@FindBy(xpath = "//*[@class ='popover-top']")
	WebElement btn_Menu;
	
	@FindBy(xpath = "//*[contains(text(),'Home')]")
	WebElement btn_Home;

	SoftAssert softAssert = new SoftAssert();
	DateUtils date = new DateUtils();

	public homePageMethod(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void loginToApp() throws InterruptedException {

		//System.out.println(date.getCurrentMonthPlus(2));
		//System.out.println(date.getCurrentDay());
		//System.out.println(date.getCurrentMonth());
		//System.out.println(date.getCurrentDayPlus(2));
		//System.out.println(date.getCurrentMonthPlus(2));
		
		explicitWait(txt_Username, "visibilityOf", 40);
		enterText(txt_Username, globalvariables.Username);
		explicitWait(btn_Next, "elementToBeClickable", 40);
		clickElement(btn_Next, "btn_Next");
		waitTillVisiblity(txt_Password, "txt_Password");
		enterText(txt_Password, globalvariables.Password);
		clickElement(btn_Next, "btn_Next");
		explicitWait(btn_yes, "elementToBeClickable", 20);
		clickElement(btn_yes, "btn_yes");
		sleepWait(30);
		

	}

	public void my_details() throws InterruptedException {

		sleepWait(15);
		explicitWait(link_MyDetails.get(0), "elementToBeClickable", 30);
		clickElement(link_MyDetails.get(0), "link_MyDetails");
	}

	public void my_details_Page() throws InterruptedException {

		sleepWait(10);
		softAssert.assertEquals("My details | Inside UCL", getPageTittle());
		clickElement(btn_Home, "btn_Home");

	}

	public void my_time_Off() {

		commonMethods.explicitWait(link_MyDetails.get(1), "visibilityOf", 20);
		commonMethods.clickElement(link_MyDetails.get(1), "link_MyTimeOff");
	}

	public void my_time_Off_Page() throws InterruptedException {

		commonMethods.sleepWait(10);
		softAssert.assertEquals("My time off | Inside UCL", getPageTittle());
	}

}