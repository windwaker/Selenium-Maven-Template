package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;
import static org.assertj.core.api.Assertions.*;

public class GoogleExample extends DriverFactory {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @BeforeClass
    public void setup()
    {
    }

    @Test(enabled = true)
    public void googleCheeseExample() {

        WebDriver driver = getDriver();

        driver.navigate().to("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        clearAndSend(element, "webdriver");

        element.submit();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("webdriver");
            }
        });

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        wait.until((WebDriver d) -> {
//            return d.getTitle().toLowerCase().startsWith("webdriver");
//        });

        Assert.assertTrue(driver.getTitle().contains("webdriver"));

    }

    @Test(enabled = true)
    public void lateLoadingExample() {

        WebDriver driver = getDriver();
        driver.navigate().to("http://the-internet.dev/dynamic_loading/2");
        //driver.navigate().to("http://the-internet.herokuapp.com/dynamic_loading/2");


        // predicate for start button
        //Predicate<String> containsElementById = (String s) -> driver.findElement(By.id(s)).isDisplayed();

        WebElement start = driver.findElement(By.id("start")).findElement(By.tagName("button"));

        System.out.println("before");

        start.click();

        System.out.println("after");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
//            return d.findElement(By.id("start")).isDisplayed();
//        });
//
//        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
//            return containsElementById.test("start");
//        });


        // Wait for the page to load, timeout after 10 seconds
        //(new WebDriverWait(driver, 10)).until((WebDriver d) -> d.findElement(By.id("start"))).click();

//        (new WebDriverWait(driver, 10)).until((WebDriver d) ->
//             d.findElement(By.id("start"))
//        ).click();

//        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
//            return d.findElement(By.id("finish")).isDisplayed();
//        });

    }

//    public static Predicate<String> isAdultFemale() {
//        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
//    }

    @Test(enabled = true)
    public void tablesExample(){

        WebDriver driver = getDriver();
        driver.get("http://the-internet.dev/tables");

        Predicate<String> isTitleCorrect = title -> driver.getTitle().equalsIgnoreCase(title);

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));

        int total = (int) checkboxes
            .stream()
                .filter(c -> c.isSelected() == true)
                    .count();
                    //.map(WebElement::isSelected)
                      //  .forEach(System.out::println);

        // Big data, combine with continuous scrolling

        Assert.assertTrue(isTitleCorrect.test("The Internet"), "wrong title");

        Assert.assertEquals(total, 4);
    }

    @Test(enabled = false)
    public void scroll() throws InterruptedException{
        WebDriver driver = getDriver();
        driver.get("http://architectryan.com/2012/10/02/add-to-the-path-on-mac-os-x-mountain-lion/#.UxER1_R_vR0");
        System.out.println("Page title is: " + driver.getTitle());
        Thread.sleep(5000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("return window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(5000);
    }

    private void clearAndSend(WebElement element, String s) {
        element.clear();
        element.sendKeys(s);
    }
}