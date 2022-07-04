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

	@FindBy(className="dropdown-display.dropdown")
	public WebElement dropdown;


	public myTimeOffPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public boolean isMyTimeOffDisplayed(){
		return commonMethods.waitTillVisiblity(dropdown, "calender dropdown");
	}

}
