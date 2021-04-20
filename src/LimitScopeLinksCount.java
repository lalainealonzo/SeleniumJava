import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LimitScopeLinksCount {

	public static void main(String[] args) throws InterruptedException {
		
		//Limiting WebDriver Scope
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//tagname a - anchor
		//Count no. of links on the site
		int actualLinkCount = driver.findElements(By.tagName("a")).size();
		int expectedLinkCount = 27;
		System.out.println(actualLinkCount);
		
		Assert.assertEquals(actualLinkCount, expectedLinkCount);
		
		//Limiting WebDriver Scope
		//create driver subset
		//Count no. of links on the footer only
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //footer
		int footerLinksCount = footerdriver.findElements(By.tagName("a")).size(); //count links in the footer
		System.out.println(footerLinksCount);
		
		//Count no. of links on the footer - column 1 only
		WebElement footerdrivercol1 = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //footer column 1
		int footerLinksCount2 = footerdrivercol1.findElements(By.tagName("a")).size(); //count links in the footer column 1
		System.out.println(footerLinksCount2);
		
		//Click on each link on the footer - column 1 and check if pages are opening thru new tab (ctrl + enter)
		
		
		for(int i=1; i<footerLinksCount2; i++) //i is index
		{
			String clickOnLinkTab = Keys.chord(Keys.ENTER, Keys.CONTROL); //keys ctrl + enter
			footerdrivercol1.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab); //will open all links in new windows
			
		}
		
		Set<String> windows = driver.getWindowHandles(); //get window IDs
		Iterator<String> it = windows.iterator(); //iterate
		
		while(it.hasNext()) { //if next window is present
			driver.switchTo().window(it.next()); //navigating to each tab
			System.out.print(driver.getTitle()); //print the title per tab
		}
		
	
		//driver.quit();
		
		
		
		

	}

}
