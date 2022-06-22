package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import PageMethods.commonMethods;
import io.cucumber.java.*;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import PageMethods.commonMethods;
import org.testng.annotations.*;


@CucumberOptions(tags = "", features = "src/test/resources/Features",
glue = { "stepDefinitions" },
plugin = {
		"json:target/cucumber.json", "html:target/HtmlReports.html" },
monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

	commonMethods objCommonMethods;


	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {
		System.out.println("Inside Set up method ");
		System.out.println("---------------------------------------------");
		objCommonMethods= new commonMethods();
		objCommonMethods.launchBrowser();
	}

	@AfterMethod
	public void tearDown() throws IOException {

		objCommonMethods.closebrowser();
	}

}
