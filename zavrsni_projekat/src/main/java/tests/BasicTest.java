package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.io.FileHandler;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected NavPage navPage;
    protected CitiesPage citiesPage;
    protected PopUpPage popUpPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        navPage = new NavPage(driver);
        citiesPage = new CitiesPage(driver);
        popUpPage = new PopUpPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/main/resources/screenshot.png");
        FileHandler.copy(srcFile, destFile);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

