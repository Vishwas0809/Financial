package utilities;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCaptureHandling {
	    public void captureScreenshot(WebDriver driver, String filename) {
	        try {
	            TakesScreenshot screenshot = (TakesScreenshot) driver;
	            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
	            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	            String directory = "screenshots/";
	            Path directoryPath = Paths.get(directory);
	            if (!Files.exists(directoryPath)) {
	                Files.createDirectories(directoryPath);
	            }
	            File destinationFile = new File(directory + filename + "_" + timestamp + ".png");
	            FileUtils.copyFile(sourceFile, destinationFile);
//	            System.out.println("Screenshot captured and saved as: " + destinationFile.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        }
	    }
	}
