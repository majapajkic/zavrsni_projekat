package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEnterNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEnterEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getEnterPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPassworField() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getSingupButton() {
        return driver.findElement(By.xpath("//button[contains(@class,'v-btn--contained')]"));
    }
}

