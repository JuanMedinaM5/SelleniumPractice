package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmployeeDistributionTest extends BaseTest {

    @Test
    public void testClickLegend(){
        By unassignedLegend = By.xpath("//ul[@class='oxd-chart-legend']//li//span[@title='Unassigned']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement unassignedElement = wait.until(ExpectedConditions.elementToBeClickable(unassignedLegend));
        unassignedElement.click();

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
