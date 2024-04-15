package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class NavigationToFinancialPlan extends WebElements {
	
	public NavigationToFinancialPlan(WebDriver driver) {
		super(driver);
	}
	
        private void navigationByDate() throws InterruptedException {
        	js=(JavascriptExecutor)driver;
        	fluentwait = new FluentWait<>(driver)
        		    .withTimeout(Duration.ofSeconds(30))
        		    .pollingEvery(Duration.ofSeconds(10));

        	dropdown=new Select(OrderBy);
           	dropdown.selectByValue("ByDate");
           	fluentwait.until(ExpectedConditions.invisibilityOf(spinner));
           	boolean viewFP = false;
           	try {
           		 js.executeScript("window.scrollBy(0,200)");
                 js.executeScript("arguments[0].click();", viewfinancialplan);
                 viewFP = true;
                }
             catch (TimeoutException | NoSuchElementException e) {
            	 System.out.println("in catch block");
                System.out.println("Financial plan button not found after waiting");
            }
            if(!viewFP) {
            	System.out.println("in if block");
           		js.executeScript("arguments[0].click();", createfinancialplan);
           	}
        }
        private void newfinancialplanCreation(String planName) {
    		 sa=new SoftAssert();
             Set<String> windows = driver.getWindowHandles();
             ArrayList<String> ChildWin=new ArrayList<>(windows);
             driver.switchTo().window(ChildWin.get(1));
             String url = driver.getCurrentUrl();
             System.out.println(url);
             sa.assertEquals(url, "https://uat-workpoint.fincart.com/viewfinancialplan/my-plan?plan","create new financial plan page not open");
             boolean existingPlan = false;
            try{ 
            	js.executeScript("arguments[0].click();",Edit);
                existingPlan=true;
        }
            catch(NoSuchElementException e) {
            	System.out.println("Edit financial plan button not found");
             }
            if(!existingPlan) {
            	js.executeScript("arguments[0].value = arguments[1]",FinPlanName, planName);
            	js.executeScript("arguments[0].click();", submitPlanName);
            	js.executeScript("arguments[0].click();",Edit);
            }
        }
         public void newFinPlan(String planName) throws InterruptedException {
        	navigationByDate();
        	newfinancialplanCreation(planName);
        	
        }
}
