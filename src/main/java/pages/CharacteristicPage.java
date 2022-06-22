package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CharacteristicPage extends HomePage {


    @FindBy(css = ".page-title h3")
    private WebElement pageHeaderCharacteristic;

    @FindBy(linkText = "Add new characteristic")
    private WebElement addCharacteristicBtn;


    public CharacteristicPage(WebDriver driver) {
        super(driver);
    }

    public CharacteristicPage assertProperUrlCharacteristic() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://localhost:4444/Characteristics");
        return this;
    }

    public CharacteristicPage assertHeaderCharacteristic() {
        Assert.assertEquals(pageHeaderCharacteristic.getText(), "Characteristics");
        return this;

    }

    public CreateCharacteristicPage clickAddCharacteristic() {
        addCharacteristicBtn.click();
        return new CreateCharacteristicPage(driver);
    }

    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//tbody//td[text()='%s']/..";

    public CharacteristicPage assertCharacteristic(String expName, String expLsl, String expUsl, String expBinCount) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));

        String actLsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();

        Assert.assertEquals(actLsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);

        return this;
    }


    public CharacteristicPage assertCharacteristicIsNotShown(String characteristicName) {
        String processXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, characteristicName);
        List<WebElement> process = driver.findElements(By.xpath(processXpath));
        Assert.assertEquals(process.size(), 0);

        return this;
    }

    private String GENERIC_CHARACTERISTIC_RESULTS_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Results')]";

    public ResultsPage goToResults(String characteristicName) {
        String resultsBtnXpath = String.format(GENERIC_CHARACTERISTIC_RESULTS_XPATH, characteristicName);
        driver.findElement(By.xpath(resultsBtnXpath)).click();

        return new ResultsPage(driver);
    }

    private String GENERIC_CHARACTERISTIC_REPORT_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Report')]";

    public ReportPage goToReport(String characteristicName) {
        String reportBtnXpath = String.format(GENERIC_CHARACTERISTIC_REPORT_XPATH, characteristicName);
        driver.findElement(By.xpath(reportBtnXpath)).click();

        return new ReportPage(driver);
    }


}

