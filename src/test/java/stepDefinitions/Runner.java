//This class only for understanding, not in use
package stepDefinitions;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageMethods.commonMethods;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/Features", glue = { "stepDefinitions" },

		plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class Runner extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGCucumberRunner;
	commonMethods objCommonMethods;

	public static RemoteWebDriver connection;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "version", "platform", "crossbrowser" })
	public void setUpClass(String browser, String version, String platform, boolean crossbrowser) throws Exception {
		if (crossbrowser = true) {
			String username = System.getenv("LT_USERNAME") == null ? "YOUR LT_USERNAME" : System.getenv("LT_USERNAME");
			String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR LT_ACCESS_KEY"
					: System.getenv("LT_ACCESS_KEY");

			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability(CapabilityType.BROWSER_NAME, browser);
			capability.setCapability(CapabilityType.VERSION, version);
			capability.setCapability(CapabilityType.PLATFORM, platform);

			capability.setCapability("build", "Cucumber Sample Build");

			capability.setCapability("network", true);
			capability.setCapability("video", true);
			capability.setCapability("console", true);
			capability.setCapability("visual", true);

			String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";
			System.out.println("gridURL : " + gridURL);
			connection = new RemoteWebDriver(new URL(gridURL), capability);
			System.out.println(capability);
			System.out.println(connection.getSessionId());
		} else {

			objCommonMethods = new commonMethods();
			objCommonMethods.launchBrowser(crossbrowser);
		}

	}

	//groups = "cucumber", description = "Runs Cucumber Feature",
	@Test( dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
		///Object[][] scenarios = super.scenarios();
		//return scenarios;
	}

	/*
	 * @AfterClass(alwaysRun = true) public void tearDownClass() {
	 * testNGCucumberRunner.finish(); }
	 */

}
