package com.example.selenidecodelab.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    ElementsCollection items = $$x("//div[@class='cart_item']");

    SelenideElement titleField = $x("//span[@class='title']");

    SelenideElement checkoutBtn = $(By.id("checkout"));

    final String title = "Your Cart";

    public void clickCheckoutBtn(){
        checkoutBtn.shouldBe(visible).click();
    }

    public void titleShouldBe(String name){
        titleField.shouldHave(Condition.exactText(name));
    }

    public String getTitle(){
        return title;
    }

}
