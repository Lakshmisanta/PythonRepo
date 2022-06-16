
# Inside UCL E2E Automation

This repository contains a collection of Regression Test Suite in BDD + TDD framework for Inside UCL application




## Features:

This project is used by the following companies:

- Crisp & Clear maven folder structures
- Extensive methods in CucumberRunner class
- CucumberOptions with detailed explanation of using "tags", "glue" ,”monochrome” , “pulgins”
- Screenshots on failure feature in CucumberRunner class
- TestNG Annotations/hooks like "@After", “@Before” etc.
- Descriptive pom.xml and testng.xml
- Scenarios for Regression suite features and step definition files
- Methods for running tests in Firefox and Chrome and Edge browsers


## Installation (pre-requisites)

1. JDK 1.8+ (make sure Java class path is set in environment variables)
2. Maven (make sure .m2 class path is set in environment variables)
3. Eclipse
4. Eclipse Plugins for
   - Maven
   - Cucumber
   - TestNG
5. Browser driver (make sure you have your desired browser driver and class path is set)


    
## Maven folder structures 


![alt text](https://git.automation.ucl.ac.uk/sits-integration/UCL-e2e-AutomationTest/-/blob/dev/MavenFolderStructure.png)



## Directory layout Files

1. src/main/java 

Inside this folder you can put all the application resource files. Resources for the main (real) artifact should be put in this folder.
In this folder , you will find Utilities package. In this package , we are having common generic java classes like- cucumberLogs.java and cucumberReport
Were cucumberLogs file is to generate the application logs file which have a specified format.
And cucumberReports file is to generate cucumber Reports after script Execution.

2. src/test/java 
Inside this folder you can put all the application test resource files. Resources for the test artifact should be put in this folder.
In this folder, you will find 2 packages as below-

i. StepDefinitions- Here we have step definition classes. As below


![alt text](https://git.automation.ucl.ac.uk/sits-integration/UCL-e2e-AutomationTest/-/blob/dev/STEP_DEF.png)

Writing TestRunner class –

![alt text](https://git.automation.ucl.ac.uk/sits-integration/UCL-e2e-AutomationTest/-/blob/dev/TESTRUNNER.png)

ii. ii. PageMethods – It consist of classes respective to each page . implementing Page factory methodology. 

3. src/test/resources

Inside this folder you can put all the application resource files. Resources for the test  should be put in this folder.

In this folder , you will find folders like Features, Config , Drivers.

i. Features-  Here we are writing features scenarios as below- 

![alt text](https://git.automation.ucl.ac.uk/sits-integration/UCL-e2e-AutomationTest/-/blob/dev/FEATURE.png)

ii. Drivers- Here we have the respective drivers to launch the browser to run the script

iii. Config – In this folder, we are having properties file to respective dependencies like log4j and cucumber properties

# Run Scripts

- Fork this repo, keep the folder the structure intact
- Run the following maven command from command line


mvn clean test verify

- The scripts should run successfully in Chrome browser and should generate application logs 
- Target folder should be created with cucumber-html-report and surefire-reports.
- Test_Output folder should be created with the default testng reports

# HTML Reports

Default cucumber HTML reports are generated which is customized according to specific needs.

![alt text](https://git.automation.ucl.ac.uk/sits-integration/UCL-e2e-AutomationTest/-/blob/dev/html_REPOPRT.png)

![alt text](https://git.automation.ucl.ac.uk/sits-integration/UCL-e2e-AutomationTest/-/blob/dev/HTML_REPORT_2.png)

