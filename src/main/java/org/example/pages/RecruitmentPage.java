package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores
    private By recruitmentSection = By.xpath("//aside[@class='oxd-sidepanel']//ul[@class='oxd-main-menu']//li[contains(text(), 'Recruitment')]");
    private By vacanciesFilter = By.xpath("//li[@class='oxd-topbar-body-nav-tab']");


    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Se usara para navegar a la seccion de Recruitment
    public void navigateToRecruitmentSection() {
        WebElement recruimentSection = wait.until(ExpectedConditions.elementToBeClickable(recruitmentSection));
        recruimentSection.click();
    }
    // -- Metodos dentro de la seccion Recruitment --
    public void clickVacanciesFilter() {
        // Aqui va el elemento de lo que voy a utilizar
        WebElement vacanciesElement = wait.until(ExpectedConditions.elementToBeClickable(vacanciesFilter));
        // Accion que quiero que haga el elemento
        vacanciesElement.click();
    }
}
