package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends SeleniumPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;

    @FindBy(css = ".menu-workspace")
    private WebElement workspaceNav;

    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    @FindBy(css = "a[href*='Characteristic'")
    public WebElement characterisiticMenu;

    @FindBy(css = ".menu-home")
    private WebElement homeNav;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardMenu;

    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));
        //   "./.. - to oznacza znajdz rodzica danego elementu

        return parent.getAttribute("class").contains("active");
    }

    public ProcessesPage goToProcesses() {
        if (!isParentExpanded(workspaceNav)) {
            workspaceNav.click();
        }

        processesMenu.click();

        return new ProcessesPage(driver);
    }

    public CharacteristicPage goToCharacteristic() {
        if (!isParentExpanded(workspaceNav)) {
            workspaceNav.click();
        }
        characterisiticMenu.click();

        return new CharacteristicPage(driver);
    }

    public DashboardsPage goToDashboards() {
        if (!isParentExpanded(homeNav)) {
            homeNav.click();
        }
        dashboardMenu.click();

        return new DashboardsPage(driver);
    }


    public HomePage assertWelcomeElementIsShown() {
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not shown.");
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + welcomeElm.getText() + "' does not contain word 'Welcome'");

        return this;
    }

}
