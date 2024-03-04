Framework Details:

* In this framework Page Object Design is used. Separate classes were created for each page of the mobile app.
* In Base class initialization of the driver and capabilities were set.
* Login credentials were stored in config file and fetch details on the run.
* Testcase were written in test class LeagueSelectionPageTests
* Parameterization is achieved through testng.

Following are the packages in this framework;

* BaseClass
* Welcomepage 
* SignInPage
* LeagueSelectionpage
* Leaguepage
* LeagueSelectionPageTests

Steps to execute testcase:

* Run testng.xml file in /testsuite folder. 

Pre-requisites for running tests:

* Java 11 installed
* Android Studio
* Appium installed
* Android Inspector for locating elements


TestCases:

1. Verify signIn
2. Verify League Page
3. Verify League Page Headers


Test Reports:

/test-output/emailable-report.html



    


