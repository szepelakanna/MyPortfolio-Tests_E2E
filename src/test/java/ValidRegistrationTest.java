import org.testng.annotations.Test;
import pages.LoginPage;

public class ValidRegistrationTest extends  SeleniumBaseTest{
    @Test
    public void shouldRegisterNewUser() {

        new LoginPage(driver)
                .goToRegisterPage()
                .typeRandomUniqueEmail()
                .typePassword(config.getApplicationPassword())
                .typeConfirmationPassword(config.getApplicationPassword())
                .validRegister()
                .assertWelcomeElementIsShown();
    }
}
