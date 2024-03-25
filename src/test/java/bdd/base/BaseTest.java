package bdd.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class BaseTest implements ITestListener {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public void startDriver() {
        WebDriverManager.chromedriver().cachePath("web driver").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterMethod
    public void stopDriver(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            String src = "images" + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + "_" + LocalDate.now() +
                    ".png";

            Allure.addAttachment("Screenshot", FileUtils.openInputStream(
                    takeScreenShot(new File(src))));
            Allure.addAttachment("console log", takeConsoleLog());
        }

        getDriver().quit();
    }

    private File takeScreenShot(File file) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, file);
        return srcFile;
    }

    private String takeConsoleLog() {
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        return browserLogs.getAll().toString();
    }
}
