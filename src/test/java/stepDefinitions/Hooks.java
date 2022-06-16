package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	commonMethods objCommonMethods;
	
	

	@Before
	public void setup() throws InterruptedException {
		objCommonMethods= new commonMethods();
		objCommonMethods.launchBrowser();

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) objCommonMethods.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); // stick it in the report

		} 
		objCommonMethods.closebrowser();
	}

}
