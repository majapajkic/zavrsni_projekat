package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
    @Test(priority = 10)
    public void setLocaleToES() {
        navPage.getSelectLanguageButton().click();
        navPage.getESbuttonFromMenu().click();
        Assert.assertEquals
                (navPage.getHeaderText().getText(), "Página de aterrizaje",
                        "Header does not have text 'Página de aterrizaje' ");
    }

    @Test(priority = 20)
    public void setLocaleEN() {
        navPage.getSelectLanguageButton().click();
        navPage.getENbuttonFromMenu().click();
        Assert.assertEquals
                (navPage.getHeaderText().getText(), "Landing",
                        "Header does not have text 'Landing' ");
    }

    @Test(priority = 30)
    public void selectLocaleCN() {
        navPage.getSelectLanguageButton().click();
        navPage.getCNbuttonFromMenu().click();
        Assert.assertEquals
                (navPage.getHeaderText().getText(), "首页",
                        "Header does not have text '首页' ");
    }

    @Test(priority = 40)
    public void selectLocaleFR() {
        navPage.getSelectLanguageButton().click();
        navPage.getFRbuttonFromMenu().click();
        Assert.assertEquals
                (navPage.getHeaderText().getText(), "Page d'atterrissage",
                        "Header does not have text 'Page d'atterrissage' ");
    }
}
