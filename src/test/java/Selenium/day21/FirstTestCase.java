package Selenium.day21;

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 2)
    void login() {
        //webdriver code for open URL
        System.out.println("This is Login");
    }

    @Test(priority = 3)
    void logout() {
        //webdriver code for open URL
        System.out.println("This is Logout");
    }

    @Test(priority = 1)
    void openURL() {
        //webdriver code for open URL
        System.out.println("This is open URL");
    }

}