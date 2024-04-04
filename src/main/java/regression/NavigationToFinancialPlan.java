package regression;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class NavigationToFinancialPlan {
	WebDriver driver;
	@FindBy(xpath="//select[@name=\"OrderBy\"]")
	WebElement OrderBy;
	Select dropdown;
	@FindBy(xpath="//div[@id=\"spinnerinitloading\"]")
	WebElement spinner;
	WebDriverWait wait;
	@FindBy(xpath="(//a[.=' VIEW FINANCIAL PLAN'])[1]")
	WebElement financialPlan;
	SoftAssert sa;
	@FindBy(xpath="(//input[@placeholder=\"Enter plan name\"])[2]")
	WebElement FinPlanName;
	@FindBy(xpath="//button[.='SUBMIT']")
	WebElement submitButton;
	@FindBy(xpath="//a[.='Edit']")
	WebElement Edit;
	Actions act;
	FluentWait<WebDriver> wait1;
	JavascriptExecutor js;
	public NavigationToFinancialPlan(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
        private void navigationByDate() throws InterruptedException {
        	js=(JavascriptExecutor)driver;
        	wait1 = new FluentWait<>(driver)
        		    .withTimeout(Duration.ofSeconds(30))
        		    .pollingEvery(Duration.ofSeconds(10));

        	act=new Actions(driver);
           	dropdown=new Select(OrderBy);
           	dropdown.selectByValue("ByDate");
            try {
           	    js.executeScript("window.scrollBy(0,200)");
                wait.until(ExpectedConditions.invisibilityOf(spinner));
                wait1.until(ExpectedConditions.elementToBeClickable(financialPlan));
                js.executeScript("arguments[0].click();",financialPlan);
            }
             catch (TimeoutException | ElementClickInterceptedException e) {
                System.out.println("Financial plan button not found after waiting, retrying");
                wait1.until(ExpectedConditions.elementToBeClickable(financialPlan));
                System.out.println("hi");
                act.moveToElement(financialPlan).click().perform(); // Move to element before clicking
            }
        	 	       	      	
        }
        private void newFinancialPlanCreation(String planName) {
    		 sa=new SoftAssert();
             Set<String> windows = driver.getWindowHandles();
             ArrayList<String> ChildWin=new ArrayList<>(windows);
             driver.switchTo().window(ChildWin.get(1));
             String url = driver.getCurrentUrl();
             System.out.println(url);
             sa.assertEquals(url, "https://uat-workpoint.fincart.com/financialplan/my-plan?plan","create new financial plan page not open");
            try{ 
            	FinPlanName.sendKeys(planName);
                submitButton.click();
        }
            catch(ElementNotInteractableException e) {
            	js.executeScript("arguments[0].click();",Edit);
            }
        }
                               
        public void newFinPlan(String planName) throws InterruptedException {
        	navigationByDate();
        	newFinancialPlanCreation(planName);
        	
        }
}
