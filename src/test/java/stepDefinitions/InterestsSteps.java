package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import PageMethods.InterestsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.cucumberLogs;
import org.testng.asserts.SoftAssert;


public class InterestsSteps extends commonMethods {

	// remove below lines with parallel-test branch is merged.
	//mydetailsPage objbasicdetailsPage. = new mydetailsPage(commonMethods.driver);
	//homePageMethod objhomePageMethod = new homePageMethod(commonMethods.driver);

	InterestsPage objinterestsPage;
  SoftAssert softAssert;

	@Before
	public void setUp() {
		objinterestsPage = new InterestsPage(commonMethods.driver);
		softAssert = new SoftAssert();
	}

	@After
	public void tearDown(){

	}

	@Then("interests landing page is displayed")
	public void intrests_landing_page_is_displayed() {
		softAssert.assertEquals(objinterestsPage.is_InterestDetails_Landing_Displayed(),true,
																"Interest details page is not displayed");
	}

	@When("I choose to edit interests")
	public void i_choose_to_edit_interests_details() {
	  objinterestsPage.edit_details();
	}

	@Then("edit interests page is displayed")
	public void edit_interests_page_is_displayed() {
		softAssert.assertEquals(objinterestsPage.is_InterestDetails_Displayed(),true,
																"Interest details page is not displayed");
	}

	@When("I add my interest details")
	public void i_add_my_interest_details() {
		objinterestsPage.addInterests();
	}


}
