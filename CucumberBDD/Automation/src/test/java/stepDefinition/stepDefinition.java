package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition {

    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable 
    {
    	//code to navigate to login page
    	System.out.println("Given executed");
    }
    
    
    @When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_username_something_and_password_something(String strArg1, String strArg2) throws Throwable 
    {
    	//code to enter credentials and hit enter
    	System.out.println("When executed" +strArg1);
    	System.out.println("When executed: " +strArg2);
    	
    }
    
    /*@When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable 
    {
    	
    }*/

    @Then("^User is logged into the application$")
    public void user_is_logged_into_the_application() throws Throwable
    {
    	//code to verify if the login page is displayed
    	System.out.println("Then executed");
    }

    @And("^Account information is displayed \"([^\"]*)\"$")
    public void account_information_is_displayed_something(String strArg1) throws Throwable 
    {
        System.out.println("And executed");
    }


}