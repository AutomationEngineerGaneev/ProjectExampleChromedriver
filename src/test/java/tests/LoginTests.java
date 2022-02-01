package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;


@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    @Test(priority = 1, description = "Выход из системы")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Выход из системы")
    @Story("Выход из системы")
    public void checkBySignOutTest() {
        loginPage.clickSignOut();
    }
}