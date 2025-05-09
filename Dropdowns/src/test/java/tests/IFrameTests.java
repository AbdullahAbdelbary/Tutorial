package tests;

import base.BaseTest;
import org.example.pages.DropdownPage;
import org.example.pages.IFramePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTests extends BaseTest {
    IFramePage iFramePage;

    @BeforeMethod
    public void setup() {
        iFramePage = new IFramePage(baseDriver);
    }

    @Test(priority = 3)
    public void testLogin() throws InterruptedException {
        iFramePage.iFrameValidation();
    }
}
