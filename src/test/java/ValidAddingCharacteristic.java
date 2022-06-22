import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class ValidAddingCharacteristic extends SeleniumBaseTest {
    @Test
    public void shouldAddCharacteristicToTheTable() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lsl = "8";
        String usl = "10";
        String sampleName = "Test sample";
        String results = "8.0;9.0";
        String expMean = "8.5000";
        String expLsl = "8.0000";
        String expUsl = "10.0000";
        String expStandardDev = "0.7071";
        String expPerformanceInx = "0.2357";

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToCharacteristic()
                .clickAddCharacteristic()
                .selectProcess(processName)
                .typeCharacteristicName(characteristicName)
                .typeLsl(lsl)
                .typeUsl(usl)
                .submitCreate()
                .goToResults(characteristicName)
                .clickAddResults()
                .typeSample(sampleName)
                .typeResults(results)
                .submitCreate()
                .backToCharacteristic()
                .goToReport(characteristicName)
                .assertMean(expMean)
                .assertLsl(expLsl)
                .assertUsl(expUsl)
                .assertStandardDev(expStandardDev)
                .assertPerformanceInx(expPerformanceInx);
    }
}
