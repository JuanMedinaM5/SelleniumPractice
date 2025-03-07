package org.example.tests;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void testNavigateToPost() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.selectPost();
    }



}
