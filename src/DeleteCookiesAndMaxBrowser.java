import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookiesAndMaxBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//lalainealonzo//Documents//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize window

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().deleteAllCookies(); //deleting all the cookies
		
		driver.manage().deleteCookieNamed("sessionKey"); //delete particular cookie name
		
		
		
		

	}

}
