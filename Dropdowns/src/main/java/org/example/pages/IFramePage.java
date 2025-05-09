package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class IFramePage {
    WebDriver driver;
    @FindBy(xpath = "//input[@type='text']")
    WebElement inputBox;
    public IFramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void iFrameValidation() throws InterruptedException {
        // 1. فتح الموقع
        driver.get("https://demo.automationtesting.in/Frames.html");

        // 2. الدخول على الـ iframe البسيط (Single Iframe)
        driver.switchTo().frame("singleframe");

        inputBox.sendKeys("Abdullah EL-Turky");

        // 4. الرجوع للصفحة الرئيسية
        driver.switchTo().defaultContent();
    }
}
