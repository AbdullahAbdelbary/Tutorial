package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MouseHoverPage {
    WebDriver driver;
    @FindBy(xpath = "(//div[@class='figure'])[1]")
    WebElement imageElement ;
    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void mouseHoverValidation() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers"); // موقع فيه قائمة ينفع نعمل عليها hover
        Actions actions = new Actions(driver);
        // 6. تنفيذ حركة الماوس hover
        actions.moveToElement(imageElement ).perform();
        Thread.sleep(2000);
    }
}

