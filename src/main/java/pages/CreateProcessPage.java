package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProcessPage extends ProcessesPage {

    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Name")
    private WebElement processNameTxt;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=Name]")
    public WebElement nameError;

    @FindBy(linkText = "Back to List")
    private WebElement backToListBtn;


    public CreateProcessPage typeProcessName(String Name) {
        processNameTxt.clear();
        processNameTxt.sendKeys(Name);
        return this;
    }

    public CreateProcessPage typeShortProcessName(String Name) {
        processNameTxt.clear();
        processNameTxt.sendKeys(Name);
        return this;
    }

    public ProcessesPage submitCreate() {
        createBtn.click();
        return new ProcessesPage(driver);
    }

    public CreateProcessPage submitCreateWithFailure() {
        createBtn.click();
        return this;
    }

    public CreateProcessPage assertProcessNameError(String expErrorMessage) {
        Assert.assertTrue(nameError.isDisplayed());
        Assert.assertEquals(nameError.getText(), expErrorMessage);

        return this;
    }

    public ProcessesPage backToList() {
        backToListBtn.click();

        return new ProcessesPage(driver);
    }

}

