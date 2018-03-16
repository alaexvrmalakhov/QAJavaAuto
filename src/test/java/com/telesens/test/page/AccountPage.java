package com.telesens.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getSignOutText() {
        return signOutLink.getText();
    }
}
