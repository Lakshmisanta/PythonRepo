package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

//import MyRunner.TestRunner;
import PageMethods.commonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks  {

	/*commonMethods objCommonMethods;

	// public RemoteWebDriver driver = this.connection;
	// boolean cross_browser = false;

	@Before
	@Parameters("crossbrowser")
	public void setup(boolean cross_browser) throws InterruptedException, MalformedURLException {
		objCommonMethods = new commonMethods();
		objCommonMethods.launchBrowser(cross_browser);

	}

	@After public void tearDown(Scenario scenario) throws IOException {
	  
	  //driver.executeScript("lambda-status=" + (scenario.isFailed() ? "failed" :	  "passed")); //System.out.println(driver.getSessionId());
	  
	  if (scenario.isFailed()) { final byte[] screenshot = ((TakesScreenshot)
	  objCommonMethods.driver).getScreenshotAs(OutputType.BYTES);
	  scenario.attach(screenshot, "image/png", scenario.getName());
	  
	  } 
	 // driver.quit(); 
	   objCommonMethods.closebrowser(); }*/
	 

}
