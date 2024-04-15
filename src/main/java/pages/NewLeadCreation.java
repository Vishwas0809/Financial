	package pages;
	import org.openqa.selenium.ElementClickInterceptedException;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	
	public class NewLeadCreation extends WebElements {
			
	public NewLeadCreation(WebDriver driver) {
		    super(driver);
			}
	//add new lead button
	private void addNewLead() throws InterruptedException {
			
			
			try{
				wait.until(ExpectedConditions.invisibilityOf(spinner));
				wait.until(ExpectedConditions.elementToBeClickable(addLead));
				wait.until(ExpectedConditions.invisibilityOf(spinner));
				addLead.click();
			    
		}
			catch(ElementClickInterceptedException | NoSuchElementException e) {
				Thread.sleep(3000);
				addLead.click();
			}
	}
			//new lead details 
	private void newLeadDetails(String Name, String ccode,String num,String emailid, int index) {
			wait.until(ExpectedConditions.invisibilityOf(spinner));
			newleadname.sendKeys(Name);
			Select code=new Select(Country);
			code.selectByValue(ccode);
			MobileNo.sendKeys(num);
			email.sendKeys(emailid);
	        Select sct=new Select(campaign);
	        sct.selectByIndex(index);
	        submit.click();
	        wait.until(ExpectedConditions.invisibilityOf(spinner));
	        Submission_successful.click();
	}
	        //wrapper class
	        public void newLead(String Name, String ccode,String num,String emailid, int index) throws InterruptedException {
	        	addNewLead();
	        	newLeadDetails(Name, ccode, num, emailid, index);
	        	
	        }
	        
		
		}
	
	
