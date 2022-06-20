package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@End2EndTest", features = "src/test/resources/Features", 
glue = { "stepDefinitions" },
plugin = {
		"json:target/cucumber.json", "html:target/HtmlReports.html" }, 
monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
