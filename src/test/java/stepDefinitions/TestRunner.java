package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(tags = "", features = "src/test/resources/Features/LoginLogout.feature", 
glue = { "stepDefinitions" },
 
monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
