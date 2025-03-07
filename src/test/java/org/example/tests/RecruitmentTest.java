package org.example.tests;

import org.example.pages.RecruitmentPage;
import org.testng.annotations.Test;

public class RecruitmentTest extends BaseTest {

    @Test
    public void navigateToRecruitment() {

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.navigateToRecruitmentSection();



        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClickVacanciesFilter() {

    }

}
