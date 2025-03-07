package org.example.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenShotUtil {
    public static void takeScreenShot(WebDriver driver, String screenShotName) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(screenShotName, new ByteArrayInputStream(screenshot));
        } else {
            System.out.println("Not a TakesScreenshot");
        }
    }
}
