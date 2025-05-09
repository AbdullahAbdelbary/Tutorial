package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class MultiplePages {
    WebDriver driver;
    @FindBy(linkText = "Click Here")
    WebElement clickHereButton;
    public MultiplePages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void multiplePagesValidation() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        // 4. حفظ الـ Window الحالي (الأساسي)
        String mainWindowHandle = driver.getWindowHandle();
        Thread.sleep(2000);
        clickHereButton.click();
        // 6. الحصول على كل الـ Window Handles المفتوحة
        Set<String> allWindowHandles = driver.getWindowHandles();
        // 7. التنقل بينهم
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // التبديل للنافذة الجديدة
                break;
            }
        }
        // 8. طباعة عنوان الصفحة الجديدة
        System.out.println("New Window Title: " + driver.getTitle());

        // 9. (اختياري) قفل النافذة الجديدة
       // driver.close();

        // 10. الرجوع للنافذة الأساسية
        driver.switchTo().window(mainWindowHandle);

        // 11. طباعة عنوان الصفحة الأساسية
        System.out.println("Main Window Title: " + driver.getTitle());
    }
}
