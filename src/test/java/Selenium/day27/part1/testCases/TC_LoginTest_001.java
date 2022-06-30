package Selenium.day27.part1.testCases;

import Selenium.day27.part1.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException {

        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        // lp.setUserName(username);
        // lp.setPassword(password);
        lp.clickLogin();

        if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
            Thread.sleep(3000);
            lp.clickLogout();
            Assert.assertTrue(true);

        } else {
            Assert.assertTrue(false);
        }

    }

}