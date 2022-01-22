package Testing.Automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		
		//learning automation testing the tool is selenium webdriver 
		//programming language is java
		//github concept 
		//xyz
	
	System.setProperty("webdriver.chrome.driver" , "D:\\testingproject\\AutomationTesting\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/alerts/");
	}
	@Test
	public void alert() throws InterruptedException {
		driver.findElement(By.id("alertButton")).click();
	        Thread.sleep(7000);
	       Alert alert= driver.switchTo().alert();
	        alert.accept();
		     driver.findElement(By.id("timerAlertButton")).click();
	        Thread.sleep(7000);
	        Alert alert1 = driver.switchTo().alert();
	        alert1.accept();
			driver.findElement(By.id("confirmButton")).click();
			Thread.sleep(7000);
			 Alert alert2 = driver.switchTo().alert();
		      alert2.dismiss();
		       String output=  driver.findElement(By.id("confirmResult")).getText();
		  
			System.out.println("the result is : " +output);
			driver.findElement(By.id("promtButton")).click();
			 Thread.sleep(7000);
			 Alert alert3= driver.switchTo().alert();
		       alert3.sendKeys("12345");
		       alert3.accept();
		       String output1 =  driver.findElement(By.id("promptResult")).getText();
		       System.out.println("the result is : " +output1);
		}

	}


