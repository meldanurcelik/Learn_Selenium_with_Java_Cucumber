package Cucumber.day31.stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class MyAccountLoginStepDefinitions {

    public WebDriver driver = null;

    @Given("^Open the browser$")
    public void open_the_browser() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("^Enter the URL \"([^\"]*)\"$")
    public void enter_the_URL(String arg1) throws Throwable {
        driver.get(arg1);
    }

    @And("^Click on My Account Menu$")
    public void click_on_My_Account_Menu() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
    }

    @And("^Enter registered username and password$")
    public void enter_registered_username_and_password() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("pavanoltraining");
        driver.findElement(By.id("password")).sendKeys("Test@selenium123");
    }

    @And("^Click on login button$")
    public void click_on_login_button() {
        driver.findElement(By.name("login")).click();
    }

    @Then("^User must successfully login to the web page$")
    public void user_must_successfully_login_to_the_web_page() throws Throwable {
        Thread.sleep(2000);
        String capText = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/strong")).getText();
        assertEquals(true, capText.contains("pavanoltraining"));
    }

}