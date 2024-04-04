	package regression;
	
	
	import java.io.IOException;
	import java.time.Duration;
	
	import org.openqa.selenium.ElementClickInterceptedException;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.TimeoutException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.asserts.SoftAssert;
	
	public class Finance_Plan_login extends TestBase  {
		WebDriver driver;
		SoftAssert sassert;
		ScreenshotCaptureHandling shot;
		@FindBy(xpath="(//a[@style=\"border-radius: 15px;\"])[1]")
	    WebElement leads;
		@FindBy(xpath="//div[@id=\"spinnerinitloading\"]")
		WebElement spinner;
	    @FindBy(xpath="//input[@type=\"text\"][@placeholder=\"Enter username...\"]")
	    private static WebElement usernameField;
	    @FindBy(xpath="//input[@placeholder=\"Enter password...\"]")
	    private static WebElement passwordField;
	    @FindBy(xpath="//button[@class=\"btn btn-fincart\"]")
	    private static WebElement login_button;
	    @FindBy(xpath="//p[.='testentry']")
	    private static WebElement Profile_name;
	    @FindBy(xpath="//div[.='Error: Username or password is incorrect']")
	    private static WebElement error;
	    private static WebDriverWait wait;
	    Actions act;
	
	    //WebDriver initialisation
	public Finance_Plan_login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		shot=new ScreenshotCaptureHandling();
		sassert=new SoftAssert();
		act=new Actions(driver);
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
	    	 shot.captureScreenshot(driver,"title_verification_failed");
	  
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
		try{
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
	    catch (NoSuchElementException|TimeoutException e) {
	    	String errorMessage = error.getText();
	        sassert.assertEquals(errorMessage, "Error: Username or password is incorrect", "Unsuccessful login verification failed");
	        shot.captureScreenshot(driver,"error");
	        driver.quit();
	         }
	    	
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
	
