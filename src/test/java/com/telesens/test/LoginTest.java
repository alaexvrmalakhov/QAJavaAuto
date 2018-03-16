package com.telesens.test;

import com.telesens.test.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testLogin() {
        driver.get(baseUrl + "/index.php");
        String signOutText =
                new HomePage(driver)
                .goToLoginPage()
                .inputLogin("oleg.kh81@gmail.com")
                .inputPassword("vlrevlor")
                .submitLogin()
                .getSignOutText();

//        LoginPage loginPage = homePage.goToLoginPage();
//        loginPage.inputLogin("oleg.kh81@gmail.com");
//        loginPage.inputPassword("vlrevlor");
//        AccountPage accountPage = loginPage.submitLogin();
//        String signOutText = accountPage.getSignOutText();

        Assert.assertEquals(signOutText, "Sign out");
    }
}
