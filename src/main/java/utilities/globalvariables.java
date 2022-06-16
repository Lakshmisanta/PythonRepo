package utilities;

public class globalvariables {

	static String projectDIR = System.getProperty("user.dir");

	public static final String BrowserName = "Chrome";
	public static final String CHROME_DRIVER_PATH = projectDIR + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
	public static final String Firefox_DRIVER_PATH = projectDIR + "\\src\\test\\resources\\Drivers\\geckodriver.exe";
	public static final String IE_DRIVER_PATH = projectDIR + "\\src\\test\\resources\\Drivers\\geckodriver.exe";
	public static final String Edge_DRIVER_PATH = projectDIR + "\\src\\test\\resources\\Drivers\\MicrosoftWebDriver.exe";
	public static final String Screenshots_Path = projectDIR + "\\src\\test\\resources\\Screenshots\\";
	public static final String URL = "https://app-uat.ucl.ac.uk/InsideUCL/Home";
	public static final String Username = "ccaessw@ucl.ac.uk";
	public static final String Invalid_Username = "ccaessw@ucl.ac";
	public static final String Password = "BenNevis!234567";
}
