import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click(); //parent window
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String parentID = it.next(); 
		String childID = it.next();
		
		driver.switchTo().window(childID); //switch to child window
		
		String childText = driver.findElement(By.cssSelector(".example")).getText();
		System.out.println(childText);
		
		driver.switchTo().window(parentID); //switch to parent window
		
		String parentText = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(parentText);
		

	}

}
