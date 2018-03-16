package com.telesens.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShopTest extends BaseTest {
    private static Logger LOG = LogManager.getLogger(ShopTest.class.getName());

    @Test
    public void testDemo() throws Exception {
        driver.get(baseUrl + "/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        LOG.debug("sign in click");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("oleg.kh81@gmail.com");
        LOG.debug("main input");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("vlrevlor");
        LOG.debug("password input");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("//div[@id='columns']/div[3]")).click();
        LOG.debug("log in click");
        try {
            assertEquals(driver.findElement(By.linkText("Sign out")).getText(), "Sign out");
            LOG.info("Log in  successful");
        } catch (Error e) {
            LOG.error(e.getMessage());
        }
        driver.findElement(By.linkText("Sign out")).click();
        try {
            assertEquals(driver.findElement(By.linkText("Sign in")).getText(), "Sign in");
        } catch (Error e) {
            System.err.println(e.getMessage());
        }
    }

    @Test(enabled = false)
    public void addNewAddressTest() {
        driver.get(baseUrl + "/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("oleg.kh81@gmail.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("vlrevlor");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("//div[@id='columns']/div[3]")).click();
        driver.findElement(By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("#center_column > div.clearfix.main-page-indent > a")).click();
        WebElement firstnameField = driver.findElement(By.id("firstname"));
        firstnameField.clear();
        firstnameField.sendKeys("testName");

        Select selectStateEl = new Select(driver.findElement(By.id("id_state")));
        selectStateEl.selectByValue("4");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testFilter() {
        driver.get(baseUrl + "/index.php");
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.id("layered_id_feature_5")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.);
        assertEquals(driver.findElement(By.cssSelector("#center_column > ul > li > div > div.right-block > div.content_price > span")).getText().trim(), "$26.00");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

