package passionTea;

import config._Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executionAction.WelcomePageAction;
import org.junit.Assert;
import utility.DriverFactory;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TestCase001StepsDef {
    private static WelcomePageAction wpa;

    @When("^I open PassionTea welcome page URL$")
    public void I_open_PassionTea_welcome_page_URL() throws Throwable {
        wpa = new WelcomePageAction();
    }

    @And("^I check side navigation bar$")
    public void I_check_side_navigation_bar() throws Throwable {
        wpa.assertWelcomePageLink();
    }

    @And("^I want to do UI testing on Welcome Page$")
    public void I_want_to_do_UI_testing() throws Throwable {
        wpa.eyesTest();
    }

    @Then("^I should land at correct welcome page$")
    public void I_should_land_at_correct_welcome_page() throws Throwable {
        Assert.assertTrue(DriverFactory.getCurrentDriver().getTitle().equals(_Constants.WelcomePageTitle));
    }
}
