package bdd.steps;

import bdd.base.BaseTest;
import bdd.pages.andersenlab.LoginPage;
import io.cucumber.java.en.*;

public class LoginPageSteps extends BaseTest {

    LoginPage loginPage = new LoginPage(getDriver());

    @Given("Navigate to URL")
    public void navigate_to_login_page() {
        loginPage.load("https://qa-course-01.andersenlab.com/login");
    }

    @When("Enter valid credentials")
    public void enter_valid_credentials() {
        loginPage.typeCredential("email@email.nl", "password");
    }

    @Then("Click on Sign in button")
    public void click_on_sign_in_button() {
        loginPage.clickLoginButton();
    }

}
