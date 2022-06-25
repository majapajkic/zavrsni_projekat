package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getSearchInputButton() {
        return driver.findElement(By.xpath("//*[contains(@class, 'v-input--hide-details')]/div"));
    }

    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-overlay__scrim")));
    }

    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-overlay__scrim")));
    }

    public WebElement getNewItemDialog() {
        return driver.findElement(By.xpath("//*[contains(@class,'v-input--has-state')]/div/div/div"));
    }

    public WebElement getDeleteButtonFromDeleteDialog() {
        return driver.findElement(By.xpath("//div[contains(@class,'rounded-0')]/div[2]/button[2]"));
    }

    public WebElement getSaveButtonFromEditDialog() {
        return driver.findElement(By.className("btnSave"));    //xpath://*[contains(@class,'btnSave')]"
    }

    public void waitForNumberOfRowsToBe(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver.findElement(By.xpath("//body//tr[" + (rowIndex + 1) + "]/td[" + (columnIndex + 1) + "]"));
    }

    public WebElement getEditButton(int index) {
        return driver.findElements(By.id("edit")).get(index);
    }

    public WebElement getDeleteButton(int index) {
        return driver.findElements(By.id("delete")).get(index);
    }

    public void waitForEditItemDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-data-table")));   //className="container--fluid"
    }

    public WebElement getEditItemDialog() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getCitiesButtonFromAdminMenu() {
        return driver.findElement(By.xpath("//*[contains(@class,'v-data-table-header')]/tr/th[6]"));
    }

}
