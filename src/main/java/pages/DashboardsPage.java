package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardsPage extends HomePage {
    public DashboardsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h2[text()='DEMO PROJECT']")
    private WebElement demoProjectHeader;

    @FindBy(linkText = "Create your first process")
    private WebElement createFirstProjectBtn;


    public DashboardsPage assertProperUrlDash() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://localhost:4444/");
        return this;
    }

    public DashboardsPage assertDemoProjectIsShown() {
        Assert.assertTrue(isElementPresent(demoProjectHeader) || isElementPresent(createFirstProjectBtn));

        return this;


    }
}
