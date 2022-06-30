package Selenium.day28.part6.testCases;

import java.io.IOException;

import Selenium.day28.part5.testCases.BaseClass;
import Selenium.day28.part6.pageObjects.LoginPage;
import Selenium.day28.part6.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginTest(String user, String pwd) throws InterruptedException, IOException {

        driver.get(baseURL);
        driver.manage().window().maximize();

        LoginPage lp = new LoginPage(driver);

        lp.setUserName(user);
        logger.info("User provided"); //logger msg

        lp.setPassword(pwd);
        logger.info("Password provided"); //logger msg

        lp.clickLogin();
        logger.info("Login in Clicked"); //logger msg

        Thread.sleep(2000);

        if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
            lp.clickLogout();
            Assert.assertTrue(true);
            logger.info("Login Passed"); //logger msg

        } else {
            captureScreen(driver, "loginTest");
            logger.info("Login Failed"); //logger msg
            Assert.assertTrue(false);
        }

    }


    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/java/Selenium/day28/part6/testData/LoginData.xlsx";

        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

        String logindata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }

        return logindata;

    }

}