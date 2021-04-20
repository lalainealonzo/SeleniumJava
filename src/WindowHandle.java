import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//child windows - another window that was opened thru the parent window
		
		//switch to child window to get the email ID then go back to parent page to paste the email id
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/"); //parent window
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click(); 
		
		Set<String> windows = driver.getWindowHandles(); //get window IDs [parentID, childID]
		
		//pull the window id from the Set thru Iterator
		Iterator<String> it = windows.iterator();
		String parentID = it.next(); //method to get the 0 index (parentID)
		String childID = it.next(); //method to get the 1 index (childID)
		
		
		driver.switchTo().window(childID); //pass the string id of the window you want to switch
		
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText()
				.split("at")[1] //get index 1
				.trim()
				.split(" ")[0]; //get index 0
				
		System.out.println(emailID);
		
		driver.switchTo().window(parentID); //switch back to parent window
		
		driver.findElement(By.id("username")).sendKeys(emailID); //then enter the email ID in username
		
		//Please email us at mentor@rahulshettyacademy.com with below template to receive response
		//mentor@rahulshettyacademy.com with below template to receive response
		//mentor@rahulshettyacademy.com
		
		driver.quit();

	}

}
