import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidRegistrationTests extends SeleniumBaseTest {


    @DataProvider
    public Object[][] getWrongPassword() {
        return new Object[][]{
                {"Test12343", "Passwords must have at least one non alphanumeric character."},
                {"Testoblevlewanie!", "Passwords must have at least one digit ('0'-'9')."},
                {"test12eeee3!", "Passwords must have at least one uppercase ('A'-'Z')."}
        };
    }

    @Test(dataProvider = "getWrongPassword")
    public void shouldNotRegisterWhenPasswordIsIncorrect(String wrongPassword, String expError) {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(config.getApplicationUser())
                .typePassword(wrongPassword)
                .typeConfirmationPassword(wrongPassword)
                .registerWithFailure()
                .assertWrongPasswordErrorIsShown(expError);
    }

    @Test
    public void shouldNotRegisterWhenConfirmationPasswordDoesNotMatch() {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .typeConfirmationPassword("1231321212121212")
                .registerWithFailure().assertWrongPasswordErrorIsShown("\"The password and confirmation password do not match.\"");
    }
}
