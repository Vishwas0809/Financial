package regression;

import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.Test;

public class Runner extends TestBase {

    @Test
    public void verifySuccessfulLogin() throws IOException, InterruptedException {
        Fp.page_validation();
        Fp.credentials("testentry@fincart.com","fincart@123");
        Fp.login_button();
        Lc.lead_creation();
        try {
            details.addNewLead();
            details.newLeadDeatails("xyz","India","9898787899","xz@yopmail.com", 1);
        } catch (ElementNotInteractableException e) {
            System.out.println("detail already exist");
            captureScreenshot("details_Exist");
        }
    }

    @Test
    public void verifyUnsuccessfulLogin() throws IOException, InterruptedException {
        Fp.page_validation();
        Fp.credentials("xyz", "123");
        Fp.login_button();
        driver.quit();
    }
}
