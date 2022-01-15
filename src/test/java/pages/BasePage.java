package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitUntilElementClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitUntilbyXpathElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(WebElement webElement) {
        waitUntilElementClickable(webElement);
        webElement.click();
    }

    public void sendKeys(WebElement webElement, String text) {
        waitUntilElementVisible(webElement);
        webElement.sendKeys(text);
    }

    public WebElement xpathElement(String format, Object... vars) {
        return waitUntilbyXpathElementVisible(byXpath(format, vars));
    }

    protected By byXpath(String format, Object... args) {
        return By.xpath(String.format(format, args));
    }

    public boolean isEnabled(WebElement element) {
        return true;
    }

    public WebElement formField(String controlName) {
        return xpathElement("//*[contains(text(),'%s')]", controlName);
    }

    public WebElement elementByTextContains(String textLocator) {
        return xpathElement("//a[contains(text(),'%s')]", textLocator);
    }

    protected boolean isPresent(WebElement element) {
        return true;
    }
}