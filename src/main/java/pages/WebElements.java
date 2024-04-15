	package pages;
	
	import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.asserts.SoftAssert;

import utilities.ScreenshotCaptureHandling;
	
	public class WebElements {
		protected WebDriver driver;
		protected SoftAssert sassert;
		public static ScreenshotCaptureHandling shot;
		@FindBy(xpath="(//a[@style=\"border-radius: 15px;\"])[1]")
		protected WebElement leads;
		@FindBy(xpath="//div[@id=\"spinnerinitloading\"]")
		protected WebElement spinner;
	    @FindBy(xpath="//input[@type=\"text\"][@placeholder=\"Enter username...\"]")
	    protected WebElement usernameField;
	    @FindBy(xpath="//input[@placeholder=\"Enter password...\"]")
	    protected WebElement passwordField;
	    @FindBy(xpath="//button[@class=\"btn btn-fincart\"]")
	    protected WebElement login_button;
	    @FindBy(xpath="//p[.='testentry']")
	    protected WebElement Profile_name;
	    @FindBy(xpath="//div[.='Error: Username or password is incorrect']")
		public static WebElement error;
	    protected WebDriverWait wait;
	    Actions act;
		@FindBy(xpath="//a[text()=' + ADD A LEAD']")
		protected WebElement addLead;
		@FindBy(xpath="//input[@id=\"name\"]")
		protected WebElement newleadname;
		@FindBy(xpath="//select[@id=\"country_Phone_Code\"]")
		protected WebElement Country;
		@FindBy(xpath="//input[@id=\"mobile\"]")
		protected WebElement MobileNo;
		@FindBy(xpath="//input[@id=\"email\"]")
		protected WebElement email;
		@FindBy(xpath="//select[@id=\"campaign\"]")
		protected WebElement campaign;
		@FindBy(xpath="(//input[@type=\"button\"])[3]")
		protected WebElement submit;
		@FindBy(xpath="(//button[@class=\"btn btn-success btn-sm\"])[3]")
		protected WebElement success;
		protected WebElement OrderBy;
	 	Select dropdown;
	 	@FindBy(xpath="(//a[.=' VIEW FINANCIAL PLAN'])[1]")
	 	protected WebElement viewfinancialplan;
	 	@FindBy(xpath="(//a[.=' CREATE FINANCIAL PLAN'])[1]")
	 	protected WebElement createfinancialplan;
	 	SoftAssert sa;
	 	@FindBy(xpath="(//input[@placeholder=\"Enter plan name\"])[2]")
	 	protected WebElement FinPlanName;
	 	@FindBy(xpath="//button[.='SUBMIT']")
	 	protected WebElement submitPlanName;
	 	@FindBy(xpath="//a[.='Edit']")
	 	protected WebElement Edit;
	 	protected FluentWait<WebDriver> fluentwait;
	 	protected JavascriptExecutor js;
	 	@FindBy(xpath="(//button[@class=\"btn btn-success btn-sm\"])[3]")
	 	protected WebElement Submission_successful;
	 	public WebElements(WebDriver driver) {
	        this.driver = driver;
			PageFactory.initElements(driver,this);
			wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			setShot(new ScreenshotCaptureHandling());
			sassert=new SoftAssert();
			act=new Actions(driver);
	}
		public static ScreenshotCaptureHandling getShot() {
			return shot;
		}
		public void setShot(ScreenshotCaptureHandling shot) {
			WebElements.shot = shot;
		}
	}
