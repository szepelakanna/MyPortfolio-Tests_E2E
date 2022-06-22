package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    protected WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Add results sample")
    private WebElement addResultsBtn;

    @FindBy(linkText = "Back to characteristics")
    private WebElement backBtn;

    public CreateResultsPage clickAddResults(){
        addResultsBtn.click();

        return new CreateResultsPage(driver);
    }
    public CharacteristicPage backToCharacteristic(){
        backBtn.click();
        return new CharacteristicPage (driver);

    }

}

