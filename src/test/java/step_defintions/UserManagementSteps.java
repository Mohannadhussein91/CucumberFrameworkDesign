package step_defintions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {
	
	CraterLoginPage carterLogin = new CraterLoginPage();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	BrowserUtils utils = new BrowserUtils();
	
	// valid login test
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	}
	
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		utils.sendKeysWithActionsClass(carterLogin.useremail, username);
		utils.sendKeysWithActionsClass(carterLogin.password, password);
	 
	}
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		carterLogin.loginButton.click();
	  
	}
	
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
	   utils.waitUntilElementVisible(dashboard.amountDueText);
	   Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	  
	}
	@Then("user quits the browser")
	public void user_quits_the_browser() {
	    Driver.quitDriver();
	}

	
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String invalidUserEmail, String invalidPassword) {
		utils.sendKeysWithActionsClass(carterLogin.useremail, invalidUserEmail);
		utils.sendKeysWithActionsClass(carterLogin.password, invalidPassword);
	}

	@Then("an error message appears")
	public void an_error_message_appears() {
		 utils.waitUntilElementVisible(carterLogin.invalidUserErrorMessage);
		 Assert.assertTrue(carterLogin.invalidUserErrorMessage.isDisplayed());
		
	  
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
		Assert.assertTrue(carterLogin.loginButton.isDisplayed());
		
	}

}
