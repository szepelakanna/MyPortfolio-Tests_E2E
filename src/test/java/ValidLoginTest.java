import config.Config;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ValidLoginTest extends SeleniumBaseTest {

    @Test
    public void shouldCorrectCredentials() {
        new LoginPage(driver)
                .login(config.getApplicationUser(), config.getApplicationPassword())
                .assertWelcomeElementIsShown();
    }
}