package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores
    private By selectPost = By.xpath("(//div[contains(@class, 'orangehrm-buzz-widget-header')])[3]");

        public DashboardPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void selectPost() {
            WebElement postElement = wait.until(ExpectedConditions.visibilityOfElementLocated(selectPost));
            postElement.click();

        }

}
