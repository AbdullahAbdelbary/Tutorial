
package tests;


import base.BaseTest;
import org.example.pages.LoginPage;
import org.example.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTests extends BaseTest {

    LoginPage loginPage; // لم يتم تهيئته هنا

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(baseDriver); // قم بتمرير driver أثناء الإنشاء
    }

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = "D:\\Testing\\Technical\\Automation\\Projects\\Dropdowns\\excelData.xlsx";
        return ExcelUtils.readExcelData(filePath, "Sheet1");
    }

    @Test(priority = 1, dataProvider = "LoginData")
    public void testLogin(String username, String password, String testType) throws InterruptedException {
        loginPage.loginValidation(username,password,testType);
    }
}


/*
    package tests;


import base.BaseTest;
import org.example.pages.LoginPage;
import org.example.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTests extends BaseTest {

    LoginPage loginPage; // لم يتم تهيئته هنا

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(baseDriver); // قم بتمرير driver أثناء الإنشاء
    }

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = "D:\\Testing\\Technical\\Automation\\Projects\\Dropdowns\\excelData.xlsx";
        return ExcelUtils.readExcelData(filePath, "Sheet1");
    }

    @Test(priority = 16, dataProvider = "LoginData")
    public void testLogin(String username, String password, String testType) throws InterruptedException {
        String alertText = " ";
        switch (testType) {
            case "valid":
                System.out.println("⚠️ اختبار تسجيل دخول لمستخدم موجود وكلمة سر صحيحه: " + username + " --- " + password);
                loginPage.login(username, password);
                Assert.assertTrue(true);
                System.out.println("✅ تسجيل الدخول ناجح للمستخدم: " + username);
                break;
            case "invalidUsername":
                System.out.println("⚠️ اختبار تسجيل دخول لمستخدم غير موجود: " + username);
                loginPage.logout();
                loginPage.login(username, password);
                alertText = loginPage.getAlertText();
                if (alertText.equals("User does not exist."))
                    System.out.println("✅ الاختبار ناجح: تم رفض تسجيل مستخدم غير موجود");
                else System.out.println("❌ الاختبار فشل: تم تسجيل مستخدم غير موجود");
                Assert.assertEquals(alertText, "User does not exist.");
                loginPage.clearLoginFields();
                break;
            case "invalidPassword":
                System.out.println("⚠️ اختبار تسجيل دخول بكلمة سر غير صحيحه: " + username);
                loginPage.loginSecondTime(username,password);
                loginPage.getAlertText();
                if (alertText.equals("Wrong password."))
                    System.out.println("✅ الاختبار ناجح: تم رفض تسجيل دخول بكلمة سر غير صحيحه");
                else System.out.println("❌ الاختبار فشل: تم تسجيل مستخدم غير موجود");
                Assert.assertEquals(alertText, "Wrong password.");
                loginPage.clearLoginFields();
                break;

            case "invalidUsernameFormat":
                System.out.println("⚠️ اختبار تسجيل دخول باسم مستخدم بفورمات غير صحيح: " + username);
                loginPage.loginSecondTime(username,password);
                if(loginPage.alertCheck())
                {
                    alertText = loginPage.getAlertText();
                    Assert.assertEquals(alertText,"Login Successful.");
                    if(alertText.equals("Login Successful.")) System.out.println("✅ الأختبار نجح: تم رفض تسجيل دخول باسم مستخدم بفورمات غير صحيح");
                    else  System.out.println("❌ الأختبار فشل: تم تسجيل دخول بأسم مستخدم بفورمات غير صحيح");
                    loginPage.clearLoginFields();
                }
                else
                {
                    Assert.fail();
                    System.out.println("❌ الأختبار فشل: تم تسجيل دخول باسم مستخدم بفورمات غير صحيح");
                }
                break;

            case "invalidPasswordFormat":
                System.out.println("⚠️ اختبار تسجيل دخول بكلمة سر بفورمات غير صحيح: " + username);
                loginPage.logout();
                loginPage.login(username, password);
                if(loginPage.alertCheck())
                {
                    alertText = loginPage.getAlertText();
                    if(alertText.equals("Login Successful.")) System.out.println("✅ الأختبار نجح: تم رفض تسجيل دخول بكلمة سر بفورمات غير صحيح");
                    else  System.out.println("❌ الأختبار فشل: تم تسجيل دخول بكلمة سر بفورمات غير صحيح");
                    Assert.assertEquals(alertText,"Login Successful.");
                    loginPage.clearLoginFields();
                }
                else
                {
                    Assert.fail();
                    System.out.println("❌ الأختبار فشل: تم تسجيل دخول بكلمة سر بفورمات غير صحيح");
                    loginPage.logout();
                }
                break;

            default:
                System.out.println("❌ نوع الاختبار غير معروف: " + testType);
                Assert.fail("TestType غير معرف في البيانات!");
                break;
        }
    }
}
*/