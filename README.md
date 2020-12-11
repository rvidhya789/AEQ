All the test cases included in testcases.txt file are automated in this project.
Maven project is built and it is based on java and selenium.


Tools installed:
Java,
Maven

Added dependencies in the POM.XML .
Junit
Cucumber
Selenium


Drivers (Exist in the project)
Chrome Driver for Mac
Gecko Driver for Mac

Browsers:
Chrome

IDE: Intellij/Eclipse
Plugins: Cucumber for Java, Gherkin

How to Run Scripts:

Navigate to 
Src/test/java/com/runner/RunUITests class
Right click on it and click RunUITests option

or

Right click on any scenario in Feature file and execute teh script

or

we can execute the scripts using command line

mvn test -Dcucumber.options="--tags '@login'"

Reports would be generated under :
/target/cucumber-html-report
