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
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	}
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		utils.sendKeysWithActionsClass(craterLogin.useremail, username);
		utils.sendKeysWithActionsClass(craterLogin.password, password);
	 
	}
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		craterLogin.loginButton.click();
	  
	}
	
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
	   utils.waitUntilElementVisible(dashboard.amountDueText);
	   Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	  
	}

}
