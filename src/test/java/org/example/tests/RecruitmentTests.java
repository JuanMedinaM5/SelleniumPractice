package org.example.tests;

import org.example.pages.RecruitmentPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTests extends BaseTest {
    private RecruitmentPage recruitmentPage;



    @Test
    public void testClickVacanciesFilter() {
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.navigateToRecruitmentSection();
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recruitmentPage.clickVacanciesFilter();
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
