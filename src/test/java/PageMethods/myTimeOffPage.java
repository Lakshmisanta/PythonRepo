package PageMethods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.cucumberLogs;


public class myTimeOffPage extends commonMethods {
	
	@FindBy(xpath = "//*[@class ='inside-ucl-large-tile__text OSFillParent']")
	public List<WebElement> link_MyTimeOff;
	
	SoftAssert softAssert = new SoftAssert();

	public myTimeOffPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
}