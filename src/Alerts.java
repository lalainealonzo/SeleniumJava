import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		String myName = "Lalaine";
		String expectedAlertMsg = "Hello Lalaine, share this practice page and share your knowledge";
		String expectedAlertMsg2 = "Hello Lalaine, Are you sure you want to confirm?";
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		//Alert OK
		driver.findElement(By.id("name")).sendKeys(myName); //Enter your name
		driver.findElement(By.id("alertbtn")).click(); //click alert button to trigger the alert message
		String actualAlertMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);
		
		driver.switchTo().alert().accept(); //switch to alert then click OK
		
		Thread.sleep(2000);
		
		//Alert OK and Cancel (Click OK/Yes - positive)
		driver.findElement(By.id("name")).sendKeys(myName);
		driver.findElement(By.id("confirmbtn")).click(); //click confirm button to trigger the alert message
		String actualAlertMsg2 = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMsg2, expectedAlertMsg2);
		
		driver.switchTo().alert().accept(); //switch to alert then click OK/Yes
		
		Thread.sleep(2000);
		
		//Alert OK and Cancel (Click Cancel/No - negative)
		driver.findElement(By.id("name")).sendKeys(myName);
		driver.findElement(By.id("confirmbtn")).click(); //click confirm button to trigger the alert message
		String actualAlertMsg3 = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMsg3, expectedAlertMsg2);
				
		driver.switchTo().alert().dismiss(); //switch to alert then click Cancel/No
		
		driver.close();
		
		//End of Section 8
		

	}

}
