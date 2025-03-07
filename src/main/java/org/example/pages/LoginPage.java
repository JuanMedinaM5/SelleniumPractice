package org.example.pages;

import org.example.utils.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type=submit]");
    private By logoutButton = By.id("logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = WebDriverSetup.getWait();
    }

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();

    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void logout() {
        By logoutButton = By.id("logout");
        WebElement logoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonElement.click();
    }

}
