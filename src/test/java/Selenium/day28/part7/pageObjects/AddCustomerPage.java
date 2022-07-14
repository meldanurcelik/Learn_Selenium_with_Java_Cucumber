package Selenium.day28.part7.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By linkCustomersMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By linkCustomersMenuItem = By.xpath("//li[@class='nav-item has-treeview menu-open']//li[@class='nav-item']//a[@href='/Admin/Customer/List']");
    By btnAddNew = By.xpath("//a[@href='/Admin/Customer/Create']"); //Add new
    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");
    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");
    By rdMaleGender = By.id("Gender_Male");
    By rdFeMaleGender = By.id("Gender_Female");
    By txtBirthday = By.xpath("//input[@id='DateOfBirth']");
    By txtCompanyName = By.xpath("//input[@id='Company']");

    By txtNewsletter = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']");
    By txtCustomerRoles = By.xpath("//div[@class='input-group-append input-group-required']//div[@class='k-multiselect-wrap k-floatwrap']");
    By btnDeleteTag = By.xpath("//span[@title='delete']");
    By listItemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
    By listItemRegistered = By.xpath("//li[contains(text(),'Registered')]");
    By listItemGuests = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']//li[contains(text(),'Guests')]");
    By listItemVendors = By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']//li[contains(text(),'Vendors')]");
    By drpManagerOfVendor = By.xpath("//*[@id='VendorId']");
    By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
    By btnSave = By.xpath("//button[@name='save']");


    public void clickOnCustomersMenu() {
        ldriver.findElement(linkCustomersMenu).click();
    }

    public void clickOnCustomersMenuItem() {
        ldriver.findElement(linkCustomersMenuItem).click();
    }

    public void clickOnAddNew() {
        ldriver.findElement(btnAddNew).click();
    }

    public void setEmail(String email) {
        ldriver.findElement(txtEmail).sendKeys(email);
    }


    public void setPassword(String password) {
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String role) {

        ldriver.findElement(btnDeleteTag).click();

        ldriver.findElement(txtCustomerRoles).click();

        WebElement listitem;

        switch (role) {
            case "Administrators":
                listitem = ldriver.findElement(listItemAdministrators);
                break;
            case "Guests":
                listitem = ldriver.findElement(listItemGuests);
                break;
            case "Registered":
                listitem = ldriver.findElement(listItemRegistered);
                break;
            case "Vendors":
                listitem = ldriver.findElement(listItemVendors);
                break;
            default:
                listitem = ldriver.findElement(listItemGuests);
        }

        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].click();", listitem);

    }

    public void setManagerOfVendor(String value) {
        Select drp = new Select(ldriver.findElement(drpManagerOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender) {

        if (gender.equals("Male")) {
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {
            ldriver.findElement(rdFeMaleGender).click();
        } else {
            ldriver.findElement(rdMaleGender).click();//Default
        }

    }

    public void setFirstName(String fname) {
        ldriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLastName(String lname) {
        ldriver.findElement(txtLastName).sendKeys(lname);
    }

    public void setDob(String dob) {
        ldriver.findElement(txtBirthday).sendKeys(dob);
    }

    public void setCompanyName(String comname) {
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }

    public void setAdminContent(String content) {
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave() {
        ldriver.findElement(btnSave).click();
    }

}