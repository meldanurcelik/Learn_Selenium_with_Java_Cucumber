package Selenium.day23.listerners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    void setup() {
        Assert.assertTrue(false);
    } //faill

    @Test
    void loginByEmail() {
        Assert.assertTrue(true);
    } //pass

    @Test(dependsOnMethods = {"setup"})
    void loginByFacebook() {
        Assert.assertTrue(true);
    }  //skipped

}