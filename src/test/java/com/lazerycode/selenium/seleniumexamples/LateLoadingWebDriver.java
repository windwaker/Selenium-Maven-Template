package com.lazerycode.selenium.seleniumexamples;

import com.lazerycode.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by colmh on 03/06/2015.
 */
public class LateLoadingWebDriver extends DriverFactory {

    WebDriverWait wait;
    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        driver = getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test(enabled = true)
    public void lateLoadingExample() throws InterruptedException {

        driver.navigate().to("http://the-internet.dev/dynamic_loading/2");

        WebElement start = driver.findElement(By.id("start")).findElement(By.tagName("button"));

        start.click();

        Assert.assertTrue(driver.findElement(By.id("finish")).isDisplayed());

        //Thread.sleep(10000);


        // Create a class and an instance of it just to get at the function :-(
        // Use IDE shortcut
//        (new WebDriverWait(driver, 10, 1000)).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                return d.findElement(By.id("finish")).isDisplayed();
//            }
//        });

//        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
//            return d.findElement(By.id("finish")).isDisplayed();
//        });

        wait.until((WebDriver d) -> {
            // lambda returns a boolean, remember this for later
            return d.findElement(By.id("finish")).isDisplayed();
        });

        // Bonus feature

        //wait.until(elementIsDisplayed("finish"));
    }

    private ExpectedCondition<Boolean> elementIsDisplayed(final String value){
        return d -> d.findElement(By.id(value)).isDisplayed();
    }

    // next level is pass a lambda as an arg

}
