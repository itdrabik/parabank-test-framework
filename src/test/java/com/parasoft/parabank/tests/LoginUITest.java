package com.parasoft.parabank.tests;

import com.parasoft.parabank.base.BaseTest;
import com.parasoft.parabank.pages.LoginPage;
import com.parasoft.parabank.utils.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUITest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtil.class)
    public void testLoginUI(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        boolean validCreds = "john".equals(username) && "demo".equals(password);

        if (validCreds) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should succeed for valid credentials");
        } else {
            Assert.assertFalse(loginPage.isLoginSuccessful(), "Login should not succeed for invalid credentials");
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be shown for invalid login");
        }
    }
}
