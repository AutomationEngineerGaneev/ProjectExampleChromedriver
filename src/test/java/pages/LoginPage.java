package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    String baseURL = "";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='IconSignOut']")
    private WebElement signOutButton;

    @Step("Авторизоваться")
    public LoginPage login(String username, String password) {
        sendKeys(loginField, username);
        sendKeys(passwordField, password);
        click(signInButton);
        return this;
    }

    @Step("Выйти из системы")
    public void clickSignOut() {
        click(signOutButton);
    }

    @Step("Перейти по URL")
    public LoginPage goToURL() {
        driver.get(baseURL);
        return this;
    }
}