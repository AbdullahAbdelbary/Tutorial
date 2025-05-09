package org.example.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public void setImplicitWait(int timeInSeconds) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));

    }

    // Wait for element to be visible
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element to be clickable
    public WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String waitForAlertText(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true; // تم العثور على Alert
        } catch (NoAlertPresentException e) {
            return false; // لا يوجد Alert
        }
    }

    // General send keys with wait
    public void waitAndSendKeys(WebElement element, String text) {
        waitForVisibility(element).sendKeys(text);
    }

    // General click with wait
    public void waitAndClick(WebElement element) {
        waitForClickability(element).click();
    }
}
