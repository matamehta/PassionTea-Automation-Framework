package passionTea;

import config._Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executionAction.PassionPageAction;
import org.junit.Assert;
import utility.DriverFactory;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TestCase002StepsDef {
    private static PassionPageAction ppa;

    @When("^I open PassionTea passion page URL$")
    public void I_open_PassionTea_passion_page_URL() throws Throwable {
        ppa = new PassionPageAction();
    }

    @And("^I want to do UI testing on Passion Page$")
    public void I_want_to_do_UI_testing() throws Throwable {
        ppa.eyesTest();
    }

    @Then("^I should land at correct passion page$")
    public void I_should_land_at_correct_passion_page() throws Throwable {
        Assert.assertTrue(DriverFactory.getCurrentDriver().getTitle().equals(_Constants.PassionPageTitle));
    }
}
