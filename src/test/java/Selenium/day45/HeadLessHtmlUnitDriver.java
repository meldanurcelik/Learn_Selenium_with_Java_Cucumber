package Selenium.day45;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadLessHtmlUnitDriver {

    public static void main(String[] args) {

        // create instance for the HtmlUnitWebDriver
        HtmlUnitDriver driver = new HtmlUnitDriver();

        driver.get("http://demo.nopcommerce.com/");

        System.out.println("Title of the page : " + driver.getTitle());
        System.out.println("URL of the page : " + driver.getCurrentUrl());

        driver.quit();

    }

}