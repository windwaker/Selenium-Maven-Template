package com.lazerycode.selenium.seleniumexamples;

import com.lazerycode.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by colmh on 03/06/2015.
 */
public class TablesWebDriver extends DriverFactory {

    @Test(enabled = true)
    public void tablesExample(){

        // Set Run-Configuration

        WebDriver driver = getDriver();
        driver.get("http://the-internet.dev/tables");

        Predicate<String> isTitleCorrect = title -> driver.getTitle().equalsIgnoreCase(title);

        Predicate<WebElement> isTicked = WebElement::isSelected;

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));

        int total = (int) checkboxes
                .stream()
                .filter(isTicked.negate())
                .count();

        // Big data, combine with continuous scrolling

        Assert.assertTrue(isTitleCorrect.test("The Internet"),
                    "The title is wrong, maybe you're on the wrong URL: " + driver.getCurrentUrl());
        Assert.assertEquals(total, 4);
    }
}
