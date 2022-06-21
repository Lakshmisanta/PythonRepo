package PageMethods;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import Enums.Browsers;
import Enums.OS;
import stepDefinitions.Runner;
import utilities.cucumberLogs;
import utilities.globalvariables;

public class commonMethods {

	public static WebDriver driver;


	public void launchBrowser() throws InterruptedException, MalformedURLException {

			String browserName = globalvariables.BrowserName;
			if (browserName.contains("Chrome")) {

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--incognito");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				System.setProperty("webdriver.chrome.driver", globalvariables.CHROME_DRIVER_PATH);
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				navigate_to_URL();

			} else if (browserName.contains("FireFox")) {

				System.setProperty("webdriver.gecko.driver", globalvariables.Firefox_DRIVER_PATH);
				driver = new FirefoxDriver();

			} else if (browserName.contains("internet explorer")) {
				System.setProperty("webdriver.ie.driver", globalvariables.IE_DRIVER_PATH);
				driver = new InternetExplorerDriver();
			}
	}

	public static void navigate_to_URL() throws InterruptedException {

		String URL = globalvariables.URL;
		driver.get(URL);
		Thread.sleep(4000);
		cucumberLogs.info("URL is Launched : " + URL);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void navigateto_URL(String URL) throws InterruptedException {

		driver.get(URL);
		System.out.println("URL launch");
		Thread.sleep(4000);
		cucumberLogs.info("URL is Launched : " + URL);
	}

	public static void clearText(WebElement elem) {

		elem.clear();
	}

	public static boolean waitTillVisiblity(WebElement elem, String elementName) {
		try {
			cucumberLogs.info("Inside waitTillVisiblity");

			WebDriverWait waitForElement = new WebDriverWait(driver, 50);
			waitForElement.until(ExpectedConditions.visibilityOf(elem));

			cucumberLogs.info(elementName + " Element is visible");
			return true;

		} catch (Exception e) {
			cucumberLogs.error(elementName + " Element is not visible");
			return false;
		}
	}

	public static void sleepWait(int waitInSeconds) throws InterruptedException {
		Thread.sleep(1000 * waitInSeconds);
	}

	public static void clickElement(WebElement elem, String elementName) {

		try {
			elem.click();
			cucumberLogs.info(elementName + " Element is clicked");
		} catch (ElementClickInterceptedException e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem);
			cucumberLogs.info(elementName + " Element is clicked by javascript");
		}

	}

