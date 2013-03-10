package org.andidev.webdriverextension.bot;

import java.util.List;
import org.andidev.webdriverextension.Openable;
import org.andidev.webdriverextension.bot.fest.asserttypes.AssertTypes;
import org.andidev.webdriverextension.bot.fest.istypes.IsTypes;
import org.andidev.webdriverextension.bot.fest.presstypes.PressKeysTypes;
import org.andidev.webdriverextension.bot.fest.presstypes.PressTypes;
import org.andidev.webdriverextension.bot.fest.readtypes.ReadDriverTypes;
import org.andidev.webdriverextension.bot.fest.readtypes.ReadTypes;
import org.andidev.webdriverextension.bot.fest.selectoptiontypes.SelectOptionInTypes;
import org.andidev.webdriverextension.bot.fest.selectoptiontypes.SelectOptionTypes;
import org.andidev.webdriverextension.bot.fest.typetypes.TypeInTypes;
import org.andidev.webdriverextension.bot.fest.typetypes.TypeTypes;
import org.andidev.webdriverextension.bot.fest.waitfortypes.WaitForTimeTypes;
import org.andidev.webdriverextension.bot.fest.waitfortypes.WaitForWebElementTypes;
import org.andidev.webdriverextension.exceptions.WebDriverExtensionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FestBot {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JUnitBot.class);
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            throw new WebDriverExtensionException("WebDriver in FestBot is not set. Please set the driver with FestBot.setDriver(driver) before using the FestBot static methods. Note that the driver will be thread safe since it is set with ThreadLocal so don't worry about thread safety.");
        }
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    private WebElement country;
    private WebElement swedenOption;
    private WebElement errorMsg;
    private WebElement loginButton;
    private WebElement username;
    private List<WebElement> orders;
    private WebElement totalOrders;
    private WebElement rememberMe;


    /* Read */
    public ReadDriverTypes read() {
        return new ReadDriverTypes(getDriver());
    }

    public ReadTypes read(WebElement webElement) {
        return new ReadTypes(getDriver(), webElement);
    }

    /* Count */
    public static int count(List<WebElement> webElements) {
        return BotUtils.count(webElements);
    }

    /* Clear */
    public static void clear(WebElement webElement) {
        BotUtils.clear(webElement);
    }

    /* Type */
    public TypeTypes type() {
        return new TypeTypes();
    }

    public TypeInTypes type(String text) {
        return new TypeInTypes(text);
    }

    public TypeInTypes type(double number) {
        return new TypeInTypes(BotUtils.toString(number));
    }

    /* Clear and Type */
    public static void clearAndType(String text, WebElement webElement) {
        BotUtils.clearAndType(text, webElement);
    }

    public static void clearAndType(double number, WebElement webElement) {
        BotUtils.clearAndTypeNumber(number, webElement);
    }

    /* Press */
    public static PressTypes press() {
        return new PressTypes();
    }

    public static PressKeysTypes press(CharSequence... keys) {
        return new PressKeysTypes(keys);

    }

    /* Click */
    public static void click(WebElement webElement) {
        BotUtils.click(webElement);
    }

    /* Select */
    public void select(WebElement webElement) {
        BotUtils.select(webElement);
    }

    public SelectOptionTypes select() {
        return new SelectOptionTypes();
    }

    public SelectOptionInTypes select(String text) {
        return new SelectOptionInTypes(text);
    }

    public void deselect(WebElement webElement) {
        BotUtils.deselect(webElement);
    }

    public DeselectOptionTypes deselect() {
        return new DeselectOptionTypes();
    }

    public DeselectOptionInTypes deselect(String text) {
        return new DeselectOptionInTypes(text);
    }

    /* Check */
    public static void check(WebElement webElement) {
        BotUtils.check(webElement);
    }

    public static void uncheck(WebElement webElement) {
        BotUtils.uncheck(webElement);
    }

    /* Open */
    public static void open(String url) {
        BotUtils.open(url, getDriver());
    }

    public static void open(Openable openable) {
        BotUtils.open(openable);
    }

    /* Wait */
    public static WaitForTimeTypes waitFor(double time) {
        return new WaitForTimeTypes(time);
    }

    public static WaitForWebElementTypes waitFor(WebElement webElement) {
        return new WaitForWebElementTypes(webElement);
    }

    /* Debug */

    /* Has */

    /* Is */
    public IsTypes is(WebElement webElement) {
        return new IsTypes(getDriver(), webElement);
    }

    /* Select */
    public AssertTypes assertThat(WebElement webElement) {
        return new AssertTypes(getDriver(), webElement);
    }

    public FestBot() {
        // Normal reads
        read(username);
        read(username).options();
        read().url();

        // Normal clear
        clear(username);

        // Normal types
        type("anst07").in(username);
        type(42).in(totalOrders);

        // Normal click
        click(loginButton);

        // Normal selects
        select(swedenOption);
        select().option("Sweden").in(country);
        select().optionWithValue("SWEDEN").in(country);
        select().optionWithIndex(3).in(country);

        // Normal checks
        check(rememberMe);
        uncheck(rememberMe);

        // Normal ises
        is(username).text().equalTo("anst07");
        is(errorMsg).text().containing("Warning");
        is(country).option("Sweden").selected();

        // Normal asserts
        assertThat(username).value().equals("anst07");
        assertThat(errorMsg).text().contains("Warning");
        assertThat(country).option("Sweden").isSelected();

        // Alternatives (Implement theese as well?)
//        assertThat(errorMsg).text().is().containing("Warning");
//        assertThat(country).option("Sweden").is().selected();

        // Intelligent shortcut methods
        select("Sweden").in(country);



        is(username).equalTo("anst07");
        is(errorMsg).containing("Warning");
        is(country).option("Sweden").selected();

        assertThat(errorMsg).is("Warning this deletes the content!");
        assertThat(orders).is(42);
        assertThat(totalOrders).is(42);
        assertThat(username).is("anst07");
        assertThat(country).is("Sweden");
    }
}