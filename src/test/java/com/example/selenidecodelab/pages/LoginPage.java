package com.example.selenidecodelab.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement usernameField = $(By.id("user-name"));
    SelenideElement passwordField = $(By.id("password"));
    SelenideElement loginBtn = $(By.id("login-button"));

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginBtn.shouldBe(enabled).click();
    }
}
