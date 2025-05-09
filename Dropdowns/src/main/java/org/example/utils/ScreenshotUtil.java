package org.example.utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshots/" + testName + "_" + timestamp + ".png";
        File destFile = new File(fileName);

        try {
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(scrFile.toPath(), destFile.toPath());
            System.out.println("📸 Screenshot saved: " + fileName);
        } catch (IOException e) {
            System.out.println("⚠️ Couldn't save screenshot: " + e.getMessage());
        }
    }
}

