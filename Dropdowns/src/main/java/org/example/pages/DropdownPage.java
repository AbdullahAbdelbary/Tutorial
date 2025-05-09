package org.example.pages;

import org.example.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
public class DropdownPage {
    WebDriver driver;
    @FindBy(xpath = "//select")
    WebElement dropdownElement;
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void dropdownValidation()
    {
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Argentina");
        System.out.println("تم اختيار: " + dropdown.getFirstSelectedOption().getText());
    }
}

