package pages;

import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {
    protected WebDriver driver;

    public SeleniumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumPage() {
    }

    protected <T extends SeleniumPage> T getPageClassInstance(Class<T> clazz) {
        try {
            return (T) clazz.getConstructor(WebDriver.class).newInstance(this.driver);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException var3) {
            throw new RuntimeException("Could not instantiate class : " + clazz.getName() + " : " + var3.getMessage(), var3);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException var3) {
            return false;
        }
    }
}
