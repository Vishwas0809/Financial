package regression;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLeadCreation {
	WebDriver driver;
	@FindBy(xpath="//div[@id=\"spinnerinitloading\"]")
	WebElement spinner;
	@FindBy(xpath="//a[text()=' + ADD A LEAD']")
	WebElement addLead;
	WebDriverWait wait;
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement newleadname;
	@FindBy(xpath="//select[@id=\"country_Phone_Code\"]")
	WebElement Country;
	@FindBy(xpath="//input[@id=\"mobile\"]")
	WebElement MobileNo;
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement email;
	@FindBy(xpath="//select[@id=\"campaign\"]")
	WebElement campaign;
	@FindBy(xpath="(//input[@type=\"button\"])[3]")
	WebElement submit;
	@FindBy(xpath="(//button[@class=\"btn btn-success btn-sm\"])[3]")
	WebElement success;
	@FindBy(xpath="(//button[.='Close'])[13]")
	WebElement Close;
	
	

	public NewLeadCreation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
public void addNewLead() {
		
		
		try{
			wait.until(ExpectedConditions.invisibilityOf(spinner));
			wait.until(ExpectedConditions.elementToBeClickable(addLead));
			addLead.click();
		    
	}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			
			addLead.click();
		}
}
		
	public void newLeadDeatails(String Name, String ccode,String num,String emailid, int index) {
		wait.until(ExpectedConditions.invisibilityOf(spinner));
//		wait.until(ExpectedConditions.elementSelectionStateToBe(newleadname, true));
		newleadname.sendKeys(Name);
		Select code=new Select(Country);
		code.selectByValue(ccode);
		MobileNo.sendKeys(num);
		email.sendKeys(emailid);
        Select sct=new Select(campaign);
        sct.selectByIndex(index);
        submit.click();
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        Close.click();
        
	
	}
}

