package PageMethods;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.cucumberLogs;

public class loginLogoutPage extends commonMethods {

	@FindBy(xpath = "//input[@type='email']")
	WebElement txt_Username;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_Next;

	@FindBy(name = "passwd")
	WebElement txt_Password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_login;

	@FindBy(xpath = "//*[contains(text(),'Log out')]")
	WebElement btn_logout;

	@FindBy(xpath = "//*[@class ='popover-top']")
	WebElement btn_Menu;

	@FindBy(xpath = "//*[contains(text(),'Welcome to Inside UCLp']")
	WebElement txt_WelcomePage;

	//commonMethods objCommonMethods = new commonMethods(driver);
	SoftAssert softAssert = new SoftAssert();

	public loginLogoutPage(WebDriver driver) {

		//super(driver);
		PageFactory.initElements(driver, this);

	}

	public void loginpage() throws InterruptedException {

		commonMethods.sleepWait(8);
		String ActualValue = commonMethods.getPageTittle();
		String ExpectedValue = "Sign in to your account";
		// compareValues(ActualValue, ExpectedValue, "LoginPage");
		cucumberLogs.info("Successfully On LoginPage");
	}

	public void enterUsernameAndPassword(String Username, String Password) throws InterruptedException {

		commonMethods.sleepWait(2);
		commonMethods.enterText(txt_Username, Username);
		commonMethods.waitTillVisiblity(btn_Next, "btn_Next");
		commonMethods.clickElement(btn_Next, "btn_Next");
		commonMethods.waitTillVisiblity(txt_Password, "txt_Password");
		commonMethods.enterText(txt_Password, Password);
		commonMethods.sleepWait(2);
		commonMethods.clickElement(btn_login, "btn_Next");
		commonMethods.sleepWait(2);

	}

	public void clickOnLoginBtn() throws InterruptedException {

		commonMethods.waitTillVisiblity(btn_Next, "btn_Next");
		commonMethods.clickElement(btn_login, "btn_login");
		commonMethods.sleepWait(30);
	}

	public void homepage() throws IOException {

		commonMethods.explicitWait(btn_Menu, "visibilityOf", 60);
		String ActualValue = commonMethods.getPageTittle();
		String ExpectedValue = "Home | Inside UCL";
		// compareValues(ActualValue, ExpectedValue, "HomePage");
		softAssert.assertEquals(ActualValue, ExpectedValue);
		softAssert.assertAll();
	}

	

	public void clickOnLogoutBtn() throws InterruptedException {

		commonMethods.clickElement(btn_logout, "btn_logout");
		commonMethods.sleepWait(6);
	}

	public void clickOnPopupMenu() throws InterruptedException {

		commonMethods.waitTillVisiblity(btn_Menu, "btn_Menu");
		commonMethods.clickElement(btn_Menu, "btn_Menu");
		commonMethods.sleepWait(6);
	}

}
