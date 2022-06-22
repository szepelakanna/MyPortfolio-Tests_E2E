import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class InvalidCharacteristicAddingTest extends SeleniumBaseTest {

    @Test
    public void shouldNotAddCharacteristicWithoutUls() {
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lsl = "8";
        String expErrorMessage = "The value 'Select process' is not valid for ProjectId.";

        new LoginPage(driver)
                .login(config.getApplicationUser(), config.getApplicationPassword())
                .goToCharacteristic()
                .clickAddCharacteristic()
                .typeCharacteristicName(characteristicName)
                .typeLsl(lsl)
                .submitCreateWithFailure()
                .assertProcessNameError(expErrorMessage)
                .backToList()
                .assertCharacteristicIsNotShown(characteristicName);
    }
}


