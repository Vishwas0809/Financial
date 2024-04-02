package regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
  private static Properties properties=new Properties();
  
  static {
	  try {
		  FileInputStream IS=new FileInputStream("src/resource/confic.properties");
		  properties.load(IS);
	  }
	  catch(IOException e) {
		  System.err.println("Error loading configuration file: " + e.getMessage());
      }
  }
	 
  public static String getProperty(String key) {
	        return properties.getProperty(key);
  }
}

