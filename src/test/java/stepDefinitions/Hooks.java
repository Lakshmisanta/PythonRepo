package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageMethods.commonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class Hooks {


	 commonMethods objCommonMethods;

	  @Before
    public void setup() throws InterruptedException {
  	  System.out.println("Inside Set up method ");
  	  System.out.println("---------------------------------------------");
  	  objCommonMethods= new commonMethods();
	 }


	  @After
    public void tearDown(Scenario scenario) throws IOException {
  	  if (scenario.isFailed()) {

        final ByteArrayInputStream screenshot = new ByteArrayInputStream(((TakesScreenshot)
  	    objCommonMethods.driver).getScreenshotAs(OutputType.BYTES));
  	    Allure.addAttachment(scenario.getName(),screenshot ); // stick it in 	  the report
      }
    }

}
