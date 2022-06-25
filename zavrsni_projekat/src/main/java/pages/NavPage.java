package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//*[@href='/']"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("//*[@href='/about']"));
    }

    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//*[@href='/login']"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnAdmin')]"));
    }

    public WebElement getCitiesLinkFromMenu() {
        return driver.findElement(By.xpath("//*[@href='/admin/cities']"));
    }

    public WebElement getUsersLinkFromMenu() {
        return driver.findElement(By.xpath("//*[@href='/admin/users']"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//*[@href='/signup']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'secondary')]"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnLogout')]"));
    }

    public WebElement getHeaderText() {
        return driver.findElement(By.xpath("//*[contains(@class,'text-xs-center')]/h1"));
    }

    public WebElement getSelectLanguageButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnLocaleActivation')]"));
    }

    public WebElement getENbuttonFromMenu() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-menu__content')]/div/div[1]"));
    }

    public WebElement getESbuttonFromMenu() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-menu__content')]/div/div[2]"));
    }

    public WebElement getFRbuttonFromMenu() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-menu__content')]/div/div[3]"));
    }

    public WebElement getCNbuttonFromMenu() {
        return driver.findElement(By.xpath("//div[contains(@class,'v-menu__content')]/div/div[4]"));
    }
}
