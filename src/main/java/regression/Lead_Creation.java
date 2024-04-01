package regression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lead_Creation {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="(//a[@style=\"border-radius: 15px;\"])[1]")
    WebElement leads;
	@FindBy(xpath="//div[@id=\"spinnerinitloading\"]")
	WebElement spinner;

	
	public Lead_Creation(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}

	public void lead_creation() throws InterruptedException {
		try{
			wait.until(ExpectedConditions.invisibilityOf(spinner));
		    leads.click();
	}
		catch(ElementClickInterceptedException e) {
			wait.until(ExpectedConditions.elementToBeClickable(leads));
			leads.click();
		}
			
		}
	
}
