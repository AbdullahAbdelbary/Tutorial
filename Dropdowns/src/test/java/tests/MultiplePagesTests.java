package tests;

import base.BaseTest;
import org.example.pages.MouseHoverPage;
import org.example.pages.MultiplePages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiplePagesTests extends BaseTest {

    MultiplePages multiplePages;

    @BeforeMethod
    public void setup() {
        multiplePages = new MultiplePages(baseDriver);
    }

    @Test(priority = 5)
    public void testLogin() throws InterruptedException {
        multiplePages.multiplePagesValidation();
    }
}