	public static void clickElement1(WebElement elem, String elementName) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elem);
		cucumberLogs.info(elementName + " Element is clicked by javascript");
	}

	public static void enterText(WebElement elem, String enterText) {

		elem.sendKeys(enterText);
		cucumberLogs.info(enterText + " is entered");

	}

	public static String getPageTittle() {
		return driver.getTitle();
	}

	public static String getTextFromElement(WebElement elem) {
		return elem.getText();
	}

	public static String getTextFromElement(WebElement elem, String elementName) {
		String Text;
		try {
			Text = elem.getText();
			cucumberLogs.info("Text of '" + elementName + "' is " + Text);
			return Text;
		} catch (Exception e) {
			cucumberLogs.error("'" + elementName + "' is not in details ");

		}
		return elementName;
	}

	public void closebrowser() {

		driver.quit();
		System.out.println("Inside close browser");
		cucumberLogs.info("Browser got closed");
	}

	public static boolean explicitWait(WebElement elem, String Conditions, int seconds) {

		WebDriverWait waitForElement;

		switch (Conditions) {
		case "visibilityOf":
			waitForElement = new WebDriverWait(driver, seconds);
			waitForElement.until(ExpectedConditions.visibilityOf(elem));
			break;
		case "elementToBeClickable":
			waitForElement = new WebDriverWait(driver, seconds);
			waitForElement.until(ExpectedConditions.elementToBeClickable(elem));
			break;
		case "elementToBeSelected":
			waitForElement = new WebDriverWait(driver, seconds);
			waitForElement.until(ExpectedConditions.elementToBeSelected(elem));
			break;
		case "alertIsPresent":
			waitForElement = new WebDriverWait(driver, seconds);
			waitForElement.until(ExpectedConditions.alertIsPresent());
			break;
		}

		return true;

	}

	// Method to Scroll Down
	public void scrolldownbrowser(WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elem);
	}

	// Alert Methods
	public void alertAccept() {

		Alert alert;
		alert = driver.switchTo().alert();
		alert.accept();

	}

	public void alertReject() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String alertGetText() {

		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	// getting attribute values from element

	public String getValueFromElement(WebElement elem, String Value) throws IOException {
		String ActualText = null;

		try {

			ActualText = elem.getAttribute(Value);

		} catch (Exception e) {

		}
		return ActualText;
	}

	// Switching to default content
	public void SwitchToDefault() {
		driver.switchTo().defaultContent();
	}

	// Switching to frame

	public void SwitchToframe(int index) {
		driver.switchTo().frame(index);
	}

	// Dropdown value selection

	public static boolean selectDropdown(WebElement elem, String selectType, @Optional String SelectTypeValue) {

		Select dropdown;

		switch (selectType) {
		case "selectByValue":

			dropdown = new Select(elem);
			dropdown.selectByValue(SelectTypeValue);
			break;

		case "selectByVisiblTtext":

			dropdown = new Select(elem);
			dropdown.selectByVisibleText(SelectTypeValue);
			break;

		}

		return true;

	}

	public static boolean selectDropdownByIndex(WebElement elem, int SelectIndexValue) {

		Select dropdown;

		dropdown = new Select(elem);
		dropdown.selectByIndex(SelectIndexValue);

		return true;

	}

	public void moveToElement(WebElement elem) {
		Actions action = new Actions(driver);
		action.moveToElement(elem).build().perform();
	}

	public void doubleClick(WebElement elem) {
		Actions action = new Actions(driver);
		action.doubleClick(elem).build().perform();

	}
	// To get the element with Parameterized locator

	public By parameterizeLocator(WebElement elem, String parameters) {
		By paramLocator = null;

		String[] strSeparator = elem.toString().split(": ", 2);

		String locatorType = strSeparator[0].trim();
		String locatorValue = strSeparator[1].trim();

		// System.out.println("Locator Type: " + locatorType + " , " + locatorValue);

		Integer count = 1;

		for (String value : parameters.split(";")) {

			locatorValue = locatorValue.replace("ParamValue_" + count.toString(), value);

			count++;
		}

		switch (locatorType) {
		case "by.id":
			paramLocator = By.id(locatorValue);
			break;
		case "by.name":
			paramLocator = By.name(locatorValue);
			break;
		case "by.cssselector":
			paramLocator = By.cssSelector(locatorValue);
			break;
		case "by.linktext":
			paramLocator = By.linkText(locatorValue);
			break;
		case "by.xpath":
			paramLocator = By.xpath(locatorValue);
			break;
		case "by.partiallinktext":
			paramLocator = By.partialLinkText(locatorValue);
			break;
		case "by.classname":
			paramLocator = By.className(locatorValue);
			break;
		case "by.tagname":
			paramLocator = By.tagName(locatorValue);
			break;
		}

		System.out.println("Parameterized Locator: " + paramLocator.toString());

		return paramLocator;
	}

	// Switch window method

	public WebDriver switchToNewWindow(String newWindowTitle) {
		String childWindow;
		Set<String> openWindows = driver.getWindowHandles();
		System.out.println("Number of windows opened - " + openWindows.size());
		Iterator<String> windows = openWindows.iterator();
		while (windows.hasNext()) {
			childWindow = windows.next();
			WebDriver newDriver = driver.switchTo().window(childWindow);
			System.out.println("Title:" + newDriver.getTitle().trim());
			if (newDriver.getTitle().trim().equals(newWindowTitle.trim())) {
				System.out.println(" new driver pointing to - " + newDriver.getTitle());
				return newDriver;
			}
		}
		System.out.println("Window title containing - " + newWindowTitle + " not found and hence returning old driver");
		return driver;
	}

	public int getCountOfWindowOrTabs(WebDriver driver) {
		Set<String> openWindows = driver.getWindowHandles();
		return openWindows.size();
	}

}
