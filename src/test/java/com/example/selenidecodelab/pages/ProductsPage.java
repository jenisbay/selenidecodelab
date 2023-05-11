package com.example.selenidecodelab.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    SelenideElement title = $x("//span[contains(text(),'Products')]");

    ElementsCollection items = $$x("//div[@class='inventory_item']");

    SelenideElement shoppingCartIcon = $x("//a[@class='shopping_cart_link']");

    public void titleShouldBe(String value) {
        title.shouldHave(exactText(value));
    }

    public void addToCart(String name) {
        for (SelenideElement element : items) {
            if (element.find(".inventory_item_name").getText().equals(name)) {
                element.find(".btn.btn_primary.btn_small.btn_inventory").click();
            }
        }
    }

    public void goToCart() {
        shoppingCartIcon.shouldBe(visible).click();
    }

}
