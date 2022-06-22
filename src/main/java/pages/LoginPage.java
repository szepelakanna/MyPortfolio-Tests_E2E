package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".flash-message>strong")
    private WebElement logoutMsg;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = "a[href*='Register'")
    public WebElement register;

    public HomePage login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        submitLogin();

        return new HomePage (driver);

    }
    public CreateAccountPage goToRegisterPage(){
        register.click();
        return new CreateAccountPage(driver);

    }

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();

        return new HomePage(driver);
    }

}

