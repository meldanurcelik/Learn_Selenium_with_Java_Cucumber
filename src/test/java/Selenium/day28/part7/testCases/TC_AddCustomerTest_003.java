package Selenium.day28.part7.testCases;

import java.io.IOException;

import Selenium.day28.part6.pageObjects.LoginPage;
import Selenium.day28.part7.pageObjects.AddCustomerPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_AddCustomerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws IOException, InterruptedException {

        driver.get(baseURL);
        driver.manage().window().maximize();

        LoginPage lp = new LoginPage(driver);

        lp.setUserName(username);
        logger.info("User provided"); //logger msg

        lp.setPassword(password);
        logger.info("Password provided"); //logger msg

        lp.clickLogin();
        logger.info("providing customer details...."); //logger msg

        Thread.sleep(2000);

        AddCustomerPage addcust = new AddCustomerPage(driver);

        addcust.clickOnCustomersMenu();

        addcust.clickOnCustomersMenuItem();

        addcust.clickOnAddNew();

        String email = randomestring() + randomeNum() + "@gmail.com";
        addcust.setEmail(email);

        addcust.setPassword("test123");

        addcust.setFirstName("Melda");

        addcust.setLastName("Celik");

        addcust.setGender("Female");

        addcust.setDob("11/23/1996");

        addcust.setCompanyName("Gini");

        addcust.setCustomerRoles("Guests");

        addcust.setManagerOfVendor("Vendor 2");

        addcust.setAdminContent("This is for testing.........");

        addcust.clickOnSave();

        logger.info("validation started....");

        //String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();

        String msg = driver.findElement(By.tagName("body")).getText();


        if (msg.contains("The new customer has been added successfully.")) {
            Assert.assertTrue(true);
            logger.info("test case passed....");
        } else {
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
        }

    }

}