package bdd.pages.andersenlab;

import bdd.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//span[contains(text(),'Required')]")
    private List<WebElement> errorMessage;
    @FindBy(xpath = "//div[4]/p[2]")
    private WebElement emailValue;
    @FindBy(xpath = "//a[@href='/registration']")
    private WebElement registrationButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage load(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage typeCredential(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        submitButton.click();
    }

    public String nextPageChecker() {
        waitForVisibility(emailValue);
        return emailValue.getText();
    }

    public List<WebElement> errorMessages() {
        return errorMessage;
    }

    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return new RegistrationPage(driver);
    }

}
