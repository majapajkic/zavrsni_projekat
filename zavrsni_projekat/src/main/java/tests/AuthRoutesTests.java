package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;

public class AuthRoutesTests extends BasicTest {
    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/home");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain '/login'.");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthrnticated() {
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain '/login'.");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + " /admin/cities");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain '/login'.");
    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + " /admin/users");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Current url does not contain '/login'.");
    }

}