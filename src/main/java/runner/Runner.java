package runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.*;
import pages.*;

public class Runner {
    private static WebDriver driver;
    private Finance_Plan_login fpLogin;
    private NewLeadCreation details;
    private NavigationToFinancialPlan fPlan;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat-workpoint.fincart.com/login");

        // Initialize page objects
        fpLogin = new Finance_Plan_login(driver);
        details = new NewLeadCreation(driver);
        fPlan = new NavigationToFinancialPlan(driver);
    }

    @Test(priority = 1, dataProvider = "Valid_details", dataProviderClass = DataProviders.class)
    public void verifyValidDetails(String username, String password, String Name, String ccode, String num,
            String emailid, int index, String fPlanName) throws IOException, InterruptedException {
    	    try { 
        	fpLogin.applicationLogin(username, password);
        	
    	  }
    	    catch (NoSuchElementException|TimeoutException e) {
    	    	String errorMessage = WebElements.error.getText();
    	        Assert.assertEquals(errorMessage, "Error: Username or password is incorrect", "Unsuccessful login verification failed");
    	        WebElements.shot.captureScreenshot(driver,"error");
    	        tearDown();
    	        return;
    	    }
            fPlan.newFinPlan(fPlanName);
        }

    @Test(priority = 2, dataProvider = "Invalid_details", dataProviderClass = DataProviders.class)
    public void newLeadCreation(String username, String password, String Name, String ccode, String num,
            String emailid, int index, String fPlanName) throws IOException, InterruptedException {
    	    try { 
        	fpLogin.applicationLogin(username, password);
        	
    	  }
    	    catch (NoSuchElementException|TimeoutException e) {
    	    	String errorMessage = WebElements.error.getText();
    	        Assert.assertEquals(errorMessage, "Error: Username or password is incorrect", "Unsuccessful login verification failed");
    	        WebElements.shot.captureScreenshot(driver,"error");
    	        tearDown();
    	        return;
        }
    	    details.newLead(Name, ccode, num, emailid, index);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
