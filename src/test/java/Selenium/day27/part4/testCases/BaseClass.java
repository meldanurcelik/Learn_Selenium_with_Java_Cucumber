package Selenium.day27.part4.testCases;

import java.util.concurrent.TimeUnit;

import Selenium.day27.part3.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
        PropertyConfigurator.configure("log4j.properties"); //Added logger

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

}