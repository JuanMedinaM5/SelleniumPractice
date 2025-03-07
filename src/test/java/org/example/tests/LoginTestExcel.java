package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.AllureTestNg;
import org.example.pages.LoginPage;
import org.example.utils.ExcelReader;
import org.example.utils.ScreenShotUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@Listeners({AllureTestNg.class})
public class LoginTestExcel extends BaseTest{

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        String filePath = "C:\\Users\\2000145228\\IdeaProjects\\Practica_Introduction\\src\\resources\\testdata.xlsx";
        String sheetName = "Sheet1";
        List<Map<String, String>> data = ExcelReader.readExcel(filePath, sheetName);

        Object[][] testData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i);
        }
        return testData;
    }

    @Test(dataProvider = "loginData")
    @Description("Prueba de inicio de sesion con dados desde excel")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin(Map<String, String> testData) {
        LoginPage loginPage = new LoginPage(driver);

        try {
            String username = testData.get("Username");
            String password = testData.get("Password");
            String expectedResult = testData.get("ExpectedResult");

            loginPage.enterUsername(username);
            ScreenShotUtil.takeScreenShot(driver, "Ingresar usuario" + username);

            loginPage.enterPassword(password);
            ScreenShotUtil.takeScreenShot(driver, "Ingresar password" + password);

            loginPage.clickLoginButton();
            ScreenShotUtil.takeScreenShot(driver, "Clic login");

            if (expectedResult.equals("Success")) {

                String dashboardUrl = driver.getCurrentUrl();
                Assert.assertTrue(dashboardUrl.contains("dashboard"), "El inicio de sesion fallo. No se redirigio a dashboard");
                ScreenShotUtil.takeScreenShot(driver, "Login exitoso");
            } else {
                Assert.assertNotNull("No se encontro el inicio de sesion", driver.getCurrentUrl());
                ScreenShotUtil.takeScreenShot(driver, "Error de login");
            }

        } catch (Exception e) {
            ScreenShotUtil.takeScreenShot(driver, "Error de login");
            throw e;
        }
    }



}
