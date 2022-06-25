package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest {

    @Test(priority = 10)
    public void visitsTheLoginPage() {
        navPage.getSelectLanguageButton().click();
        navPage.getENbuttonFromMenu().click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain /login.");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        String actualEmailType = driver.findElement(By.id("email")).getAttribute("type");
        Assert.assertEquals(
                actualEmailType,
                "email",
                "[ERROR] Email enter field is not type email.");
        String actualPasswordType = driver.findElement(By.id("password")).getAttribute("type");
        Assert.assertEquals(
                actualPasswordType,
                "password",
                "[ERROR] Password field is not type password.");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() {
        navPage.getLoginButton().click();
        loginPage.getEnterEmail().click();
        loginPage.getEnterEmail().sendKeys(" non-existing-user@gmal.com");
        loginPage.getEnterPassword().click();
        loginPage.getEnterPassword().sendKeys("password123");
        loginPage.getLoginButton().click();
        popUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(
                popUpPage.getTextFromPopupDialog().getText().contains("User does not exists"),
                "[ERROR] There is no message 'User does not exist'.");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain /login.");
    }

    @Test(priority = 40)
    public void displayErrorsWhenPasswordIsWrong() {
        navPage.getLoginButton().click();
        loginPage.getEnterEmail().click();
        loginPage.getEnterEmail().sendKeys("admin@admin.com");
        loginPage.getEnterPassword().click();
        loginPage.getEnterPassword().sendKeys("password123");
        loginPage.getLoginButton().click();
        popUpPage.waitForPopUpToBeVisible();

        Assert.assertTrue(
                popUpPage.getTextFromPopupDialog().getText().contains("Wrong password"),
                "[ERROR] There is no message 'Wrong password'.");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain /login.");
    }

    @Test(priority = 50)
    public void login() {
        navPage.getLoginButton().click();
        loginPage.getEnterEmail().click();
        loginPage.getEnterEmail().sendKeys("admin@admin.com");
        loginPage.getEnterPassword().click();
        loginPage.getEnterPassword().sendKeys("12345");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/home"),
                "[ERROR] Current url does not contain /home.");
    }

    @Test(priority = 60)
    public void logout() {
        Assert.assertTrue(
                navPage.getLogOutButton().isDisplayed(),
                "[ERROR] There is no 'log out' button.");
        navPage.getLogOutButton().click();
    }

}
