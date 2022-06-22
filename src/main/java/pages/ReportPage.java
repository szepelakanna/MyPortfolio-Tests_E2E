package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReportPage {

    protected WebDriver driver;

    public ReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='Mean (x)']/../td[2]")
    private WebElement meanCell;

    public ReportPage assertMean(String expMean){
        Assert.assertEquals(meanCell.getText(), expMean);

        return this;
    }

    @FindBy(xpath = "//td[text()='Lower Specification Limit (LSL)']/../td[2]")
    private WebElement lslCell;

    public ReportPage assertLsl(String expLsl){
        Assert.assertEquals(lslCell.getText(), expLsl);

        return this;
    }

    @FindBy(xpath = "//td[text()='Upper Specification Limit (USL)']/../td[2]")
    private WebElement uslCell;

    public ReportPage assertUsl(String expLsl){
        Assert.assertEquals(uslCell.getText(), expLsl);

        return this;
    }
    @FindBy(xpath = "//td[text()='Standard deviation (s)']/../td[2]")
    private WebElement StandardDevCell;

    public ReportPage assertStandardDev (String expStandardDev){
        Assert.assertEquals(StandardDevCell.getText(), expStandardDev);

        return this;
    }

    @FindBy(xpath = "//td[text()='Lower process performance index (Ppl)']/../td[2]")
    private WebElement PerformanceInxCell;

    public ReportPage assertPerformanceInx(String expPerformanceInx) {
        Assert.assertEquals(PerformanceInxCell.getText(), expPerformanceInx);

        return this;
    }


}
