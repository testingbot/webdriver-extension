package org.andidev.webdriverextension.pagebots;

import static org.andidev.webdriverextension.WebDriverAssert.*;
import org.andidev.webdriverextension.annotation.PageObject;
import org.andidev.webdriverextension.pagemodels.HomePageModel;
import org.openqa.selenium.WebDriver;

@PageObject(name = "homePage")
public class HomePageBot extends HomePageModel {

    public HomePageBot(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        getDriver().get("http://andidev.github.com/webdriver-extension/index.html");
    }

    @Override
    public void assertIsOpen() throws Error {
        assertIsDisplayed(examples);
    }
}