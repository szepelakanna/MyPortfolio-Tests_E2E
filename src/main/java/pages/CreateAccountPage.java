package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "#ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "#ConfirmPassword-error")
    private WebElement confirmationPasswordError;

    @FindBy(css = "#register > section > form > div.text-danger.validation-summary-errors > ul > li")
    private WebElement wrongPasswordError;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;


    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typeRandomUniqueEmail() {
        Faker faker = new Faker();
        String randomUniqueEmail = faker.internet().emailAddress().toString();
        emailTxt.clear();
        emailTxt.sendKeys(randomUniqueEmail);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage typeConfirmationPassword(String password) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(password);
        return this;
    }

    public HomePage validRegister() {
        registerBtn.click();
        return new HomePage(driver);
    }

    public CreateAccountPage registerWithFailure() {
        registerBtn.click();
        return this;
    }

    public CreateAccountPage assertConfirmationPasswordErrorIsShown(String expError) {
        Assert.assertTrue(confirmationPasswordError.isDisplayed());
        Assert.assertEquals(confirmationPasswordError.getText(), expError);
        return this;
    }

    public CreateAccountPage assertWrongPasswordErrorIsShown(String expError) {
        Assert.assertTrue(wrongPasswordError.isDisplayed());
        Assert.assertEquals(wrongPasswordError.getText(), expError);
        return this;
    }

}