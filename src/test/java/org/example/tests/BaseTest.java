package org.example.tests;

import org.checkerframework.checker.units.qual.A;
import org.example.pages.LoginPage;
import org.example.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverSetup.getDriver();
        driver.get("http://opensource-demo.orangehrmlive.com/");

        if(!this.getClass().getSimpleName().equals("LoginTestExcel")) {
            login("Admin", "admin123");
        }

    }

    protected void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @AfterClass
    public void tearDown() {
        WebDriverSetup.closeDriver();
    }
}
