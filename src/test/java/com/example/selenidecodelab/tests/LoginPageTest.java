package com.example.selenidecodelab.tests;

import com.codeborne.selenide.testng.ScreenShooter;
import com.example.selenidecodelab.pages.CartPage;
import com.example.selenidecodelab.pages.CheckoutPage;
import com.example.selenidecodelab.pages.LoginPage;
import com.example.selenidecodelab.pages.ProductsPage;
import com.example.selenidecodelab.utils.UserDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenShooter.class})
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;

    public void login(String username, String password) {
        loginPage = new LoginPage();
        open("/");
        loginPage.login(username, password);

        productsPage = new ProductsPage();
        productsPage.titleShouldBe("Products");
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "getValidUsernameAndPassword")
    public void loginWithValidUsernameAndPassword(String username, String password) {
        login(username, password);

        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");

        productsPage.goToCart();

        CartPage cartPage = new CartPage();
        cartPage.titleShouldBe(cartPage.getTitle());
        cartPage.clickCheckoutBtn();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout("John", "Smith", "4456");

    }
}
