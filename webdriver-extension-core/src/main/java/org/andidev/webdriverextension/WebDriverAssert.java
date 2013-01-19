package org.andidev.webdriverextension;

import java.util.List;
import static org.andidev.webdriverextension.WebDriverBot.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

// TODO: Change methods to wrap WebDriverBot mthods instead of using webEkents calls, e.g. Assert.assertTrue(isSomething(webElement)) instead of Assert.assertSomething(webElement.something())
public class WebDriverAssert {


    public static void assertIsLoaded(WebPage page) {
        delay();
        page.isLoaded();
    }

    public static void assertIsDisplayed(WebElement webElement) {
        delay();
        Assert.assertTrue(isDisplayed(webElement));
    }

    public static void assertText(String expected, WebElement webElement) {
        delay();
        Assert.assertEquals(expected, webElement.getText());
        // DEBUG TEXT: Asserted text "expected" in <tagname ...>
    }

    public static void assertTextContains(String expected, WebElement webElement) {
        delay();
        Assert.assertTrue(webElement.getText().contains(expected));
    }

    public static void assertTextEndsWith(String expected, WebElement webElement) {
        delay();
        Assert.assertTrue(webElement.getText().endsWith(expected));
    }

    public static void assertLinkUrl(String expected, WebElement webElement) {
        delay();
        Assert.assertEquals(expected, webElement.getAttribute("href"));
    }

    public static void assertUrl(WebPage page) {
        delay();
        boolean urlEquals = page.getDriver().getCurrentUrl().matches(page.getUrl()); 
        Assert.assertTrue(urlEquals);
    }

    public static void assertUrlContains(String expected, WebPage page) {
        delay();
        Assert.assertTrue(page.getDriver().getCurrentUrl().contains(expected));
    }

    public static void assertHrefContains(String expected, WebElement webElement) {
        delay();
        Assert.assertTrue(webElement.getAttribute("href").contains(expected));
    }

    public static void assertHrefEndsWith(String expected, WebElement webElement) {
        delay();
        Assert.assertTrue(webElement.getAttribute("href").endsWith(expected));
    }

    public static void assertNumberOfElements(int numberOfElementsExpected, List<? extends WebElement> webElementList) {
        delay();
        Assert.assertEquals(numberOfElementsExpected, webElementList.size());
    }

}
