package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.AllureTestNg;
import junit.framework.TestListener;
import org.example.pages.RecruitmentPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class RecruitmentTests extends BaseTest {

    @Test
    @Description("Prueba para navegar a la seccion de Recruitment")
    @Severity(SeverityLevel.CRITICAL)
    public void navigateToRecruitmentPage() {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        recruitmentPage.navigateToRecruitmentSection();

        recruitmentPage.verifyRecruitmenHeader();
    }

    @Test
    @Description("Prueba para hacer clic en el filtro de Vacancies")
    @Severity(SeverityLevel.NORMAL)
    public void testClickVacnaciesFilter(){
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        recruitmentPage.navigateToRecruitmentSection();
        recruitmentPage.clickVacanciesFilter();
    }


}
