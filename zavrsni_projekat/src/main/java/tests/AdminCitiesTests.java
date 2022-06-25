package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        navPage.getSignUpButton().click();
        loginPage.getEnterEmail().click();
        loginPage.getEnterEmail().sendKeys("admin@admin.com");
        loginPage.getEnterPassword().click();
        loginPage.getEnterPassword().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromMenu().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Current url does not contain /admin/cities.");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromMenu().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        String actualCitiesType = driver.findElement(By.id("name")).getAttribute("type");
        Assert.assertEquals(
                actualCitiesType,
                "text",
                "[ERROR] Enter city field is not type text.");

    }

    @Test(priority = 30)
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromMenu().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        citiesPage.getNewItemDialog().click();
        citiesPage.getNewItemDialog().sendKeys("Maja Pajkic's city");
        citiesPage.getSaveButtonFromEditDialog().click();
        popUpPage.waitForSaveSuccessfulyDialogToShowup();

        Assert.assertTrue(
                popUpPage.getTextFromSuccessfulySavedDialog().getText().contains("Saved successfully"),
                "[ERROR] There is no message 'Saved successfully'.");
    }

    @Test(priority = 40)
    public void editCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromMenu().click();
        citiesPage.getSearchInputButton().click();
        citiesPage.getSearchInputButton().sendKeys("Maja Pajkic's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButton(1);
        citiesPage.getEditItemDialog().click();
        citiesPage.getEditItemDialog().sendKeys(Keys.CONTROL, "a");
        citiesPage.getEditItemDialog().sendKeys("Maja Pajkic's city Edited");
        citiesPage.getSaveButtonFromEditDialog().click();
        popUpPage.waitForSaveSuccessfulyDialogToShowup();
        Assert.assertTrue(
                popUpPage.getTextFromSuccessfulySavedDialog().getText().contains("Saved successfully"),
                "[ERROR] There is no message 'Saved successfully'.");
    }

    @Test(priority = 50)
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromMenu().click();
        citiesPage.getSearchInputButton().click();
        citiesPage.getSearchInputButton().sendKeys("Maja Pajkic's city Edited");
        citiesPage.waitForNumberOfRowsToBe(1);

        Assert.assertTrue(
                citiesPage.getTableCell(0, 2).getText().equals("Maja Pajkic's city Edited"),
                "First row, column Name don't have text 'Maja Pajkic's city Edited' ");
    }

    @Test(priority = 60)
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromMenu().click();
        citiesPage.getSearchInputButton().click();
        citiesPage.getSearchInputButton().sendKeys("Maja Pajkic's city Edited");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(
                citiesPage.getTableCell(0, 2).getText().equals("Maja Pajkic's city Edited"),
                "First row, column Name don't have text 'Maja Pajkic's city Edited' ");
        citiesPage.getDeleteButton(0).click();
        popUpPage.getDeleteButtonFromWarningDialog().click();
    }


}
