package Cucumber.stepDefinitions;

import io.cucumber.java.en.*;

public class HooksStepDefinitions {

    @Given("^user is on add customer page$")
    public void user_is_on_add_customer_page() throws Throwable {
        System.out.println("User is on add customer page");
    }

    @When("^user fills the customer details$")
    public void user_fills_the_customer_details() throws Throwable {
        System.out.println("User fills the customer details");
    }

    @Then("^customer is added$")
    public void customer_is_added() throws Throwable {
        System.out.println("customer is added");
    }

    @Given("^user is on edit customer page$")
    public void user_is_on_edit_customer_page() throws Throwable {
        System.out.println("user is on edit customer page");
    }

    @When("^user edits contact details$")
    public void user_edits_contact_details() throws Throwable {
        System.out.println("user edits the contact details");
    }

    @Then("^contact details updated$")
    public void contact_details_updated() throws Throwable {
        System.out.println("contact details updated");
    }

    @Given("^user is on delete customer page$")
    public void user_is_on_delete_customer_page() throws Throwable {
        System.out.println("user is on delete customer page");
    }

    @When("^user delete customer$")
    public void user_delete_customer() throws Throwable {
        System.out.println("user delete the customer");
    }

    @Then("^customer deleted$")
    public void customer_deleted() throws Throwable {
        System.out.println("customer deleted");
    }

}