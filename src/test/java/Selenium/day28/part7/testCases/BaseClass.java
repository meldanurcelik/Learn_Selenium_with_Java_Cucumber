package Selenium.day28.part7.testCases;

import Selenium.day27.part3.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();

    public String username = readconfig.getUseremail();

    public String password = readconfig.getPassword();

    public static WebDriver driver;

    public static Logger logger; //Added logger

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {

        logger = Logger.getLogger("eCommerce"); //Added logger
        PropertyConfigurator.configure("Log4j.properties");//Added logger

        if (br.equals("firefox")) {
            // Firefox Browser
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (br.equals("chrome")) {
            // opens the browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }

        // Global implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public static String randomestring() {
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }

}