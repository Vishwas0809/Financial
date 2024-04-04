
package regression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class Runner extends TestBase {
	By close=By.xpath("(//a[@class=\"closebtn\"])[2]");

    @Test(priority=1, dataProvider="Valid_details", dataProviderClass = DataProviders.class)
    public void verifyValidDetails(String username,String password,String Name, String ccode,String num,String emailid, int index, String fPlanName) throws IOException, InterruptedException {
        Fplogin.applicationLogin(username, password);
        try{
        	details.newLead(Name, ccode, num, emailid, index);
        }
        catch(ElementNotInteractableException |NoSuchElementException e) {
        	driver.findElement(close).click();
        	Fplan.newFinPlan(fPlanName);
        }
        
    }

    @Test(priority=2, dataProvider="Invalid_details", dataProviderClass = DataProviders.class)
    public void verifyInValidDetails(String username,String password,String Name, String ccode,String num,String emailid, int index, String fPlanName) throws IOException, InterruptedException {
    	Fplogin.applicationLogin(username, password);
    
        }
    }
