package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpPage {
    private WebDriver driver;

    public PopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUpToBeVisible() {        //user does not exists
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public WebElement getTextFromPopupDialog() {        //user does not exists
        return driver.findElement(By.xpath("//*[contains(text(),'User does not exists')]"));
    }

    public WebElement getCloseButtonFromPopUp() {       //user does not exists
        return driver.findElement(By.xpath("//*[contains(@class,'v-snack__content')]/button"));
    }

    public void waitForVerifyYourAccountDialog() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'v-dialog--active')]/div")));
    }

    public WebElement getHeaderFromDialogVerifyYourAccunt() {       //important:verify your account
        return driver.findElement(By.className("v-card__title"));
    }

    public WebElement getCloseButtonFromDialogVerifyYourAccunt() {
        return driver.findElement(By.className("btnClose"));
    }

    public WebElement getDeleteButtonFromWarningDialog() {
        return driver.findElement(By.xpath("//*[contains(@class,'rounded')]/div/button[2]"));
    }

    public void waitForSaveSuccessfulyDialogToShowup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public WebElement getTextFromSuccessfulySavedDialog() {
        return driver.findElement(By.className("v-snack__content"));
    }

}