package base;
import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver baseDriver;

    @BeforeSuite
    public void sdfdsf(){
        baseDriver = new ChromeDriver();
        baseDriver.manage().window().maximize();
        baseDriver.get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void takeScreenshotIfFail(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.capture(baseDriver, result.getName());
        }
    }

    /*
    @AfterTest
    public void tearDown() {
        getDriver().quit();
        baseDriver.remove();
    }
    */

}
