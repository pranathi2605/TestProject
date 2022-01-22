package Testing.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

public class Properties {
	WebDriver driver ;
	
	public String readData(String key) throws FileNotFoundException {
		
    Properties properties = new Properties();
    FileInputStream fileinputstream = new FileInputStream("D:\\testingproject\\AutomationTesting\\Testdata.properties");
	properties.load(fileinputstream);
	String output = properties.getProperty(key);
	return output;
	
	
	
	
	
	}

}
