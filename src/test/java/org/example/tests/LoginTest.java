package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import junit.framework.TestListener;
import org.example.pages.LoginPage;
import org.example.utils.ScreenShotUtil;
import org.example.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {

    @Test
    @Description("Prueba de inicio de sesion con credenciales validas")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        try {
            loginPage.enterUsername("Admin");
            ScreenShotUtil.takeScreenShot(driver, "Ingresar usuario");

            loginPage.enterPassword("admin123");
            ScreenShotUtil.takeScreenShot(driver, "Ingresar password");

            loginPage.clickLoginButton();
            ScreenShotUtil.takeScreenShot(driver, "Resultado");

            verifyLoginSucces();
        } catch (Exception e) {
            ScreenShotUtil.takeScreenShot(driver, "Error de login");
        }
    }

    @Test
    @Description("Prueba de inicio de sesion con credenciales invalidas")
    public void loginInvalidTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Administrador", "administrador123");
        verifyLoginFailure();
    }

    @Step("Intentando iniciar sesion con usuaruio: {username}")
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @Step("Verificando que el inicio de sesion fue exitoso")
    public void verifyLoginSucces() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("dashboard"), "El inicio de sesion fallo, no se redirigio al dashboard");
    }

    @Step("Verificando que el inicio de sesion fallo")
    public void verifyLoginFailure() {
        String expectedErrorMessage = "Credenciales incorrectas";
        String actualErrorMessage = driver.getCurrentUrl();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "El inicio de sesion no fue falso");
        ScreenShotUtil.takeScreenShot(driver, "Error de inicio de sesion");
    }


}