package bdd.utils;

import io.qameta.allure.Attachment;
import lecture13.homework13.base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestListeners extends BaseTest implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot){
        return screenShot;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES));
    }

}
