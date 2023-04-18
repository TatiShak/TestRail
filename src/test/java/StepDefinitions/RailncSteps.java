package StepDefinitions;
import config.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class RailncSteps {
        WebDriver driver;
        HomePage homepage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        homepage = new HomePage(driver);
    }
    @Given("^I am on the Railinc Home Page$")
        public void navigateToHomePage() {
            homepage.navigateToHomePage();
        }
    // Verify the page logo is displayed
        @Then("^I verify the page logo$")
        public void verifyPageLogo() {
            homepage.verifyPageLogo();
        }



        @When("^I click on the About Us link$")
        public void clickOnAboutUsLink() {
            homepage.navigateToHomePage();
            homepage.clickOnAboutUsLink();
        }

        @Then("^I should be redirected to the About Us page$")
        public void verifyAboutUsPage() {
            // Verify the About Us page
           homepage.verifyAboutUsPage();
        }

        @And("^I should see title in the page title$")
        public void verifyAboutUsPageTitle() {
            // Verify the About Us page title
            homepage.verifyAboutUsPageTitle();
        }

    @After
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }
    }
