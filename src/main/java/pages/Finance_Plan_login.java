	package pages;
	import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


	
	public class Finance_Plan_login extends WebElements {

	    public Finance_Plan_login(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
      //login page validation
	private void page_validation() throws IOException  {
		 try{
	    	 String title = driver.getTitle();
	    	 System.out.println("reached workpoint login page");
	    	 sassert.assertEquals(title, "Workpoint | Fincart","page verification failed");
	    	 sassert.assertAll();
	     }
	     catch(AssertionError e) {
	    	 System.out.println("page validation failed");
	    	 getShot().captureScreenshot(driver,"title_verification_failed");
	     }
	}
	 
	private void setUsername(String username) {
		usernameField.sendKeys(username);
	}
	private void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	private void login_button() throws IOException {
	    login_button.click();
	}
	
	   //To verify if user reached homepage
	private void verifyLogin() throws IOException {
			wait.until(ExpectedConditions.visibilityOfAllElements(Profile_name));
	    	String profileName = Profile_name.getText();
	        sassert.assertEquals(profileName, "Testentry", "Successful login verification failed");
	        sassert.assertAll();
	        System.out.println("Successful Login pass");
	        wait.until(ExpectedConditions.invisibilityOf(spinner));
	        wait.until(ExpectedConditions.elementToBeClickable(leads));
	        System.out.println("clicking lead");
	        act.click(leads).perform();
	}
	  // Wrapper class
	public void applicationLogin(String username,String password) throws IOException, InterruptedException {
	    	page_validation();
		    setUsername(username);
	     	setPassword(password);
	    	login_button();
	    	verifyLogin();
	 }
	}
	
