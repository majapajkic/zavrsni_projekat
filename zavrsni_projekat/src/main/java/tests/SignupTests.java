package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
    @Test(priority = 10)
    public void visitsTheSignUpPage() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Current url does not contain /signup.");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getSignUpButton().click();
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
        String confirmPasswordType = driver.findElement(By.id("confirmPassword")).getAttribute("type");
        Assert.assertEquals(
                confirmPasswordType,
                "password",
                "[ERROR] Confirm password field is not type password.");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExist() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Current url does not contain /signup.");
        signupPage.getEnterNameField().click();
        signupPage.getEnterNameField().sendKeys("Another User");
        signupPage.getEnterEmailField().click();
        signupPage.getEnterEmailField().sendKeys("admin@admin.com");
        signupPage.getEnterPasswordField().click();
        signupPage.getEnterPasswordField().sendKeys("12345");
        signupPage.getConfirmPassworField().click();
        signupPage.getConfirmPassworField().sendKeys("12345");
        signupPage.getSingupButton().click();
        popUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(
                popUpPage.getTextFromPopupDialog().getText().contains("E-mail already exists"),
                "[ERROR] There is no message 'E-mail already exists'.");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Current url does not contain /signup.");
    }

    @Test(priority = 40)
    public void signup() {
        navPage.getSignUpButton().click();
        signupPage.getEnterNameField().click();
        signupPage.getEnterNameField().sendKeys("Ime i prezime polaznika");
        signupPage.getEnterEmailField().click();
        signupPage.getEnterEmailField().sendKeys("ime.prezime@itbootcamp.rs");
        signupPage.getEnterPasswordField().click();
        signupPage.getEnterPasswordField().sendKeys("12345");
        signupPage.getConfirmPassworField().click();
        signupPage.getConfirmPassworField().sendKeys("12345");
        signupPage.getSingupButton().click();
        driver.navigate().to(baseUrl + "/home");
        Assert.assertTrue(
                popUpPage.getTextFromPopupDialog().getText().contains(" IMPORTANT: Verify your account"),
                "[ERROR] There is no message ' IMPORTANT: Verify your account'.");
        popUpPage.getCloseButtonFromDialogVerifyYourAccunt().click();
        navPage.getLogOutButton().click();

    }
}



