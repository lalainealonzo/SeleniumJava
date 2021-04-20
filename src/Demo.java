import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create driver object for chrome browser
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//WebDriver is an interface that Implements the Class ChromeDriver()
		//WebDriver is an interface provided by Selenium WebDriver.
		//Interface is a collection of abstract methods(methods without implementation)
		//WebDriver interface acts as a contract that each browser specific driver implements.
		//Creating a reference variable of type WebDriver assigns the driver object to different browser specific drivers.
		
		//RemoteDriver implements WebDriver interface, 
		//and ChromeDriver extends RemoteDriver. 
		//Here's the definition: 
		//public class ChromeDriver extends RemoteWebDriver implements org.openqa.selenium.TakesScreenshot
	
		driver.get("https://www.google.com/"); //visit URL
		System.out.println(driver.getTitle()); //Get page title
		
		System.out.println(driver.getCurrentUrl()); //will to validate if you landed on correct URL
		
		//System.out.println(driver.getPageSource()); //print page source
		
		driver.get("https://www.bing.com/"); //visit URL
		System.out.println(driver.getTitle()); //Get page title
		
		//Navigation
		driver.navigate().back(); //go back to previous page
		System.out.println(driver.getTitle()); //Get page title
		
		driver.close(); //closes the current browser
		//driver.quit(); //closes all the browsers/tabs opened by selenium script
	}

}
