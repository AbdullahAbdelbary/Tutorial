package tests;

import base.BaseTest;
import org.example.pages.MouseHoverPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHoverTests extends BaseTest {
    MouseHoverPage mouseHoverPage;

    @BeforeMethod
    public void setup() {
        mouseHoverPage = new MouseHoverPage(baseDriver);
    }

    @Test(priority = 4)
    public void testLogin() throws InterruptedException {
        mouseHoverPage.mouseHoverValidation();
    }
}
