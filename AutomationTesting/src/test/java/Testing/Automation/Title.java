package Testing.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Title {
	
	WebDriver driver;
	@Test
	public void printTitle() {

		System.setProperty("webdriver.chrome.driver" , "D:\\testingproject\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("the tile of the page is "+title);
	}

}
