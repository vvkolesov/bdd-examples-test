package bdd.pages.andersenlab;


import bdd.base.BasePage;
import bdd.objects.UserRegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private WebElement dateOfBirthField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//div[@class='react-datepicker__month-container']")
    private WebElement datePicket;
    @FindBy(xpath = "//button")
    private WebElement submitButton;
    @FindBy(xpath = "//select[1]")
    private WebElement yearDatePicker;
    @FindBy(xpath = "//select[2]")
    private WebElement monthDatePicker;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage typeRegistrationData(UserRegistrationData userRegistrationData) {
        waitForVisibility(firstNameField);
        firstNameField.sendKeys(userRegistrationData.getFirstName());
        lastNameField.sendKeys(userRegistrationData.getLastName());
        emailField.sendKeys(userRegistrationData.getEmail());
        passwordField.sendKeys(userRegistrationData.getPassword());
        confirmPasswordField.sendKeys(userRegistrationData.getPassword());
        return this;
    }

    public RegistrationPage chooseDateOfBirth(String month, String year, String day) {
        dateOfBirthField.click();
        waitForVisibility(datePicket);
        new Select(monthDatePicker).selectByValue(month);
        new Select(yearDatePicker).selectByValue(year);

        driver.findElement(By.xpath("//div[contains(text(), '10')]")).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        waitForClickable(submitButton);
        submitButton.click();
        return this;
    }
}
