<b>Automation framwork</b> 
Sample automation framework just for learing purpose.

<b>Technolgies used:</b><br>
Java, Maven, TestNg, Selenium, Java Mail, Allure Report, Log4j

<b>Features: </b> <br>
1. PageObject Model. <br>
2. Parallel test execution with TestNG<br>
3. Reporting with Allure Report<br>
4. Logging for both console level and File.<br>
5. Circle CI integration.<br>
6. Works perfectly with Jenkins.<br>
7. Mail Functionality(Send mail after each suite run).<br>
8. SauceLabs integration.<br>
9. Selenium Grid integration.<br>
10. Custom Exception for Maven arguments.<br>

<b>How to Run Test: </b><br>
mvn clean test -Dbrowser=Chrome -Dmail=N <br>
Values for -Dbrowser=Grid,ChromeSauce <br>
Values for -Dmail=N,Y <br>

<b>Generating allure report:</b> <br>
Install Allure CLI and run command <b>mvn allure:report</b>

