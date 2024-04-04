package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
     protected WebDriver driver;
     protected Finance_Plan_login Fplogin;
     protected NewLeadCreation details;
     protected NavigationToFinancialPlan Fplan ;

    @BeforeMethod
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat-workpoint.fincart.com/login");
        Fplogin = new Finance_Plan_login(driver);
        details = new NewLeadCreation(driver);
        Fplan = new NavigationToFinancialPlan(driver);
        
    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    
}


