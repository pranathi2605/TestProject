package Testing.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcases {
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver" , "D:\\testingproject\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		
	}
	@Test
	  public String readData(String key) throws IOException {
		  Properties properties = new Properties();
		   FileInputStream fileinputstream = new FileInputStream("D:\\testingproject\\AutomationTesting\\Test.properties");
		   properties.load(fileinputstream);
		   String output = properties.getProperty(key);
		   return output;
	  }
	  
	@Test(priority=0)
	public void testcase1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(3000);
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		String Pagesource = driver.getPageSource();
		System.out.println(title);
		System.out.println(url);
		System.out.println(Pagesource);
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
      for(WebElement link : alllinks) {
			
		System.out.println(link.getText());
	}
	}
	
          @Test(priority=1)
		public void testcase2() throws InterruptedException {
			
        	  driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
      		Thread.sleep(3000);
      		WebElement daydropdown = driver.findElement(By.id("day"));
      		Select obj=new Select(daydropdown);
      		obj.selectByValue("26");
      		WebElement monthdropdown = driver.findElement(By.id("month"));
      		Select month = new Select(monthdropdown);
      		month.selectByIndex(4);
      		WebElement yeardropdown = driver.findElement(By.id("year"));
      		Select year = new Select(yeardropdown);
      		year.selectByIndex(20);
      		Thread.sleep(3000);
      		
			
		}
		
	@Test(priority=2)
	public void testcase3() throws InterruptedException {
		driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		driver.findElement(By.xpath("(//a[text()=' Click this link to start new Tab '])[1]")).click();
		String mainwindow = driver.getWindowHandle();
		ArrayList<String> allwindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwindows.get(1));
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium methods"+Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("the title of the page is" +driver.getTitle());
		driver.switchTo().window(allwindows.get(0));
		System.out.println("the title of the page is" +driver.getTitle());
	
		
			
		}
	@Test(priority=3)
	public void testcase4() throws IOException {
	driver.get(readData("url"));
    WebElement text =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
   Actions action = new Actions(driver);
    action.doubleClick(text).build().perform();
	}
	@Test(priority=4)
  public void testcase5() throws InterruptedException, IOException {
	driver.get(readData("url1"));
	  WebElement source =driver.findElement(By.id("draggable"));
	  WebElement destination =driver.findElement(By.id("droppable"));
	  Thread.sleep(3000);
	  Actions action = new Actions(driver);
       action.dragAndDrop(source, destination).build().perform();
	}
	@Test(priority=5)
	public void testcase6() throws InterruptedException {
	driver.get("http://www.javatpoint.com/");
    WebElement text =driver.findElement(By.xpath("//a[text()=' HTML']"));
    Actions action = new Actions(driver);
    action.contextClick(text).build().perform();
    Thread.sleep(3000);
    
	}
    @Test(priority=6)
	public void  testcase7TotakeScreenshots() throws IOException, InterruptedException {
		driver.get(readData("url2"));
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("D:\\testingproject\\AutomationTesting\\Snap\\facebook.png");
		FileUtils.copyFile(SrcFile ,DestFile);
		
		Thread.sleep(3000);
		driver.close();
		
		
	}
	@AfterTest
    public void closebrowser() {
	driver.close();
	}

}
