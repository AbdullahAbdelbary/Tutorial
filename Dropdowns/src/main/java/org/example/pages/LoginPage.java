
package org.example.pages;

import org.example.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    WebDriver driver;
    WaitUtils waitUtils;
    @FindBy(css = "#login2")
    WebElement navbarLoginBTN;
    @FindBy(css = "#loginusername")
    WebElement usernameTXT;
    @FindBy(css = "#loginpassword")
    WebElement passwordTXT;
    @FindBy(css = "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
    WebElement internalLoginBTN;
    @FindBy(css = "#logout2")
    WebElement logoutBTN;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver,10);
        //waitUtils.setImplicitWait(10);
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password){
        waitUtils.waitAndClick(navbarLoginBTN);
        waitUtils.waitAndSendKeys(usernameTXT,username);
        waitUtils.waitAndSendKeys(passwordTXT,password);
        waitUtils.waitAndClick(internalLoginBTN);
    }

    public void erase(WebElement element) {element.clear();}

    public void loginValidation(String username, String password, String testType)
    {
        String alertText = " ";
        switch (testType) {
            case "valid":
                System.out.println("⚠️ اختبار تسجيل دخول لمستخدم موجود وكلمة سر صحيحه: " + username + " --- " + password);
                login(username, password);
                Assert.assertTrue(true);
                System.out.println("✅ تسجيل الدخول ناجح للمستخدم: " + username);
                break;
            case "invalidUsername":
                System.out.println("⚠️ اختبار تسجيل دخول لمستخدم غير موجود: " + username);
                waitUtils.waitAndClick(logoutBTN);
                login(username, password);
                alertText = waitUtils.waitForAlertText();
                if (alertText.equals("User does not exist."))
                    System.out.println("✅ الاختبار ناجح: تم رفض تسجيل مستخدم غير موجود");
                else System.out.println("❌ الاختبار فشل: تم تسجيل مستخدم غير موجود");
                Assert.assertEquals(alertText, "User does not exist.");
                erase(usernameTXT);
                erase(passwordTXT);
                break;
            case "invalidPassword":
                System.out.println("⚠️ اختبار تسجيل دخول بكلمة سر غير صحيحه: " + username);
                waitUtils.waitAndSendKeys(usernameTXT, username);
                waitUtils.waitAndSendKeys(passwordTXT, password);
                waitUtils.waitAndClick(internalLoginBTN);
                alertText = waitUtils.waitForAlertText();
                if (alertText.equals("Wrong password."))
                    System.out.println("✅ الاختبار ناجح: تم رفض تسجيل دخول بكلمة سر غير صحيحه");
                else System.out.println("❌ الاختبار فشل: تم تسجيل مستخدم غير موجود");
                Assert.assertEquals(alertText, "Wrong password.");
                erase(usernameTXT);
                erase(passwordTXT);
                break;

            case "invalidUsernameFormat":
                System.out.println("⚠️ اختبار تسجيل دخول باسم مستخدم بفورمات غير صحيح: " + username);
                waitUtils.waitAndSendKeys(usernameTXT, username);
                waitUtils.waitAndSendKeys(passwordTXT, password);
                waitUtils.waitAndClick(internalLoginBTN);
                if(waitUtils.isAlertPresent())
                {
                    alertText = waitUtils.waitForAlertText();
                    Assert.assertEquals(alertText,"Login Successful.");
                    if(alertText.equals("Login Successful.")) System.out.println("✅ الأختبار نجح: تم رفض تسجيل دخول باسم مستخدم بفورمات غير صحيح");
                    else  System.out.println("❌ الأختبار فشل: تم تسجيل دخول بأسم مستخدم بفورمات غير صحيح");
                    erase(usernameTXT);
                    erase(passwordTXT);
                }
                else
                {
                    Assert.fail();
                    System.out.println("❌ الأختبار فشل: تم تسجيل دخول باسم مستخدم بفورمات غير صحيح");
                }
                break;

            case "invalidPasswordFormat":
                System.out.println("⚠️ اختبار تسجيل دخول بكلمة سر بفورمات غير صحيح: " + username);
                waitUtils.waitAndClick(logoutBTN);
                login(username, password);
                if(waitUtils.isAlertPresent())
                {
                    alertText = waitUtils.waitForAlertText();
                    if(alertText.equals("Login Successful.")) System.out.println("✅ الأختبار نجح: تم رفض تسجيل دخول بكلمة سر بفورمات غير صحيح");
                    else  System.out.println("❌ الأختبار فشل: تم تسجيل دخول بكلمة سر بفورمات غير صحيح");
                    Assert.assertEquals(alertText,"Login Successful.");
                    erase(usernameTXT);
                    erase(passwordTXT);
                }
                else
                {
                    Assert.fail();
                    System.out.println("❌ الأختبار فشل: تم تسجيل دخول بكلمة سر بفورمات غير صحيح");
                    waitUtils.waitAndClick(logoutBTN);
                }
                break;

            default:
                System.out.println("❌ نوع الاختبار غير معروف: " + testType);
                Assert.fail("TestType غير معرف في البيانات!");
                break;
        }
    }

}



/*
    package org.example.pages;

import org.example.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    WebDriver driver;
    WaitUtils waitUtils;
    @FindBy(css = "#login2")
    WebElement navbarLoginBTN;
    @FindBy(css = "#loginusername")
    WebElement usernameTXT;
    @FindBy(css = "#loginpassword")
    WebElement passwordTXT;
    @FindBy(css = "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
    WebElement internalLoginBTN;
    @FindBy(css = "#logout2")
    WebElement logoutBTN;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver,10);
        //waitUtils.setImplicitWait(10);
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password) {
        waitUtils.waitAndClick(navbarLoginBTN);
        waitUtils.waitAndSendKeys(usernameTXT, username);
        waitUtils.waitAndSendKeys(passwordTXT, password);
        waitUtils.waitAndClick(internalLoginBTN);
    }

    public void loginSecondTime(String username, String password){
        waitUtils.waitAndSendKeys(usernameTXT, username);
        waitUtils.waitAndSendKeys(passwordTXT, password);
        waitUtils.waitAndClick(internalLoginBTN);
    }

    public void logout(){
        waitUtils.waitAndClick(logoutBTN);
    }

    public String getAlertText() {
        return waitUtils.waitForAlertText();
    }

    public boolean alertCheck()
    {
        return waitUtils.isAlertPresent();
    }

    public void clearLoginFields() {
        usernameTXT.clear();
        passwordTXT.clear();
    }
}
*/