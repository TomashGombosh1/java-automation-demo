package tests;

import common.ProjectConfig;
import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;


public class BaseTest {

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    public static WebDriver driver;

    @BeforeMethod
    public void setupTestRun() {
        driver = new DriverFactory().getDriver();
        initPages();
        driver.get(ProjectConfig.getBaseUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /**
    * Method of initialization page for pages packages
     * should be write as for Example
     * loginPage = new LoginPage(driver);
     **/
    private void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

}
