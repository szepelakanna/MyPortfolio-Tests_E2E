import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class ValidAddingProcessTest extends SeleniumBaseTest {
    @Test
    public void shouldAddProcessToProcessesTable() {
        String processName = UUID.randomUUID().toString().substring(0, 10);

        new LoginPage(driver)
                .login(config.getApplicationUser(), config.getApplicationPassword())
                .goToProcesses()
                .clickAddProcess()
                .typeProcessName(processName)
                .submitCreate()
                .assertProcess(processName, "", "");
    }
}