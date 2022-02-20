import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.lang.Thread;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Chrome driver setting
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_v98\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Firefox setting
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe" );   
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
//		capabilities.setCapability("marionette",true);  
		//WebDriver driver= new FirefoxDriver();  
		
		// Input string
		String image = "dc5566";
		driver.get("https://prnt.sc/"+image);
		try {
			Thread.sleep(10000);
		
			// Identifying the image
			WebElement a = driver.findElement(By.xpath("/html/body/div[3]/div/div/img"));
		
			Actions b = new Actions(driver);
			//Performing right click on img
			b.moveToElement(a).contextClick().perform();
			Thread.sleep(1000);
			Robot robo = new Robot();
	        robo.keyPress(KeyEvent.VK_V);
	        robo.keyRelease(KeyEvent.VK_V);
	        Thread.sleep(2000);
	        //Update the name and save the img
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        StringSelection stringSelection = new StringSelection(image);
	        clipboard.setContents(stringSelection, null);
	        // perform copy and paste to change the file name
	        robo.keyPress(KeyEvent.VK_CONTROL);
	        robo.keyPress(KeyEvent.VK_V);
	        robo.keyRelease(KeyEvent.VK_V);
	        robo.keyRelease(KeyEvent.VK_CONTROL);
	        Thread.sleep(1000);
	        robo.keyPress(KeyEvent.VK_ENTER);
	        robo.keyRelease(KeyEvent.VK_ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//driver.close(); // It close current browser
		//driver.quit(); // Close all the browsers windows opened by selenium
		
	}

}
