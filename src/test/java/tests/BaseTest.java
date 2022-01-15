package tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.constants.Constants;


public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public Constants constants;


    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void classLevelSetup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        methodLevelSetup();
    }

    public void methodLevelSetup() {
        constants = new Constants(driver);
        loginPage = new LoginPage(driver);
        loginPage.goToURL().login("autotest", "autotest");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}