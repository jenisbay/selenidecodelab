package com.example.selenidecodelab.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {

    public void checkout(String firstname, String lastname, String postalCode) {
        CheckoutInformationPage.titleShouldBe(CheckoutInformationPage.title);
        CheckoutInformationPage.fillInformationForm(firstname, lastname, postalCode);

        CheckoutOverviewPage.titleShouldBe(CheckoutOverviewPage.title);
        CheckoutOverviewPage.clickFinishBtn();
    }

    private static class CheckoutInformationPage {

        static String title = "Checkout: Your Information";
        static SelenideElement titleField = $x("//span[@class='title']");

        static SelenideElement firstnameField = $(By.id("first-name"));
        static SelenideElement lastnameField = $(By.id("last-name"));
        static SelenideElement postalCodeField = $(By.id("postal-code"));

        static SelenideElement continueBtn = $(By.id("continue"));

        public static void fillInformationForm(String firstname, String lastname, String postalCode) {
            firstnameField.setValue(firstname);
            lastnameField.setValue(lastname);
            postalCodeField.setValue(postalCode);
            continueBtn.click();
        }

        public static void titleShouldBe(String name) {
            titleField.shouldHave(Condition.exactText(name));
        }

    }

    private static class CheckoutOverviewPage {

        static String title = "Checkout: Overview";
        static SelenideElement titleField = $x("//span[@class='title']");

        static SelenideElement finishBtn = $(By.id("finish"));

        public static void clickFinishBtn() {
            finishBtn.click();
        }

        public static void titleShouldBe(String name){
            titleField.shouldHave(Condition.exactText(name));
        }

    }

}
