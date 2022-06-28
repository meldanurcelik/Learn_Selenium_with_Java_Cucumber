package Selenium.day24;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class Log4jDemo {

    static Logger logger;

    @Test(priority = 1)
    public void setup() {
        logger = Logger.getLogger("Log4jdemo");  // Provide test case name/class name as a parameter
        PropertyConfigurator.configure("Log4j.properties");

        logger.info("Setup method is tarted");
        logger.info("Setup method is progress");

        //Add configuration steps
        System.out.println("This is setup method");
    }

    @Test(priority = 2)
    public void login() {
        logger.info("login is started");
        //Write webdriver code
        System.out.println(" This is login test");
        logger.info("login is progress");
        logger.info("login is completed");
        logger.info("login is passed");

    }

    @Test(priority = 3)
    public void logout() {
        //Write webdriver code
        System.out.println(" This is logout test");
        logger.info("logout is completed");
    }

}