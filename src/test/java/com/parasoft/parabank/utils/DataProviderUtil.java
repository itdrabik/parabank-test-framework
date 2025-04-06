package com.parasoft.parabank.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"john", "demo"},
                {"admin", "wrong"},
                {"", ""}
        };
    }
}
