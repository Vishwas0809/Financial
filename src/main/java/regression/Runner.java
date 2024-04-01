	package regression;
	
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
//@Listeners(regression.Listeners.class)
	
	public class Runner {
		WebDriver driver;
		Finance_Plan_login Fp;
		Lead_Creation Lc;
		Lead_Creation Nl;
		NewLeadCreation details;
	
		@BeforeMethod
	public void initialization() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat-workpoint.fincart.com/login");
		Fp=new Finance_Plan_login(driver);
		Lc=new Lead_Creation(driver);
		details=new NewLeadCreation(driver);
		
		}
		
		@Test
	public void verifySuccessfulLogin() throws IOException, InterruptedException {
		Fp.page_validation();
		Fp.credentials("testentry@fincart.com","fincart@123");
		Fp.login_button();
		Lc.lead_creation();
		try {
		details.addNewLead();
		details.newLeadDeatails("xyz","India","9898787899","xz@yopmail.com", 1);
		}
		catch(ElementNotInteractableException e) {
		System.out.println("detail already exist");
		captureScreenshot("details_Exist");
		}

		}
		@Test
	public void verifyUnsuccessfulLogin() throws IOException, InterruptedException {
		Fp.page_validation();
		Fp.credentials("xyz", "123");
		Fp.login_button();
		driver.quit();
	 }	
		public void captureScreenshot(String filename) throws IOException {
		TakesScreenshot sc=(TakesScreenshot)driver;
		File screenshot = sc.getScreenshotAs(OutputType.FILE);
		File des=new File("screenshot/"+filename+".png");
		FileUtils.copyFile(screenshot, des);
			}
			
		@AfterMethod
	public void teardown() {
		if(driver!=null) {
		driver.quit();
		}
	 }	
	}