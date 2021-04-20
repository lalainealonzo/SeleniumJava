import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorIdentifiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin"); //username
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123"); //password
		
		boolean linkDisplayed = driver.findElement(By.linkText("Forgot your password?")).isDisplayed(); //true or false
		System.out.println(linkDisplayed);
		
		
		//driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click(); //login button
		
		driver.findElement(By.cssSelector("#btnLogin")).click(); //using CSS Selector
		
		driver.close();
		
		//Attribute or the locator should be unique
		//If the locator is used multiple times in the page, selenium will use the first one found (top left)
		//Class Name locator should not have spaces. syntax: By.className
		//XPath and CSS Selector can be defined in many possible ways
		//There is no direct way to get CSS in chrome
		
		//Validating xPath before applying in the script
		//Go to console tab, covert copied xPath into single quote
		//Then $x("//*[@id=\'btnLogin\']") - remove x for CSS Selectors
	}

}
