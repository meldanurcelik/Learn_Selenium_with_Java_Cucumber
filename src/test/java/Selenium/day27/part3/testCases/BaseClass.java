package Selenium.day27.part3.testCases;

import Selenium.day27.part3.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();

    public String username = readconfig.getUseremail();

    public String password = readconfig.getPassword();

    public static WebDriver driver;

    public static Logger logger; //Added logger

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        logger = Logger.getLogger("eCommerce"); //Added logger
        PropertyConfigurator.configure("log4j.properties"); //Added logger
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}