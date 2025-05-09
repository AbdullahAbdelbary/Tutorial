package tests;

import base.BaseTest;
import org.example.pages.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTest {

    DropdownPage dropdownPage;

    @BeforeMethod
    public void setup() {
        dropdownPage = new DropdownPage(baseDriver);
    }

    @Test(priority = 2)
    public void testLogin(){
        dropdownPage.dropdownValidation();
    }
}