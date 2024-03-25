package bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public BasePage load(String url) {
        driver.get(url);
        return this;
    }

    protected void waitForVisibility(WebElement element) throws Error{
        Duration duration = Duration.ofSeconds(30);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForClickable(WebElement element) throws Error{
        Duration duration = Duration.ofSeconds(30);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
