package com.example.selenidecodelab.utils;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider
    public static Object[][] getValidUsernameAndPassword(){
        return new Object[][]{
            {"standard_user", "secret_sauce"}
        };
    }

}
