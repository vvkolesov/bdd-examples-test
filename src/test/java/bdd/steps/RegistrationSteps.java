package bdd.steps;

import bdd.base.BaseTest;
import bdd.pages.andersenlab.LoginPage;
import bdd.pages.andersenlab.RegistrationPage;
import bdd.utils.FakerUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends BaseTest {

    LoginPage loginPage = new LoginPage(getDriver());
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    FakerUtils faker = new FakerUtils();

    @Given("Given Navigate to registration page")
    public void givenNavigateToRegistrationPage() {
        loginPage.load("https://qa-course-01.andersenlab.com/login")
                .clickRegistrationButton();
    }

    @When("Enter valid data for registration")
    public void enterValidDataForRegistration() {
        registrationPage.typeRegistrationData(faker.generateRegistrationData());
    }

    @And("Enter date of birth")
    public void enterDateOfBirth() {
        registrationPage.chooseDateOfBirth(
                faker.generateDOB()[0],
                faker.generateDOB()[1],
                faker.generateDOB()[2]
        );
    }

    @Then("Click on the Submit button")
    public void clickOnTheSubmitButton() {
        registrationPage.clickSubmitButton();
    }
}
