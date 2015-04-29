package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Predicate;
import static org.assertj.core.api.Assertions.*;

public class GoogleExampleWebDriver extends DriverFactory {

    // https://github.com/windwaker/Selenium-Maven-Template

    @Test
    public void tableSortExample() {

        // http://tablesorter.com/docs/

    }

    @Test
    public void xExample() {

        // http://internetz.dev/dynamic_loading/2

    }

    @Test
    public void predicateExample() {

        Predicate p = (s) -> s.equals("carbery");

        if(p.test("carbery")){

        }
        else{
            Assert.fail("wrong division");
        }

    }


    @Test
    public void hardExample() {
        Employee e =new Employee(25, "Adam");
        assertThat(e.getAge()).as("Employee Age").isEqualTo(25);
    }

    @Test
    public void softExample() {
        Employee e =new Employee(25, "Adam");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(e.getAge()).as("Employee Age").isEqualTo(25);
        softly.assertAll(); // Don't forget this ...
    }

    @Test
    public void googleCheeseExample() {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void googleMilkExample() {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("Milk!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("milk!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }
}