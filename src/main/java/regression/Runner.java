package regression;

import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Runner extends TestBase {

    
    @DataProvider(name="getdata")
    public static Object[][] getdata() {
    	return new Object[][] {
    		{"testentry@fincart.com","fincart@123","login"},
    		{"xyz","abc","login"}
    	};
    }
    
    
    @Test
    (dataProvider="getdata")
    public void verifySuccessfulLogin(String username,String password,String filename) throws IOException, InterruptedException {
        Fp.applicationLogin(username, password, filename);
        
    }
    
//    public void leadCreation() {
//        Lc.lead_creation();
//        try {
//            details.addNewLead();
//            details.newLeadDeatails("xyz","India","9898787899","xz@yopmail.com", 1);
//        } catch (ElementNotInteractableException e) {
//            System.out.println("detail already exist");
//            captureScreenshot("details_Exist");
//        }
//        driver.quit();
//    }


}
