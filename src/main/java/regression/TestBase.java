package regression;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
     WebDriver driver;
     Finance_Plan_login Fp;
     Lead_Creation Lc;
     NewLeadCreation details;

    @BeforeMethod
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat-workpoint.fincart.com/login");

        Fp = new Finance_Plan_login(driver);
        Lc = new Lead_Creation(driver);
        details = new NewLeadCreation(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void captureScreenshot(String filename) {
        try {
            TakesScreenshot sc = (TakesScreenshot) driver;
            File screenshot = sc.getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + filename + ".png");
            FileUtils.copyFile(screenshot, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

