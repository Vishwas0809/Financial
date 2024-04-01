package regression;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Finance_Plan_login {
	WebDriver driver;
	SoftAssert sassert;
	String url="https://uat-workpoint.fincart.com/login";
    @FindBy(xpath="//input[@type=\"text\"][@placeholder=\"Enter username...\"]")
    WebElement username;
    @FindBy(xpath="//input[@placeholder=\"Enter password...\"]")
    WebElement password;
    @FindBy(xpath="//button[@class=\"btn btn-fincart\"]")
    WebElement login_button;
    @FindBy(xpath="//p[.='testentry']")
    WebElement Profile_name;
    @FindBy(xpath="//div[.='Error: Username or password is incorrect']")
    WebElement error;
    WebDriverWait wait;
    
  
public Finance_Plan_login(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
}

public void page_validation() throws IOException  {
	 sassert=new SoftAssert();
	 String title = driver.getTitle();
     try{
    	 sassert.assertEquals(title, "Workpoint | Fincart","page verification failed");
    	 sassert.assertAll();
     }
     catch(AssertionError e) {
    	 captureScreenshot("title_verification_failed");
    	 throw e;
     }
}

public void credentials(String args1,String args2 ) {
	username.sendKeys(args1);
	password.sendKeys(args2);
}

public void login_button() throws IOException {
    login_button.click();
    
    try {
        wait.until(ExpectedConditions.visibilityOf(Profile_name));
        verifySuccessfulLogin();
    } catch (TimeoutException e) {
        verifyUnsuccessfulLogin();
    }
}

private void verifySuccessfulLogin() throws IOException {
    String profileName = Profile_name.getText();
    sassert.assertEquals(profileName, "Testentry", "Successful login verification failed");
    sassert.assertAll();
    System.out.println("Successful Login pass");
}

private void verifyUnsuccessfulLogin() throws IOException {
   try {
	String errorMessage = error.getText();
    System.out.println("Unsuccessful login pass");
    System.out.println(errorMessage);
    sassert.assertEquals(errorMessage, "Error: Username or password is incorrect", "Unsuccessful login verification failed");
}
   catch(NoSuchElementException e) {
	    captureScreenshot("unsuccessful_login");
   }
   }


public void captureScreenshot(String filename) throws IOException {
	try {
		TakesScreenshot sc=(TakesScreenshot)driver;
		File screenshot = sc.getScreenshotAs(OutputType.FILE);
		File des=new File("screenshot/"+filename+".png");
		FileUtils.copyFile(screenshot, des);
		}
	finally{
		System.out.println("screeshot saved");
	}
}
}

	

