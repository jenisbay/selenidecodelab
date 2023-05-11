package com.example.selenidecodelab.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.example.selenidecodelab.utils.ConfigProvider;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {

    @BeforeMethod
    public void preConditions(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.baseUrl = ConfigProvider.BASE_URL;
        ScreenShooter.captureSuccessfulTests = true;
    }

    @AfterMethod
    public void postConditions(){
        WebDriverRunner.closeWebDriver();
    }


}
