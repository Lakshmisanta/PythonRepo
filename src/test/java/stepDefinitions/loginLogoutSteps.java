package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageMethods.commonMethods;
import PageMethods.loginLogoutPage;
//import PageMethods.commonMethods;
//import PageMethods.loginLogoutPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;



public class loginLogoutSteps {



	@Given("^I should navigate to Inside UCL app (.*)$")
	public void i_should_navigate_to_inside_ucl_app_url(String URL) throws InterruptedException {

		commonMethods.navigateto_URL(URL);
	}

	@Given("I should see login page")
	public void i_should_see_login_page() throws IOException, InterruptedException {
		System.out.println("Inside loggin page");
		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.loginpage();
	}

	@When("I enter Username and Password")
	public void i_enter_username_and_password() throws InterruptedException {
		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.enterUsernameAndPassword();
	}

	@When("^I enter (.*) and (.*)$")
	public void i_enter_username_and_password(String Username, String Password) throws InterruptedException {
		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.enterUsernameAndPassword(Username, Password);
	}

	@And("I Click on Login button")
	public void i_click_on_login_button() throws InterruptedException {

		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.clickOnLoginBtn();

	}

	@Then("I should see application home page")
	public void i_should_see_application_home_page() throws IOException {

		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.homepage();
	}



	@When("I click on popup menu")
	public void i_click_on_popup_menu() throws InterruptedException {
		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.clickOnPopupMenu();
	}

	@And("I Click on Logout button")
	public void i_click_on_logout_button() throws InterruptedException {

		loginLogoutPage objloginLogoutPage = new loginLogoutPage(commonMethods.driver);
		objloginLogoutPage.clickOnLogoutBtn();

	}

	@Then("I should see Welcome to Inside UCL")
	public void i_should_see_welcome_to_inside_ucl() throws IOException {

		System.out.println("Welcome to Inside UCL");
	}

	@Given("Starting TestCase {string}")
	public void starting_test_case(String TestCase_Name) {
		cucumberLogs.initLogger();
		cucumberLogs.startTestCase("Start : Login Inside UCL with valid credentials");
	}

	@Then("Ending Test case")
	public void ending_test_case() {
		cucumberLogs.endTestCase("End : Login Inside UCL with valid credentials");
	}


}
