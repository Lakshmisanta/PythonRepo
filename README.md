
# Inside UCL E2E Automation

This repository contains a collection of Regression Test Suite in BDD + TDD framework for Inside UCL application

## Installation (pre-requisites)

1. JDK 1.8+ (make sure Java class path is set in environment variables)
2. Maven (make sure .m2 class path is set in environment variables)
3. Eclipse
4. Eclipse Plugins for
   - Maven
   - Cucumber
   - TestNG
5. Git bash to run tests from command line


## Features:

- Crisp & Clear maven folder structures
- Extensive methods in CucumberRunner class
- CucumberOptions with detailed explanation of using "tags", "glue" ,”monochrome” , “pulgins”
- Screenshots on failure feature in CucumberRunner class
- TestNG and cucumber Annotations/hooks like "@After", “@Before” etc.
- Descriptive pom.xml and testng.xml
- Scenarios for Regression suite features and step definition files
- Methods for running tests in Firefox and Chrome and Edge browsers


## Folder and file layout

1. src/main/java

  Inside this folder you can put all the application resource files. Resources for the main (real) artifact should be put in this folder.
  In this folder , you will find Utilities package. In this package , we are having common generic java classes like- cucumberLogs.java and cucumberReport
  Were cucumberLogs file is to generate the application logs file which have a specified format.
  And cucumberReports file is to generate cucumber Reports after script Execution.

2. src/test/java

  Inside this folder you can put all the application test resource files. Resources for the test artifact should be put in this folder.
  In this folder, you will find 2 packages as below-

i. StepDefinitions-

  Given When Then steps are added under this package

  Writing TestRunner class –


  ii. ii. PageMethods – It consist of classes respective to each page . implementing Page factory methodology.

3. src/test/resources

  Inside this folder you can put all the application resource files. Resources for the test  should be put in this folder.

  In this folder , you will find folders like Features, Config , Drivers.

  i. Features-  Here we are writing features scenarios as below-

  ii. Drivers- Here we have the respective drivers to launch the browser to run the script

  iii. Config – In this folder, we are having properties file to respective dependencies like log4j and cucumber properties

# How to run test cases [from command line or git bash terminal]

- First clone this repo, keeping same folder structure and wait for clone to finish

# To run scripts on local machine browser
    mvn clean test -Dcucumber.filter.tags=@RegressionTest -Dsuite=local.xml

    mvn clean test -Dcucumber.filter.tags=@SanityTest -Dsuite=local.xml

  Change tags in above command to run a specific test. e.g.
    mvn clean test -Dcucumber.filter.tags=@wip -Dsuite=local.xml

  Run a specific feature
    mvn clean test -Dcucumber.features=src/test/resources/Features/LoginLogout.feature -Dsuite=local.xml

# To run scripts on lambdatest

    mvn clean test -Dcucumber.filter.tags=@RegressionTest -Dsuite=crossbrowser.xml

  The scripts should run successfully in Chrome browser and should generate application logs

# Generate HTML Reports
   To generate html report run below command just after above command

    mvn allure:serve
