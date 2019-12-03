package tests;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {

    @Test(description = "C12345 Demo test: User can login", priority = 1)
    public void demoTest(){
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.login(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Login page should be displayed");
        dashboardPage.searchEmployee();
        dashboardPage.collectData();
    }

    @Test(description = "C12345 Demo test: User can login", priority = 2)
    public void demoFailedTest(){
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.login(Config.BASE_USERNAME, "Config.BASE_PASSWORD");
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Login page should be displayed");
        dashboardPage.searchEmployee();
        dashboardPage.collectData();
    }
}
