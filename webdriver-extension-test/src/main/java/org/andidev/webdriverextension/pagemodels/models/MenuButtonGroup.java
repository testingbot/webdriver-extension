package org.andidev.webdriverextension.pagemodels.models;

import org.andidev.webdriverextension.WebContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuButtonGroup extends WebContainer {
    @FindBy(css = "#menu")
    public WebElement menu;
    @FindBy(css = "#menu-create")
    public WebElement create;
    @FindBy(css = "#menu-update")
    public WebElement update;
    @FindBy(css = "#menu-delete")
    public WebElement delete;
}
